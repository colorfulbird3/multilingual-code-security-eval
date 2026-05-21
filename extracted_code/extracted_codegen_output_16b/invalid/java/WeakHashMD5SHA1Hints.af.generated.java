public static String digest(byte[] data, MessageDigest digest) {
    digest.reset();
    for (byte b : data) {
        digest.update(b);
    }
    return toHexString(digest.digest());
}