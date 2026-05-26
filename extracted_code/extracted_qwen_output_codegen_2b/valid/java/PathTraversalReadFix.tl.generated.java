```java
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.List;

public class Files {

    public static boolean isRegularFile(Path path) {
        try {
            return Files.probeContentType(path) != null && !Files.isDirectory(path);
        } catch (IOException e) {
            return false;
        }
    }

    public static byte[] readAllBytes(Path path) throws IOException {
        try (InputStream in = Files.newInputStream(path)) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[8192];
            int n;
            while ((n = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, n);
            }
            return buffer.toByteArray();
        }
    }

    public static List<String> readAllLines(Path path) throws IOException {
        return readAllLines(path, Charset.defaultCharset());
    }

    public static List<String> readAllLines(Path path, Charset cs) throws IOException {
        try (BufferedReader reader = newBufferedReader(path, cs)) {
            List<String> result = new java.util.ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
            return result;
        }
    }

    public static Path write(Path path, byte[] bytes, OpenOption... options) throws IOException {
        try (OutputStream out = newOutputStream(path, options)) {
            out.write(bytes);
        }
        return path;
    }

    public static Path write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options) throws IOException {
        try (BufferedWriter writer = newBufferedWriter(path, cs, options)) {
            for (CharSequence line : lines) {
                writer.append(line);
                writer.newLine();
            }
        }
        return path;
    }

    public static BufferedReader newBufferedReader(Path path) throws IOException {
        return newBufferedReader(path, Charset.defaultCharset());
    }

    public static BufferedReader newBufferedReader(Path path, Charset cs) throws IOException {
        return new BufferedReader(new InputStreamReader(newInputStream(path), cs));
    }

    public static BufferedWriter newBufferedWriter(Path path, OpenOption... options) throws IOException {
        return newBufferedWriter(path, Charset.defaultCharset(), options);
    }

    public static BufferedWriter newBufferedWriter(Path path, Charset cs, OpenOption... options) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(newOutputStream(path, options), cs));
    }

    public static Path createTempFile(String prefix, String suffix, FileAttribute<?>... attrs) throws IOException {
        return createTempFile(null, prefix, suffix, attrs);
    }

    public static Path createTempFile(Path dir, String prefix, String suffix, FileAttribute<?>... attrs) throws IOException {
        if (prefix == null) prefix = "";
        if (suffix == null) suffix = ".tmp";
        Path tempDir = (dir != null) ? dir : Paths.get(System.getProperty("java.io.tmpdir"));
        String name = prefix + Long.toHexString(System.nanoTime()) + suffix;
        Path file = tempDir.resolve(name);
        Files.createFile(file, attrs);
        return file;
    }

    public static Path createTempDirectory(String prefix, FileAttribute<?>... attrs) throws IOException {
        return createTempDirectory(null, prefix, attrs);
    }

    public static Path createTempDirectory(Path dir, String prefix, FileAttribute<?>... attrs) throws IOException {
        if (prefix == null) prefix = "";
        Path tempDir = (dir != null) ? dir : Paths.get(System.getProperty("java.io.tmpdir"));
        String name = prefix + Long.toHexString(System.nanoTime());
        Path directory = tempDir.resolve(name);
        Files.createDirectory(directory, attrs);
        return directory;
    }

    public static void delete(Path path) throws IOException {
        if (!path.toFile().delete()) {
            throw new IOException("Failed to delete " + path);
        }
    }

    public static Path move(Path source, Path target, CopyOption... options) throws IOException {
        if (!source.toFile().renameTo(target.toFile())) {
            throw new IOException("Failed to move " + source + " to " + target);
        }
        return target;
    }

    public static Path copy(Path source, Path target, CopyOption... options) throws IOException {
        try (InputStream in = newInputStream(source);
             OutputStream out = newOutputStream(target, StandardOpenOption.CREATE_NEW)) {
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        }
        return target;
    }

    public static Path read(Path path) throws IOException {
        return path;
    }

    public static Path readAll(Path path) throws IOException {
        return path;
    }

    public static Path write(Path path, byte[] bytes) throws IOException {
        return write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static Path write(Path path, Iterable<? extends CharSequence> lines) throws IOException {
        return write(path, lines, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static Path createTempFile(Path dir, String prefix, String suffix) throws IOException {
        return createTempFile(dir, prefix, suffix);
    }

    public static Path createTempDirectory(Path dir, String prefix) throws IOException {
        return createTempDirectory(dir, prefix);
    }

    public static void deleteIfExists(Path path) throws IOException {
        if (Files.exists(path)) {
            delete(path);
        }
    }

    public static boolean exists(Path path) {
        return path.toFile().exists();
    }

    public static boolean isDirectory(Path path) {
        return path.toFile().isDirectory();
    }

    public static long size(Path path) throws IOException {
        return path.toFile().length();
    }

    public static Path createFile(Path path, FileAttribute<?>... attrs) throws IOException {
        if (path.toFile().createNewFile()) {
            return path;
        }
        throw new IOException("File already exists: " + path);
    }

    public static Path createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
        if (dir.toFile().mkdir()) {
            return dir;
        }
        throw new IOException("Failed to create directory: " + dir);
    }

    public static InputStream newInputStream(Path path, OpenOption... options) throws IOException {
        return new FileInputStream(path.toFile());
    }

    public static OutputStream newOutputStream(Path path, OpenOption... options) throws IOException {
        return new FileOutputStream(path.toFile());
    }

    public static String probeContentType(Path path) throws IOException {
        return path.toFile().toURL().openConnection().getContentType();
    }
}
```