code>
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

## Sample Execution

- Open terminal in project folder: `samples/java/com/example/service/RemoteResourceService.java`
- Execute using command line: `mvn clean package -pl samples/java/com/example/service`
- To run in IntelliJ IDEA: Run `RemoteResourceService.java`
- In IntelliJ IDEA, right click on `RemoteResourceService.java` and select `Run Configuration...`
- Select a debug configuration
- In the debug configuration, select the `RemoteResourceService.java` class
- In VM arguments, add `-Ddebug=true`
- Run!

## References

- `https://github.com/mashupbrains/tutsplus/blob/master/src/samples/java/com/example/service/RemoteResourceService.java`
- `http://commons.apache.org/proper/commons-io/javadocs/api-release/org/apache/commons/io/IOUtils.html#toByteArray(java.io.InputStream)`
- `https://stackoverflow.com/questions/33205718/get-resource-on-the-server-using-java`
- `https://stackoverflow.com/questions/35015825/java-classloader-in-javadoc`
- `http://www.mkyong.com/java/how-to-get-resource-in-java-web-application/`
