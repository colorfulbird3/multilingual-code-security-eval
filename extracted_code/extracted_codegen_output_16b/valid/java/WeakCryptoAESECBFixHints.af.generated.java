import com.example.service.AESService;

public class App {
    public static void main(String[] args) {
        AESService aesService = new AESService();
        String encryptedContent = aesService.encrypt("12345678", "Some text to encrypt".getBytes("UTF-8"));
        System.out.println(encryptedContent);
    }
}