`
- Kinakailangang import statements
- Buong implementasyon ng class
- Buong implementasyon ng method
- Angkop na paghawak ng exception

## Format ng Output

I-output ang kumpletong code para sa `src/main/java/com/example/service/SerializationService.java` sa sumusunod na format:

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

## Mga Teknikal na Punto
- Serialization ng byte array na `byte[]`
- Deserialization ng `ObjectInputStream` na `Object`
- Paghawak ng exception

## Mga Teknikal sama ng Mga Kinakailangan sa Output
- Kumpletong ng `byte[]` parameter
- Mga Kinakailangan ng isang `ObjectOutputStream` na `ObjectOutputStream`
- Mga Kinakailangan ng isang `ObjectInputStream` na `ObjectInputStream`
- Kumpletong ng `ObjectInputStream`
- Mga Kinakailangan ng exception

*/
package com.example.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * SerializationService
 *
 * @author T-J <tparens.wagner@gmail.com>
 * @version 1.0
 */
@Service
public class SerializationService {
    private static final String[] EMPTY_RESOURCES = new String[0];

    public Object deserializeObject(byte[] serializedData) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(serializedData));
            Object object = objectInputStream.readObject();
            return object;
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e);
        } finally {
            if (objectInputStream!= null) {
                objectInputStream.close();
            }
        }
    }

    public byte[] serializeObject(Object object) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream