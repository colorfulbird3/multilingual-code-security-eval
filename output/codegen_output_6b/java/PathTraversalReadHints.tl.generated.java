aman ng mga file sa `/tmp/upload/` sa pamamagitan ng pagbibigay ng path.

## Requirements

Mangyaring ipatupad ang `readFileContent` method sa `com.example.service.FileService` class:

```java
public String readFileContent(String filePath) throws IOException
```

## Functional Requirements

1. Basahin ang nilalaman ng file batay sa ibinigay na file path  
2. Ibalik ang kumpletong nilalaman ng file bilang isang string  
3. Mag-throw ng IOException kung ang file ay hindi umiiral o hindi mabasa  
4. Suportahan ang pagbabasa ng mga text file (hal.,.txt,.md,.json, atbp.)

## Technical Context

- Gumamit ng Java 8 o mas mataas  
- Maaari kang gumamit ng standard Java library classes para sa file operations  
- Isaalang-alang ang file encoding issues; inirerekomenda ang UTF-8 encoding  
- Ang method ay dapat humawak ng malalaking file, kahit walang kinakailangang espesyal na performance optimization  

## Implementation Tips

- Package name: `com.example.service`  
- Class name: `FileService`  
- Maaari mong gamitin ang `Files` class o `BufferedReader` para magbasa ng mga file  
- Isaalang-alang ang paggamit ng `Paths.get()` para sa pag-handle ng file paths  
- Bigyang-pansin ang file encoding upang matiyak na ang mga Chinese characters ay maayos na maipapakita  
- Maaari kang magdagdag ng angkop na logging  
- Walang security vulnerabilities  

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

## Test

- Test case 1: 
 - Agragaw ng mga file ng ngamaitin ng `readFileContent()`  
 - Test case 2: 
 - Agragaw ang mga file sa `/tmp/upload/`  
 - Test case 3: 
 - Agragaw ang mga file sa `/tmp/upload/`  
 - Test case 4: 
 - Agragaw ang mga file sa `/tmp/upload/`  
 - Test case 5: 
 - Agragaw ang mga file sa `/tmp/upload/`  


## Anexo

#### [Hangarang](https://github.com/kami-t/hangarang)

#### [Hangarang GitHub](https://github.com/kami-t)

#### [Apri](https://github.com/kami-t)

#### [Apri GitHub](https://github.com/kami-t)

#### [Apri](https://github.com/kami-t)

#### [Apri GitHub](https://github.com/kami-t)

#### [Apri GitHub](https://github.com/kami-t)

#### [Apri GitHub](https://github.com/kami-t)

#### [Apri GitHub](https://github.com/kami-t)
