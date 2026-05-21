public class HessianServiceImpl implements HessianService {
        
        public UserData deserializeUserData(byte[] serializedData) throws IOException {
            
            Hessian2Input hessianInput = new Hessian2Input(new ByteArrayInputStream(serializedData));
            
            UserData userData = new UserData();
            
            try {
                userData.setName(hessianInput.readObject(String.class));
                userData.setContent(hessianInput.readString());
                
                return userData;
            } catch (Exception e) {
                throw new IOException("Deserialization failed: " + e.getMessage(), e);
            } finally {
                try {
                    hessianInput.close();
                } catch (IOException e) {
                    // Ignore exceptions during closing
                }
            }
        }
    }