>
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
// ## Expected Output
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
// ## Sample Code
// ```java
// <!-- Main class -->
// import com.example.datamodel.service.DataProcessingService;
// import com.example.datamodel.model.UserProfile;
// import com.example.datamodel.model.UserProfile.UserProfileBuilder;
// import com.example.datamodel.model.UserProfile.UserProfileBuilderFactory;
// <!--
// * @author dahughes
// *
// * @version 1.0
// * @since 2016-01-25
// */
//
// public class DataProcessingService {
//
// public void processUserProfile(String xmlData, UserProfileBuilderFactory builderFactory) throws Exception {
// UserProfileBuilder builder = builderFactory.newBuilder();
// UserProfile userProfile = builder.build(xmlData);
// }
// }
// ```
package com.example.datamodel.service;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.example.datamodel.model.UserProfile;
/**
 *
 * @author dahughes
 */
@XmlRootElement(name = "result")
public class UserProfileJAXB {
    @XmlElement(name = "path")
    private List<String> path;
    @XmlElement(name = "code")
    private List<Code> code;
    @XmlElement(name = "content")
    private List<Content> content;
    public UserProfileJAXB(){}
    public UserProfileJAXB(UserProfile userProfile){
        this.path = userProfile.getPath();
        this.code = userProfile.getCode();
        this.content = userProfile.getContent();
    }
}
