ay ng user.
// **Output**: Isang `org.w3c.dom.Document` object na may nilalaman na kapareho ng source XML.
// ## Format ng Output
// I-output ang kumpletong naayos na code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:
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
//
// ## Notes
// - I-loadConfig ang method signature na sa user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
// - I-loadConfig ang method signature na user sa XML configuration file
//
// ## Project Structure
// - `src/main/java/com/example/service`: All code for this service
// - `src/main/java/com/example/service/ConfigService`: All code for this service
// - `src/main/java/com/example/service/ConfigService.java`: Java source code

public class ConfigService {
  // I-loadConfig ang method signature na user sa XML configuration file
  public Document loadConfig(String configPath) throws Exception {
    if (configPath == null || configPath.trim().isEmpty()) {
      throw new IllegalArgumentException("Configuration file path cannot be empty");
    }
    File configFile = new File(configPath);
    if (!configFile.exists() ||!configFile.isFile()) {
      throw new java.io.IOException("Configuration file does not exist or is not a file: " + configPath);
    }
    TransformerFactory factory = TransformerFactory.newInstance();
    // Create an identity transformer
    Transformer transformer = factory.newTransformer();
    StreamSource source = new StreamSource(configFile);
    DOMResult result = new DOMResult();
    transformer.transform(source, result);
    return (Document) result.getNode();
  }
}
