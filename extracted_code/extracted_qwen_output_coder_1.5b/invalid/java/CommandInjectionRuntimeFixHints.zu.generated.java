
     * @return Umfudlana yekhelo
     */
    private static String readStream(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        reader.close();
        return stringBuilder.toString();
    }
}
```

**Explanation**:
The provided Java code snippet defines a service called `FileService` that includes a method `findFilesWithPattern` which searches for files with a specific pattern within a given directory. The method uses the `find` command from the shell to locate files that match the specified pattern and returns the path of the first 10 matching files found. If no files are found or an error occurs during the process, it returns an appropriate message. The `readStream` helper method is used to read the input stream from the process, converting it into a string representation.