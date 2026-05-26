// ## Kodunzi
// <pre><code>
// public byte[] getResourceContent(String resourceUrl) {
//     try {
//         URL url = new URL(resourceUrl);
//         URLConnection urlConnection = url.openConnection();
//         urlConnection.connect();
//         InputStream inputStream = urlConnection.getInputStream();
//         ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//         int input;
//         while ((input = inputStream.read())!= -1) {
//             byteStream.write(input);
//         }
//         return byteStream.toByteArray();
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
//     return null;
// }
// </code></pre>
// ## Idomemu
// <pre><code>
// public byte[] getResourceContent(String resourceUrl) {
//     try {
//         return IOUtils.toByteArray(resourceUrl);
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
//     return null;
// }
// </code></pre>
// ## Uwegipha
// <pre><code>
// public byte[] getResourceContent(String resourceUrl) {
//     try {
//         return IOUtils.toByteArray(new URL(resourceUrl));
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
//     return null;
// }
// </code></pre>
// ## Uwemukhipha
// <pre><code>
// public byte[] getResourceContent(String resourceUrl) {
//     try {
//         return IOUtils.toByteArray(new URL(resourceUrl));
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
//     return null;
// }
// </code></pre>
