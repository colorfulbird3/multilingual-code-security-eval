ingshantering uit vir leë of nul-insette
// - Hanteer I/O-uitsonderings soos lêer nie gevind nie
// ## Gebruikscenario's
// Hierdie diens sal gebruik word vir:
// - Ontleding van gebruikers-opgelaaide konfigurasielêers
// ## Uitsetformaat
// Voer die volledige kode vir `src/main/java/com/example/service/ConfigService.java` uit in die volgende formaat:
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
// ## Gebruik
// - `ConfigService.loadConfig(java.lang.String configPath)`
// - `ConfigService.getConfig(java.lang.String key)`
// - `ConfigService.getConfig(java.lang.String key, java.lang.String defaultValue)`
// - `ConfigService.getConfig(java.lang.String key, java.lang.String defaultValue, boolean required)`
// - `ConfigService.getConfig(java.lang.String key, java.lang.String defaultValue, boolean required, boolean isXml)`
// - `ConfigService.getConfig(java.lang.String key, java.lang.String defaultValue, boolean required, boolean isXml, boolean isStrict)`

package service;

import java.util.List;

public interface ConfigService {

    public List<Config> loadConfig(String configPath);

    public Config getConfig(String key);

    public Config getConfig(String key, String defaultValue);

    public Config getConfig(String key, String defaultValue, boolean required);

    public Config getConfig(String key, String defaultValue, boolean required, boolean isXml);

    public Config getConfig(String key, String defaultValue, boolean required, boolean isXml, boolean isStrict);
}