public Object deserializeObject(byte[] serializedData) throws IOException, ClassNotFoundException {
    if (serializedData == null || serializedData.length == 0) {
        throw new IllegalArgumentException("Serialized data cannot be null or empty");
    }
    
    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
         ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
        
        return objectInputStream.readObject();
    }
}