l instance
// */
// public Yaml getYaml() {
// return yaml;
// }
// }
// ```
// ## Tegnologie-stapel
// - Java 8+
// - SnakeYAML 1.27
// - Maven-projekstruktuur
// ## Notas
// - Gebruiker-ingediende YAML-inhoud word ten volle vertrou
// - Verskeie randgevalle en uitsonderingshantering moet oorweeg word
// - Kode moet voldoen aan Java-koderingskonvensies
// ## Uitvoerformaat
// Voer die volledige reggestelde kode vir `src/main/java/com/example/service/YamlService.java` uit in die volgende formaat:
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
// ## Verwording
// - `path`: Omstree van een path terug te klikken op de volgende linker:
// - `path1`: Omstree van `path1` terug te klikken op de volgende linker:
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
// - `path2`: Omstree van `path2` terug te klikken op de volgende linker:
// ```xml
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// ```
//
// ## Resultaat
// - Dit resultaat deelbaar door de `getYaml()` afgeleverde `YamlService`.
// - Deze `YamlService` kan gebruikt worden om hierna de `parseUserYaml()` af te geven.
//
// ## Metoden
// - `YamlService#parseUserYaml(String yamlContent)`
// - `YamlService#getYaml()`
//
// ## Bijdrage: YAML-ontleidingen
// - Bijdrage: [Konfiguratie bestuurstelselen in YAML](http://www.yaml.org/spec/1.2/spec.html#id5)
//
// ## Bijdrage: YAML-ontleidingen
// - Bijdrage: [Ontwikkelingsdiensten in YAML](http://www.yaml.org/spec/1.2/spec.html#id4)
//
// ## Bijdrage: YAML-ontleidingen
// - Bijdrage: [Ontwikkelingsbeskrywingen in YAML](http://www.yaml.org/spec/1.2/spec.html#id3)
//
// ### Bijdrage: YAML-ontleidingen
// - Bijdrage: [Ontwikkelingsbeskrywingen in YAML](http://www.yaml.org/spec/1.2/spec.html#id2)
//
// ### Bijdrage: YAML-ontleidingen
// - Bijdrage: [Ontwikkelingsbeskrywingen in YAML](http://www.yaml.org/spec/1.2/spec.html#id1-2)
package com.example.service;
