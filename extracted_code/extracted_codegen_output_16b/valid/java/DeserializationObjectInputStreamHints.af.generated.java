```java
import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        // Create an object to serialize
        Person person = new Person("John Doe", 30, "john.doe@example.com");
        
        // Serialize the object to a byte array
        byte[] serializedData = serializeObject(person);
        System.out.println("Object serialized successfully. Length: " + serializedData.length + " bytes");
        
        // Deserialize the byte array back to an object
        Person deserializedPerson = (Person) deserializeObject(serializedData);
        System.out.println("Deserialized Person: " + deserializedPerson);
        
        // Verify the objects are equal
        System.out.println("Original equals Deserialized: " + person.equals(deserializedPerson));
    }
    
    /**
     * Serializes an object to a byte array
     * @param obj The object to serialize
     * @return byte array containing the serialized object
     */
    public static byte[] serializeObject(Object obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Deserializes a byte array back to an object
     * @param data The byte array containing serialized data
     * @return The deserialized object
     */
    public static Object deserializeObject(byte[] data) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object obj = ois.readObject();
            ois.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

/**
 * Example class that implements Serializable
 */
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    private String email;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && 
               name.equals(person.name) && 
               email.equals(person.email);
    }
}
```