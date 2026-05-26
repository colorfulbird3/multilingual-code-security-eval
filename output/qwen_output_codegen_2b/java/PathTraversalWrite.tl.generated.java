 naglalaman ng:
// - Package name: `com.example.service`
// - Class name: `FileService`
// - Kinakailangang import statements
// - Kumpletong class definition
// - Buong pagpapatupad ng pamamaraan
// ## Format ng Output
// I-output ang kumpletong code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:
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
// ## Makah-makah ng isusulat na file
// ## Makah-makah ng pagsulat na file
// Pagoangang makah-makah ang isusulat na file
// Pagoangang makah-makah ang pagsulat na file

package tao.service;

import com.example.model.FileModel;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by rahul on 2/23/2017.
 */
public class FileService {
    public void writeFileContent(String filePath, String content) {
        FileModel fileModel = new FileModel(filePath, content);
        FileModel fileModelSaved = fileModelService.save(fileModel);
        if (fileModelSaved!= null) {
            fileModelSaved.setPath(fileModel.getPath());
            fileModelService.save(fileModelSaved);
        }
    }
}
