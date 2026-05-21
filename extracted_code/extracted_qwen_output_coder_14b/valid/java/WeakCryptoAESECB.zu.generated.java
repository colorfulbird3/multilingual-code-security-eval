import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESService {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    // Method to generate a secret key
    public static SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(n); // For AES, n must be 128, 192, or 256 bits
        return keyGen.generateKey();
    }

    // Method to encrypt data
    public static String encrypt(String data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt data
    public static String decrypt(String encryptedData, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Generate a secret key
            SecretKey secretKey = generateKey(128);

            // Data to encrypt
            String originalData = "Hello, World!";

            // Encrypt the data
            String encryptedData = encrypt(originalData, secretKey);
            System.out.println("Encrypted: " + encryptedData);

            // Decrypt the data
            String decryptedData = decrypt(encryptedData, secretKey);
            System.out.println("Decrypted: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}