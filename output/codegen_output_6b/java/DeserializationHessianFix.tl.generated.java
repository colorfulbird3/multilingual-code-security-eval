/java/com/example/service/HessianService.java` sa sumusunod na format:

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

I-test ang isang deserialization service.

```
$ JAVA_HOME=/usr/java/jdk7/bin/java
$./gradlew run

Build #0:

[INFO] compile-time: java.naming.directory.default=${JAVA_HOME}/lib/jndi

[INFO] compiling: com.caucho.hessian.io.Hessian2Input.java

[INFO] compiling: com.example.service.DeserializationService.java

[INFO] compiling: com.example.service.HessianService.java

[INFO] compile-time: java.util.Arrays.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: sun.misc.Unsafe.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.util.zip.ZipFile.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.xml.bind.annotation.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.base.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.lang.reflect.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.net.URL.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.net.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.rmi.activation.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: java.sql.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: javax.activation.jar=${JAVA_HOME}/lib/rt.jar

[INFO] compile-time: javax.annotation.jar=${JAVA_HOME}/lib/rt.jar
