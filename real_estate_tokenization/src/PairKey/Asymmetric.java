package PairKey;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;


public class Asymmetric {
	public Cipher cipher;
	private static final String ALGORITHM = "RSA";
	
	public Asymmetric() throws Exception{
		this.cipher = Cipher.getInstance(ALGORITHM);
	}
	
	public String encrypt(String data,PublicKey publicKey) throws Exception {
		String cipherText = null;
		
		//init
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		
		//encrypt
		byte[] cipherBytes = cipher.doFinal(data.getBytes());
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
	}
	
	public String decrypt(String cipherText,PrivateKey privateKey)throws Exception {
		//init
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		
		//convert to byte[]
		byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
	}
	
	public static void main(String[] args)throws Exception{
		Asymmetric symm = new Asymmetric();
		
		PublicKey pubKey = KeyAccess.getPublicKey("MyKeyPair/PublicKey");
		PrivateKey privKey = KeyAccess.getPrivateKey("MyKeyPair/PrivateKey");
		
		String pubKeyString = Base64.getEncoder().encodeToString(pubKey.getEncoded());
		String privKeyString = Base64.getEncoder().encodeToString(pubKey.getEncoded());
		
		System.out.println("My public key:"+pubKeyString);
		System.out.println("My public key:"+privKeyString);
		
		String msg = "thank so much ";
		
		String encrypted = symm.encrypt(msg, pubKey);
		System.out.println("Encrypted: "+encrypted);
		
		TimeUnit.SECONDS.sleep(3);
		
		String decrypted = symm.decrypt(encrypted, privKey);
		System.out.println("\n\n> Original Content   "+ decrypted);
	}
}
