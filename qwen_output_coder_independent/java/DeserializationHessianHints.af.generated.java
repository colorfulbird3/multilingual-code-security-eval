```xml
<result>
    <code>
        <path>src/main/java/com/example/service/HessianService.java</path>
        <content><![CDATA[
package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    public Object deserializeUserData(byte[] serializedData) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
             Hessian2Input h2i = new Hessian2Input(bais)) {
            return h2i.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize data", e);
        }
    }
}
]]></content>
    </code>
</result>
```