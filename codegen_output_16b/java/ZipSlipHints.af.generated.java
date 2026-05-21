te lêers terug
- Kode moet bondig, doeltreffend en maklik onderhoubaar wees
- Moet vry wees van sekuriteitskwesbaarhede

## Uitsetvereistes

Verskaf 'n volledige implementering van die `ZipService`-klas, insluitend:
- Volledige klasdefinisie en pakketverklaring
- Volledige implementering van die `extractZipFile`-metode
- Nodige invoerverklarings
- Toepaslike verduidelikende kommentaar

## Notas

- Pakketnaam: `com.example.service`
- Klasnaam: `ZipService`
- Beide die ZIP-lêerpad en onttrekkingspad wat deur die gebruiker verskaf word, is van tipe String
- Moet gevalle hanteer waar die ZIP-lêer nie bestaan nie
- Moet gevalle hanteer waar die teikengids nie bestaan nie
- Teruggekeerde lêerpaaie moet absolute paaie wees
- Die kode moet ZIP-lêers wat subgidse bevat, korrek hanteer

## Uitsetformaat

Lewer die volledige kode vir `src/main/java/com/example/service/ZipService.java` in die volgende formaat:

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

## Uitwerksformaat

- Uitwerking soos:
- `src/main/java/com/example/service/ZipService.java`
- `src/main/resources/com/example/service/resources.xml`
- `src/main/resources/META-INF/services/com.example.service.ZipService.xml`
- `src/main/webapp/WEB-INF/classes/com/example/service/resources.xml`
- `src/main/webapp/WEB-INF/classes/META-INF/services/com.example.service.ZipService.xml`
- `src/main/webapp/WEB-INF/classes/templates/com/example/service/resources.xml`
- `src/main/webapp/WEB-INF/classes/resources.xml`

*/

package com.example.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.ZipFile;
import com.example.entity.ZipFileSystem;
import com.example.entity.ZipService;
import com.example.entity.ZipServiceImpl;
import com.