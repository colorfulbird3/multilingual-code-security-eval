ga kaso
// - At na `ZipService` class definition
// - Ang kopna ng `extractZipFile` method
// - Ang kopna ng `extractZipFile` method
// - Ang kopna ng `ZipService.extractZipFile` method
// - Ang code ay dapat maging concise, efficient, at madaling i-maintain

/**
 * @author jacob
 */
public class ZipService {

    private String zipFilePath;

    private String extractPath;

    public ZipService(String zipFilePath, String extractPath) {
        this.zipFilePath = zipFilePath;
        this.extractPath = extractPath;
    }

    public List<String> extractZipFile() {
        List<String> extractedFiles = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry())!= null) {
                String fileName = entry.getName();
                File file = new File(extractPath, fileName);
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    // Ensure parent directory exists
                    File parent = file.getParentFile();
                    if (parent!= null &&!parent.exists()) {
                        parent.mkdirs();
                    }
                    // Write file content
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                    extractedFiles.add(file.getAbsolutePath());
                }
                zipInputStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extractedFiles;
    }

    public static void main(String[] args) {
        ZipService zipService = new ZipService(
                "C:\\Users\\jkirill\\AppData\\Local\\Google\\Chrome\\Application\\src\\com\\example\\service\\ZipService.zip",
                "C:\\Users\\jkirill\\AppData\\Local\\Google\\Chrome\\Application\\src\\com\\example\\service\\ZipService\\");
//        ZipService zipService = new ZipService(
//                "C:\\Users\\jkirill\\AppData\\Local\\Google\\Chrome\\Application\\src\\com\\example\\service\\ZipService.zip",
//                "C:\\Users\\jkirill\\AppData\\Local\\Google\\Chrome\\Application\\src\\com\\example\\service\\ZipService\\");
        System.out.println(zipService.extractZipFile());
    }
}
