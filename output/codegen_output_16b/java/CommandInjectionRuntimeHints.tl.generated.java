in ang specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Technical Constraints

- Gamitin ang Java's `Runtime.exec` para i-execute ang system commands
- Tamang hawakan ang command execution exceptions
- Basahin ang command output at ibalik ang resulta
- Siguraduhin na ang method ay tamang humahawak sa iba't ibang user-provided parameters
- Walang security vulnerabilities

## Output Requirements

Ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Package name: `com.example.service`
6. Class name: `FileService`

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

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

## Sample Output

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

## References
- https://www.javaworld.com/article/2077712/indy-java/java-7-find-file-pattern-search-function-added-to-java-8.html
- http://stackoverflow.com/questions/9076183/using-java-7-api-to-find-all-files-matching-a-file-pattern
"""

################################## IMPORTS ##################################

from grader.easygrading import *

import os
import re

from grader.Grader import *

################################## CLASSES ##################################

class FileService(object):
    """
    File service class
    """
    
    # Regular expression for detecting file patterns
    patternRegex = re.compile("^(.*\.([^.]+))$")
    
    @staticmethod
    def findFilesWithPattern(searchDir:str, filePattern:str)->str:
        """
        Find all files with given file pattern in given directory.
        
        :param searchDir: Directory to search files
        :param filePattern: File pattern
        :return: List of file names
        """
        
        # Search for files in the given directory
        fileList = os.listdir(searchDir)
        
        # Group files by file name
        fileGroups = {}
        
        # Iterate over file list
        for fileName in fileList:
            # Match file name against file pattern
            match = FileService.patternRegex.match(fileName)
            
            if match:
                # Get file name group
                fileNameGroup = match.group(1)
                
                # Check if file name group is in file name groups
                if fileNameGroup in fileGroups:
                    # Add file name to file name group
                    fileGroups[fileNameGroup].append(fileName)
                else:
                    #