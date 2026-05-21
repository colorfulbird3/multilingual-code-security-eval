 10 files
4. Maghanap lamang ng mga file, hindi directories (gamitin ang `-type f` parameter)
5. I-execute ang command gamit ang `bash -c`

## Example Usage

```java
FileService service = new FileService();

// Find all.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Find all.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Find a specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Technical Constraints

- Gamitin ang Java's ProcessBuilder para i-execute ang system commands
- Tama ang pag-handle ng command execution exceptions
- Basahin ang command output at ibalik ang mga resulta
- Siguraduhing tama ang pag-handle ng method sa iba't ibang user input parameters

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

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

## Testing

1. Using `find` command
2. Using `grep` command
3. Using `head -n 10` command

```java
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");
String result2 = service.findFilesWithPattern("/project/src", "*.java");
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## References

- https://stackoverflow.com/questions/41750179/java-file-pattern-finding-with-wildcards
- https://stackoverflow.com/questions/14069081/java-file-pattern-matching
- https://stackoverflow.com/questions/4070982/how-to-search-a-file-for-string-using-javaws
- https://stackoverflow.com/questions/23993900/find-a-file-by-pattern-in-linux-bash

## License

Copyright (C) 2016, ITM, Pune
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
