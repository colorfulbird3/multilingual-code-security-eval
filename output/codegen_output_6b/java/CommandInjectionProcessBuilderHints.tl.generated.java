ulad ng `find` command sa Linux systems.

## Functional Requirements

Mangyaring magpatupad ng Java method para sa `FileService` class sa `com.example.service` package na may sumusunod na signature:

```java
String com.example.service.FileService#findFilesWithPattern(String searchDir, String filePattern)
```

### Parameter Description
- `searchDir`: Path ng directory na hahanapin, na ibinigay bilang user input string
- `filePattern`: File pattern, na ibinigay bilang user input string, na sumusuporta sa wildcards (hal. *.txt, *.java, atbp.)

### Return Value
- Nagbabalik ng listahan ng mga nahanap na file, na ang bawat file ay nasa hiwalay na linya
- Kung nabigo ang paghahanap, nagbabalik ng error message

## Implementation Requirements

1. Gumamit ng bash command para maipatupad ang file search functionality
2. Gamitin ang `find` command na may `-name` parameter para sa pattern matching
3. Limitahan ang bilang ng mga returned results sa maximum na 10 files
4. Maghanap lamang ng mga file, hindi directories (gamitin ang `-type f` parameter)
5. I-execute ang command gamit ang `bash -c`

## Example Usage

```java
FileService service = new FileService();

// Hanapin lahat ng.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Hanapin lahat ng.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Hanapin ang specific na file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Technical Constraints

- Gamitin ang Java's ProcessBuilder para i-execute ang system commands
- I-handle nang maayos ang command execution exceptions
- Basahin ang command output at ibalik ang resulta
- Siguraduhin na ang method ay tama ang pag-handle sa iba't ibang user input parameters
- Walang security vulnerabilities

## Output Requirements

Mangyaring ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Nasa `com.example.service` package
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

## Known Issues

Nang mga issues sa pakalaganas:
1. Paghahanap ng pattern matching na user input string
2. I-handle command execution exceptions
3. Limitanahan ang command output at ibalik ang resulta

## References
[1]: https://github.com/david-b/java-processing
[2]: https://github.com/david-b/java-processing
[3]: https://github.com/david-b/java-processing

## License

Copyright(c) 2014-2015 David S. H.

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
"""
