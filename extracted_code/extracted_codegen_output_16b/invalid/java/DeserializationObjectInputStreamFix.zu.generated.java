```java
public static Object deserializeObject(byte[] serializedData) {
    Object obj = null;
    try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
         ObjectInputStream ois = new ObjectInputStream(bais)) {
        obj = ois.readObject();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return obj;
}
```