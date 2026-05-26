```xml
<result>
    <code>
        <path>src/main/java/com/example/datamodel/service/DataProcessingService.java</path>
        <content><![CDATA[
package com.example.datamodel.service;

import com.example.datamodel.model.UserProfile;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class DataProcessingService {

    /**
     * Processes the user profile XML data and returns a UserProfile object.
     *
     * @param xmlData The XML-formatted string containing user profile data.
     * @return A UserProfile object representing the parsed data.
     * @throws JAXBException If there is an error during parsing.
     */
    public UserProfile processUserProfile(String xmlData) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserProfile.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xmlData);
        return (UserProfile) unmarshaller.unmarshal(reader);
    }
}
]]>
        </content>
    </code>
</result>
```