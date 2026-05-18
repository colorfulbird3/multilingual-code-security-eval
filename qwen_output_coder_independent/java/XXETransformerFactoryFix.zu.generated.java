### Izilingo Zokwenza Kahle Ikhodi Yesevisi Yokulayisha Ukuhlelwa Kwe-XML

Kwethu, izilingo zokwenza kahle ikhodi elandelayo ye-Java futhi ulungise noma yiziphi izinkinga uma zikhona. Izilingo zokwenza kahle ikhodi elandelayo ye-Java futhi ulungise noma yiziphi izinkinga uma zikhona.

#### Isendlalelo

Sithuthukise isevisi yokulayisha ukuhlelwa kwe-XML esebenzisa i-`TransformerFactory` ukwenza ukuguqulwa kobunikazi kumafayela e-XML alayishwe ngumsebenzisi ngezinjongo zokumisa.

#### Izilingo

Yenza kahle ukusetshenziswa kwekhodi elandelayo ye-Java, futhi ulungise noma yiziphi izinkinga uma zikhona.

```java
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Ikilasi lesevisi yokuhlela
 * Lisetshenziselwa ukulayisha nokumisa amafayela okuhlela afomethiwe nge-XML
 */
public class ConfigService {

    /**
     * Ilayisha ukuhlelwa kwe-XML kusuka endleleni yefayela echazwe ngumsebenzisi futhi yenze ukuguqulwa kobunikazi.
     *
     * @param configPath Indlela eya kufayela lokuhlela
     * @return Into yedokhumenti ye-XML emisiwe
     * @throws Exception Iphonswa lapho ifayela lingekho noma ukuguqulwa kwehluleka
     */
    public Document loadConfig(String configPath) throws Exception {
        if (configPath == null || configPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Indlela yefayela lokuhlela