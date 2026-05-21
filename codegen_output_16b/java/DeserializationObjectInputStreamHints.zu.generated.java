

## Ufumamahi
```java
public Function<String, Void> deserializeFunction() {
    return new Function<String, Void>() {
        @Override
        public Void apply(String from) {
            System.out.println(from);
            return null;
        }
    };
}

public static void main(String[] args) {
    try {
        Function<String, Void> deserializeFunction = deserializeFunction();
        deserializeFunction.apply("test");
    } catch (NullPointerException e) {
        System.out.println("Niekulawe");
    }
}
```

## Ufumamahi yokuqinisekisa
```java
public static void main(String[] args) {
    try {
        byte[] data = "test".getBytes();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        String test = (String) ois.readObject();
        System.out.println(test);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
```

## Ufumamahi ukuhlela ngokulandelana

```java
    /**
     * @param data byte[]
     * @return String
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static String deserializeObject(byte[] data) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return (String) ois.readObject();
    }
```

## Ufumamahi ukuhlela ngokulandelana ngenye ethi `byte[] serializedData`, okuyidatha ehleliwe ngokulandelana enikezwe umsebenzisi

```java
    public static void main(String[] args) {
        byte[] data = "test".getBytes();
        try {
            String test = deserializeObject(