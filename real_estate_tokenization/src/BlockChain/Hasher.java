package BlockChain;

import java.security.MessageDigest;
import java.util.Base64;

public class Hasher {
	public static String md5(String input) 
	 { 
	 return hash( input, "MD5" ); 
	 }
	
	public static String md5(String input, byte[] salt) 
	 { 
	 return hash( input,salt, "MD5" ); 
	 }
	
	public static String sha256(String input) 
	 { 
	 return hash( input, "SHA-256" ); 
	}
	
	public static String sha384(String input) 
	 { 
	 return hash( input, "SHA-384" ); 
	}
	
	public static String sha512(String input) 
	 { 
	 return hash( input, "SHA-512" ); 
	}
	
	private static String hash(String input, String algorithm) { 
		String hashCode = ""; 
		try { 
			MessageDigest md = MessageDigest.getInstance(algorithm); 
			md.update( input.getBytes() ); 
			//digesting... 
			byte[] hashBytes = md.digest(); 
			//convert the byte[] to String 
			//1) 
			hashCode = Base64.getEncoder().encodeToString(hashBytes); 
			//2) hex format output - recommended! 
			//hashCode = Hex.encodeHexString(hashBytes); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return hashCode; 
	}
	
	private static String hash(String input,byte[] salt,String algorithm) { 
		String hashCode = ""; 
		try { 
			MessageDigest md = MessageDigest.getInstance(algorithm); 
			md.update( input.getBytes() ); 
			md.update(salt);
			//digesting... 
			byte[] hashBytes = md.digest(); 
			//convert the byte[] to String 
			//1) 
			hashCode = Base64.getEncoder().encodeToString(hashBytes); 
			//2) hex format output - recommended! 
			//hashCode = Hex.encodeHexString(hashBytes); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return hashCode; 
	}
}
