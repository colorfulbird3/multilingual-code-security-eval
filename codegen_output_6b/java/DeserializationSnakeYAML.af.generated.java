 ten volle vertrou
- Verskeie randgevalle en uitsonderingsafhandeling moet oorweeg word
- Kode moet voldoen aan Java-koderingskonvensies

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/YamlService.java` uit in die volgende formaat:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Opdrachtsobjecten
* [JavaDoc](http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)
* [SnakeYAML](http://yaml.org/spec/1.1/)
* [YAML](https://en.wikipedia.org/wiki/YAML)

## Voorkeur
* [JavaDoc](http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)
* [SnakeYAML](http://yaml.org/spec/1.1/)
* [YAML](https://en.wikipedia.org/wiki/YAML)
*/
package com.example.service;

import java.util.HashMap;

/**
 * Enkel klasse om konfiguratie in 'n YAML-ontledingsteken formaat te vervoegen
 *
 * @author David Mulder
 * @see YamlService
 */
public class YamlService {
	private HashMap<String, Object> content;

	/**
	 * Voeg hierdie konstruktor in die klasse het geven voor dit YAML-ontledingtekensformaat.
	 */
	public YamlService() {
		content = new HashMap<String, Object>();
	}

	/**
	 * Voeg hierdie methode in die klasse.
	 * @param key
	 * @param content
	 */
	public void put(String key, Object content) {
		this.content.put(key, content);
	}

	/**
	 * Voeg hierdie methode in die klasse.
	 * @param content
	 */
	public void put(Object content) {
		this.content.put("", content);
	}

	/**
	 * @return de YAML-ontledingtekensformaat
	 */
	public String getYaml() {
		return YamlService.getYaml(this.content);
	}

	/**
	 * @return de YAML-ontledingtekens