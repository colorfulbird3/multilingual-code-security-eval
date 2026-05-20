public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String key = "your-secret-key"; // Ensure this key is securely stored and managed
            byte[] plaintextData = "Hello, World!".getBytes("UTF-8");

            String encryptedData = AESService.encrypt(key, plaintextData);
            Log.d("EncryptionResult", "Encrypted Data: " + encryptedData);

        } catch (Exception e) {
            Log.e("EncryptionError", "Error during encryption: " + e.getMessage());
        }
    }
}