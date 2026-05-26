atamatai: " + e.getMessage());
// }
// }
//
// public static byte[] decrypt(String key, String encrypted) throws Exception {
// if (key == null || key.isEmpty()) {
// throw new IllegalArgumentException("Ukhiye wokubethela awukwazi ukuba ungenalutho.");
// }
// if (encrypted == null || encrypted.isEmpty()) {
// throw new IllegalArgumentException("Ipuya umbhalo obethelwe njengeyunithi yezinhlamvu ye-hexadecimal ngemva kokubethela.");
// }
// try {
// // I-AES isekela okhiye abangamabhithi angu-128, 192, no-256; lapha sisebenzisa amabhithi angu-256 (ama-byte angu-32)
// byte[] keyBytes = new byte[32];
// System.arraycopy(key.getBytes("UTF-8"), 0, keyBytes, 0, keyBytes.length);
// SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
// Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
// cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
// byte[] decryptedBytes = cipher.doFinal(hexStringToBytes(encrypted));
// return decryptedBytes;
// } catch (Exception e) {
// // Bamba bese uphinda uphoiceyunithi yezinhlamvu ye-hexadecimal ngemva kokubethela
// throw new Exception("Ukubethela nge-AES katamatai: " + e.getMessage());
// }
// }
//
// private static byte[] hexStringToBytes(String s) throws NoSuchAlgorithmException {
// byte[] b = new byte[s.length() / 2];
// for (int i = 0; i < b.length; i++) {
// int index = i * 2;
// b[i] = (byte) ((Character.digit(s.charAt(index), 16) << 4) + Character.digit(s.charAt(index + 1), 16));
// }
// return b;
// }
// }
//
// public static void main(String[] args) throws Exception {
// String key = "uKubuKethela";
// byte[] data = "Aekibha nge-AES".getBytes("UTF-8");
// System.out.println("data-size: " + data.length);
// System.out.println("key-size: " + key.length());
// System.out.println("I-AES-encrypt: " + AESService.encrypt(key, data));
// System.out.println("I-AES-decrypt: " + AESService.decrypt(key, AESService.encrypt(key, data)));
// }