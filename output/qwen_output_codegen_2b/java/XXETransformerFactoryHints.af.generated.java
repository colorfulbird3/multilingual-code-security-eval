 in die volgende formaat:
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
// ```xml
// <result>
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
// </result>
// ```
// ```xml
// <result>
// <code>
// <path>
// path3
// </path>
// <content>
// <![CDATA[
// content3
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Tijlstelling
// - `loadConfig` op `loadConfig(String configPath)`
// - `ConfigService#normaliseConfig(Config config)`
// - `ConfigService#normaliseConfig(String configPath, Config config)`
//
// ## Laadende XML: configPath
// Voer `configPath` worden aan die gebruiker-voorsiene XML-lêer.
//
// ## XML-lêer
// Dat de ontwikkelen van XML-lêers uitwekomen, het ontwikkelen moet `loadConfig(String configPath)`
// voer. Bijvoorbeeld `loadConfig("test/config/test.config")`
//
// ## Laadende XML configPath
// Lokaal is de XML-lêer die gevraagd, en gebruik `loadConfig` om de XML uit te laden.
//
// ## XML-lêer
// Daar wordt de XML-lêer ook `loadConfig` met de `configPath` worden opgeeld, geeft deze XML-lêer een `Config`-structuur, waarop de `ConfigService` een `Config`-structuur gebruikt, en gebruikt de `ConfigService#normaliseConfig(String configPath, Config config)` met de `configPath` en de `Config`-structuur het geen normalisatie word vervangen.
