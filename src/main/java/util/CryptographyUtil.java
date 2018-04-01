package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptographyUtil {

    public static String applySha256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(input.getBytes());
        return digest.digest().toString();
    }
}
