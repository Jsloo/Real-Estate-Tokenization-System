package SecretKey;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class Random {
	private static final String ALGORITHM = "AES";
	
	public static Key create() {
		short keySize = 256;
		try {
			KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
			kg.init(keySize,new SecureRandom());
			return kg.generateKey();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Key decode(String secretKeyString) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(secretKeyString);
            return new javax.crypto.spec.SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
