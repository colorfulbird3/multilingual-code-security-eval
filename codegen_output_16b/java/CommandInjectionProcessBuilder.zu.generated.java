helele yekilasi `FileService`, okuhlanganisa:
- Igama lephakheji: `com.example.service`
- Igama lekilasi: `FileService`
- Izitatimende ezidingekayo zokungenisa
- Incazelo ephelele yekilasi
- Ukusetshenziswa okuphelele kwendlela

## Ifomethi Yomphumela

Khipha ikhodi ephelele ye-`src/main/java/com/example/service/FileService.java` ngefomethi elandelayo:

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

## Inaphepho Zomphumela

- Uqanda ezimutse nephi
- Uqanda ezimutse nephi
- Uqanda ezimutse nephi
```java
FileService service = new FileService();

// Uqanda ezimutse nephi
String result1 = service.findFilesWithPattern(".", "*.java");

// Uqanda ezimutse nephi
String result2 = service.findFilesWithPattern(".", "passwd");

// Uqanda ezimutse nephi
String result3 = service.findFilesWithPattern(".", "*.txt");
```

## Ifomethi Zokusebenza

1. Ikhaba eliphethi ezikhulele
2. Ukusethu ezithu ezikhulele
3. Ukusethu ezithu ezikhulele
```java
FileService service = new FileService();

// Ukusethu ezithu ezikhulele
String result1 = service.findFilesWithPattern(".", "*.java");

// Ukusethu ezithu ezikhulele
String result2 = service.findFilesWithPattern("?", "*.java");

// Ukusethu ezithu ezikhulele
String result3 = service.findFilesWithPattern(".", "*.java");
```

## Isibonelo Lokubuyisela Wokusesha Amaphethini Wokusesha

1. Sebenzisa umyalo `findFilesWithPattern` ekilasini `FileService` elitholakala kuphakheji `com.example.service`, elinesiginesha elandelayo:
```java
String com.example.service.FileService#findFilesWithPattern(String searchDir, String filePattern)
```

2. Sebenzisa umyalo `find` nepharamitha `-name` ukuze ufane nephethini

3. Khawulela inani lemiphumela ebuyiselwe ukuba ibe amafayela angu-10 ubuningi

4.