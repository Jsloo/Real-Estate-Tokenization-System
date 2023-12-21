package SecretKey;

import java.security.Key;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;

public class Symmetric {
	private Cipher cipher;
	private static final String ALGORITHM = "AES";

	public Symmetric() throws Exception {
		this.cipher = Cipher.getInstance(ALGORITHM);
	}
	
	public String encrypt(String data, Key key)throws Exception{
		String cipherText = null;
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] cipherBytes = cipher.doFinal(data.getBytes());
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
	}
	
	public String decrypt(String cipherText, Key key)throws Exception{
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
	}
	
	
}	
