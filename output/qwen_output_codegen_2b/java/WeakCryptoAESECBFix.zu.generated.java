
// /**
// * Sikinhali izindingo ukuze sibhelekhelelela ukukwimiyalezo ngeseva ngokusekelwe ekubetheleni nge-AES.
// */
// public static byte[] decrypt(String key, String data) throws Exception {
// try {
// // Sikinhali egyizinhali ukuze sibhelekhelelela ukukwimiyalezo ngeseva ngokusekelwe ekubetheleni nge-AES
// byte[] keyBytes = (key + "").getBytes("UTF-8");
// SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
// Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
// cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
// byte[] encryptedBytes = cipher.doFinal(hex2bytes(data));
// // Guqula i-array yamabhayithi abethelwe ibe iyunithi yezinhlamvu ye-hexadecimal
// StringBuilder sb = new StringBuilder();
// for (byte b : encryptedBytes) {
// sb.append(String.format("%02x", b));
// }
// return sb.toString().getBytes("UTF-8");
// } catch (Exception e) {
// // Bamba uphinde uphonse ukuphazamiseka ngemininingwane eyengeziwe yephutha
// throw new Exception("Ukubethela nge-AES kwehlulekile: " + e.getMessage(), e);
// }
// }
// // ### Isendlalelo
// // ### Isendlalelo
// /**
// * Sikinhali izindingo ukuze sibhelekhelelela ukukwimiyalezo ngeseva ngokusekelwe ekubetheleni nge-AES.
// */
// /**
// * I-AES kwehlulekile
// */
// public static String hex2bytes(String str) throws Exception {
// if (str == null || str.isEmpty()) {
// throw new IllegalArgumentException("Hlanganisa izengiye amabhayithi angu-128 (amabhayithi angu-16) noma angu-256 (amabhayithi angu-32) ukuze isetshenziswe njengokhiye we-AES");
// }
// byte[] raw = str.getBytes("UTF-16");
// int len = raw.length;
// if (len % 2!= 0) {
// throw new IllegalArgumentException("Hlanganisa izengiye amabhayithi angu-128 (amabhayithi angu-16) noma angu-256 (amabhayithi angu-32) ukuze isetshenziswe njengokhiye we-AES");
// }
// byte[] data = new byte[len / 2];
// System.arraycopy(raw, 0, data, 0, len / 2);
// return bytes2hex(data);
// }
// /**
// * Ikilasi hokubethela ibe ngokusekelwe ekubethela.
// *
// * @param key  Iyunithi yezinhlamvu yokhiye wokubethela.
// * @param data I-array yamabhayithi yaziziphi izindingo i-AES
// * @return Ibuyisela umbhalo obethelwe (ciphertext) njengeyunithi yezinhlamvu ye-hexadecimal ngemva kokubethela.
// * @throws Exception Noma yikiphi ukuphazamiseka nge-AES
// */
// public static String encrypt(String key, String data) throws Exception {
// return bytes2hex(cipher(key, data));
// }
// /**
// * Sikinhali egyizinhali ukuze sibhelekhelelela ukukwimiyalezo ngeseva ngokusekelwe ekubethela.
//