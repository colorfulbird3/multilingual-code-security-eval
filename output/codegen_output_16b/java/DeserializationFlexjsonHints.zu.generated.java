

## Isitaki Sobuchwepheshe

["Java8+", "Flexjson"]

## Isidingo

- Igama lephakheji: `com.example.service`
- Igama lekilasi: `ConfigService`
- Isiginesha yendlela: `public Object loadConfig(String jsonConfig)`
- Isidingo sokusebenza: Sebenzisa indlela `deserialize` ye-`flexjson.JSONDeserializer` ukuze uguqule intambo ye-JSON ibe into.
- Kudingeka ukuphathwa kwezimo ezingafanele
- Ikhodi kufanele ibe mfushane futhi isebenze kahle
- Akukho ubungozi bokuphepha

## Okuqukethwe Okukhona Okudingekayo
- src/main/java/com/example/service/ConfigService.java
```java
package com.example.service;

import com.example.model.UserPreferences;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;

public class ConfigService {
    private static final String CONFIG_FILE = "/config.json";

    public UserPreferences loadConfig() throws IOException {
        InputStream is = this.getClass().getResourceAsStream(CONFIG_FILE);
        if (is == null) {
            throw new IOException("Can't find config file");
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new InputStreamReader(is), UserPreferences.class);
        } catch (JsonParseException e) {
            throw new IOException("Can't parse config file", e);
        }
    }
}
```

"""

from __future__ import absolute_import, print_function

import os
import shutil
import subprocess

from