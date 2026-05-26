 ## Uitsetformaat
// Lewer die volledige kode vir `src/main/java/com/example/service/ZipService.java` in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Het volledige zip-pakket
// ```xml
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// ```
// ## Zip-pakketbestaanstoff
// ```xml
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// ```
// ## Zip-pakketbestaanstoff
// ```xml
// <code>
// <path>
// path1
// </path>
// <content>
    // <![CDATA[
    // content1
    // ]]>
    // </content>
    // </code>
// ```
// ## Zip-pakketbestaanstoff
// ```xml
// <code>
// <path>
// path1
// </path>
// <content>
    // <![CDATA[
    // content1
    // ]]>
    // </content>
    // </code>
// ```
// ## Zip-pakketbestaanstoff
// ```xml
// <code>
// <path>
// path1
// </path>
    // <content>
    // <![CDATA[
    // content1
    // ]]>
    // </content>
    // </code>
// ```

public class ZipService {

    public List<String> extractZipFile(String zipFilePath, String extractPath) {
        List<String> result = new ArrayList<>();
        ZipFile zipFile = new ZipFile(zipFilePath);
        Enumeration<? extends ZipEntry> zipEntryEnum = zipFile.entries();
        while (zipEntryEnum.hasMoreElements()) {
            ZipEntry zipEntry = zipEntryEnum.nextElement();
            try (InputStream inputStream = zipFile.getInputStream(zipEntry)) {
                byte[] buffer = new byte[1024];
                int len;
                try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(extractPath + "/" + zipEntry.getName()))) {
                    while ((len = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, len);
                    }
                    inputStream.close();
                    outputStream.close();
                    result.add(zipEntry.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
