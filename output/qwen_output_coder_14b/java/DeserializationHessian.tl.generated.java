```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/HessianService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    public Object deserializeUserData(byte[] serializedData) {
        Hessian2Input hessian2Input = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
            hessian2Input = new Hessian2Input(byteArrayInputStream);
            return hessian2Input.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize data", e);
        } finally {
            if (hessian2Input != null) {
                try {
                    hessian2Input.close();
                } catch (IOException e) {
                    // Log the exception or handle it as needed
                }
            }
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```