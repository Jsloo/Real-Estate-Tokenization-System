package BlockChain;

import java.security.MessageDigest;
import java.util.Base64;

public class Hasher {
	public static String sha256(String input) 
	 { 
	 return hash( input, "SHA-256" ); 
	}
	
	private static String hash(String input, String algorithm) { 
		String hashCode = ""; 
		try { 
			MessageDigest md = MessageDigest.getInstance(algorithm); 
			md.update( input.getBytes() ); 
 
			byte[] hashBytes = md.digest(); 
			hashCode = Base64.getEncoder().encodeToString(hashBytes); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return hashCode; 
	}
}
