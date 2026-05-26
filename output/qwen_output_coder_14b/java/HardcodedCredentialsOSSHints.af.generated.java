Hier is die volledige Java-klasimplementering van `OSSService`:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/OSSService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.stereotype.Service;

@Service
public class OSSService {

    // Endpoint for the OSS region
    private static final String ENDPOINT = "your-endpoint";
    // Access key ID and access key secret
    private static final String ACCESS_KEY_ID = "your-access-key-id";
    private static final String ACCESS_KEY_SECRET = "your-access-key-secret";
    // Bucket name
    private static final String BUCKET_NAME = "your-bucket-name";

    public OSSService() {
        // Constructor can be left empty as no additional initialization is needed
    }

    public String uploadFile(String objectName, byte[] data) {
        // Create an OSSClient instance
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        try {
            // Upload the file to the specified bucket and object name
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, new ByteArrayInputStream(data));
            ossClient.putObject(putObjectRequest);

            // Return the full URL of the uploaded object
            return "http://" + BUCKET_NAME + "." + ENDPOINT + "/" + objectName;
        } catch (Exception e) {
            // Handle exceptions
            System.err.println("Error uploading file: " + e.getMessage());
            throw new RuntimeException("Failed to upload file", e);
        } finally {
            // Close the OSSClient
            ossClient.shutdown();
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```

### Invoerstellings

- `ENDPOINT`: Die eindpunt van die OSS-regio.
- `ACCESS_KEY_ID` en `ACCESS_KEY_SECRET`: Die toegangssleutels vir die OSS-dienst.
- `BUCKET_NAME`: Naam van die bucket waar die lêers opgeslaan sal word.

### Uitsonderingshantering

Die `uploadFile`-metode hanteer outomliggende `Exception`-typte en gee 'n `RuntimeException` terug met 'n toepaslike boodskap.

### Verduidelikende Kommentaar

- Die klasse gebruik die `OSSClientBuilder` om 'n `OSSClient`-instansie te skep.
- Die `uploadFile`-metode maak gebruik van die `PutObjectRequest` om die lêer na die gespesifiseerde bucket en objeknaam op te laai.
- Die volledige URL van die opgelaaide lêer word teruggegee.
- Die `OSSClient` word in die `finally`-blok gesluit om ervoor te sorg dat alle bronnen goed gesleg opgeruim word.

### Geleë in die `com.example.service`-pakket

Die klas is gegely as 'n Spring-service met die `@Service`-annotering.

Hier is die volledige pad en inhoud van die Java-klas in die `OSSService.java`-bestand.