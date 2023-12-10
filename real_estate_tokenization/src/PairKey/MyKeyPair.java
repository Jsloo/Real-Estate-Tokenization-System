package PairKey;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;


public class MyKeyPair {
	
	private static String ALGORITHM = "RSA";
	public KeyPairGenerator keygen;
	public KeyPair keyPair;
	public static PublicKey publicKey;
	public static PrivateKey privateKey;
	
	public MyKeyPair() {
		try {
			keygen = KeyPairGenerator.getInstance(ALGORITHM);
		}catch(Exception e) {
			
		}
	}
	
	public static PublicKey getPublicKey() {
        return publicKey;
    }
	
	public static PrivateKey getPrivateKey() {
        return privateKey;
    }
	
	public static void create() {
		MyKeyPair keyMaker = new MyKeyPair();
		
		//generate keypair
		keyMaker.keyPair = keyMaker.keygen.generateKeyPair();
		
		//get public key
		publicKey = keyMaker.keyPair.getPublic();
		
		//get private
		privateKey = keyMaker.keyPair.getPrivate();
		
		
	}
	
	public static void put(byte[] keyBytes, String path) {
		File f = new File(path);
		f.getParentFile().mkdirs();
		try {
			Files.write(Paths.get(path), keyBytes, StandardOpenOption.CREATE);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void genKeyPair(String id, String role) {
		MyKeyPair.create();
		byte[] publicKey = MyKeyPair.getPublicKey().getEncoded();
		byte[] privateKey = MyKeyPair.getPrivateKey().getEncoded();
		
		MyKeyPair.put(publicKey, "KeyPair/" + role +"/"+ id + "/PublicKey");
		MyKeyPair.put(privateKey, "KeyPair/" + role +"/"+ id + "/PrivateKey");
	}
	
}
