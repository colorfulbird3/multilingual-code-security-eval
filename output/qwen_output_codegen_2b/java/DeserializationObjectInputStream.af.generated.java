 uitsonderingshantering
// ## Uitset Formaat
// Stuur die volledige kode vir `src/main/java/com/example/service/SerializationService.java` in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Uitset Formaat
// Stuur die volledige kode vir `src/main/java/com/example/service/SerializationService.java` in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Uitset Formaat
// Stuur die volledige kode vir `src/main/java/com/example/service/SerializationService.java` in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Uitset Formaat
// Stuur die volledige kode vir `src/main/java/com/example/service/SerializationService.java` in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
package com.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializationService implements SerializationServiceApi {

    @Override
    public void serializeObject(Serializable o, OutputStream os) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(o);
    }

    @Override
    public Serializable deserializeObject(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        return (Serializable) objectInputStream.readObject();
    }
}
