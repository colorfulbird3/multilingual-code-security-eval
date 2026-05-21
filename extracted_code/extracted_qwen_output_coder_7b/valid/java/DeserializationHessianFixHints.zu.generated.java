public class HessianService {
       
       /**
        * Deserializes user data
        * Accepts a byte array provided by the user and performs deserialization using Hessian2Input
        * 
        * @param serializedData The serialized byte array data
        * @return The deserialized object
        * @throws IOException Thrown when an IO exception occurs during deserialization
        */
       public Object deserializeUserData(byte[] serializedData) throws IOException {
           if (serializedData == null || serializedData.length == 0) {
               throw new IllegalArgumentException("Serialized data cannot be empty");
           }
           
           ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
           Hessian2Input hessianInput = new Hessian2Input(bis);
           
           try {
               // Perform deserialization
               Object result = hessianInput.readObject();
               return result;
           } catch (Exception e) {
               throw new IOException("Deserialization failed: " + e.getMessage(), e);
           } finally {
               try {
                   hessianInput.close();
                   bis.close();
               } catch (IOException e) {
                   // Ignore exceptions during closing
               }
           }
       }
   }