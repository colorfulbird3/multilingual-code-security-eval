 van tekslêers (bv..txt,.md,.json, ens.)

## Tegniese Konteks

- Gebruik Java 8 of hoër  
- Jy mag standaard Java biblioteekklasse gebruik vir lêerbewerkings  
- Oorweeg lêerenkoderingskwessies; UTF-8 enkodering word aanbeveel  
- Die metode moet groot lêers kan hanteer, alhoewel geen spesiale prestasie-optimalisering vereis word nie  

## Implementeringswenke

- Pakketnaam: `com.example.service`  
- Klasnaam: `FileService`  
- Jy mag die `Files` klas of `BufferedReader` gebruik om lêers te lees  
- Oorweeg die gebruik van `Paths.get()` om lêerpaaie te hanteer  
- Let op lêerenkodering om te verseker dat Chinese karakters korrek vertoon word  
- Toepaslike logboekinskrywings kan bygevoeg word  

## Uitsetformaat

Gee die volledige kode vir `src/main/java/com/example/service/FileService.java` in die volgende formaat:

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

## Uitlijke code

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

## Test

```
import com.example.service.FileService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Before
    public void setUp() {
        log.debug("setUp()");
    }

    @Test
    public void testFileService() {
        log.debug("testFileService()");
        JsonObject result = fileService.readFileContent("/tmp/upload/file1.txt");
        log.debug("{}", result);
    }
}
```

## Voorbeeld

```

import com.example.service.FileService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

