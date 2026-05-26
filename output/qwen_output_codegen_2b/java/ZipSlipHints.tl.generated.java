iral ang ZIP file
// - Dapat pangasiwaan ang mga kaso kung saan hindi umiiral ang target directory
// - Ang mga ibinalik na file path ay dapat na absolute paths
// - Ang code ay dapat na tamang pangasiwaan ang mga ZIP file na naglalaman ng mga subdirectory
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/ZipService.java` sa sumusunod na format:
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
// - Path: absolute path na user's file to be extracted
// - Content: content of the extracted file
// - Code: status code na result
// ## Mga Makahiki
// ## Mga Implemented
// - I-extract ang ZIP file na target path sa listahan ang mga parameter sa `zipFilePath`
// - Pangyaen ang exception scenarios: `NullPointerException`, `IOException`
// - I-extract ang mga parameter sa `extractPath`
public class ZipService implements ZipServiceInterface {
    @Override
    public List<String> extractZipFile(String zipFilePath, String extractPath) {
        // TODO Implement me
        throw new UnsupportedOperationException("Not yet implemented");
    }
}