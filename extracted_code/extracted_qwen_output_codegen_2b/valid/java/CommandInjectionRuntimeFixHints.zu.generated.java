a: Azitholakalanga amafayela afanayo.
" + e.getMessage();
}
}
private String readStream(InputStream stream) throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
StringBuilder sb = new StringBuilder();
String line;
while ((line = reader.readLine())!= null) {
sb.append(line);
}
return sb.toString();
}
public static void main(String[] args) {
String file = "../Test/Test.java";
String pattern = "*.java";
System.out.println(findFilesWithPattern(file, pattern));
}
}