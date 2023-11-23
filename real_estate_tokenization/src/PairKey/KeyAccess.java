package PairKey;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


public class KeyAccess {
	public static PublicKey getPublicKey(String path) throws Exception{
		byte[] keyBytes = Files.readAllBytes(Paths.get(path));
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePublic(spec);
	}
	
	public static PrivateKey getPrivateKey(String path) throws Exception{
		byte[] keyBytes = Files.readAllBytes(Paths.get(path));
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePrivate(spec);
	}
	
	public static void main(String[] args) throws Exception{
		PublicKey pubKey = KeyAccess.getPublicKey("MyKeyPair/PublicKey");
		PrivateKey privKey = KeyAccess.getPrivateKey("MyKeyPair/PrivateKey");
		
		System.out.println("Public Key= "+ Base64.getEncoder().encodeToString(pubKey.getEncoded()));
		System.out.println("Private Key= "+ Base64.getEncoder().encodeToString(privKey.getEncoded()));

	}
}
