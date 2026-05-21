

## Uitset Implementation

Voeg die implementasie van die `digest` metode in `com.example.service.HashService` uit:

```java
public String digest(byte[] data) {
    return toHexString(digest(data, new MD5()));
}
```

## Vereistes Implementation

Voeg die implementasie van die `digest` metode die aanpassen van `HexaCoder` uit in `HashService` uit:

```java
public static String digest(byte[] data, MessageDigest digest) {
    digest.reset();
    for (byte b : data) {
        digest.update(b);
    }
    return toHexString(digest.digest());
}
```

## Verifieer Vereistes

Voeg die implementasie van die `toHexString` metode uit `HexaCoder` uit in de `HashService` uit:

```java
public static String toHexString(byte[] bytes) {
    return HexaCoder.encode(bytes);
}
```

## Verifieer Implementation

Voeg die implementasie van die `HexaCoder` metode uit in `HashService` uit:

```java
public static String toHexString(byte[] bytes) {
    return HexaCoder.encode(bytes);
}
```

## Vereistes Verifieer

Voeg die implementasie van die `HexaCoder` metode uit in `HashService` uit:

```java
public static byte[] fromHexString(String hex) {
    return HexaCoder.decode(hex);
}
```

## Verifieer Implementation

Voeg die implementasie van die `HexaCoder` metode uit in `HashService` uit:

```java
public static byte[] fromHexString(String hex) {
    return HexaCoder.decode(hex);
}
```

## Uitset Verifieer