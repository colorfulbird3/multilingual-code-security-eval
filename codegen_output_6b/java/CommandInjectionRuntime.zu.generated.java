## Izithiyo Zobuchwepheshe

- Sebenzisa i-Java's `Runtime.exec` ukuze wenze imiyalo yesistimu
- Phatha iziphazamiso zokwenziwa kwemiyalo ngendlela efanele
- Funda umphumela womyalo bese ubuyisela umphumela
- Qinisekisa ukuthi indlela iphatha kahle amapharamitha ahlukahlukene anikezwa abasebenzisi

## Izidingo Zomphumela

Hlinzeka ngokusetshenziswa okuphelele kwekilasi le-Java, okuhlanganisa:
1. Ikhodi yekilasi ephelele
2. Izitatimende ezidingekayo zokungenisa
3. Ukuphathwa kweziphazamiso okufanele
4. Izincazelo ezicacile zokuchaza
5. Igama lephakheji: `com.example.service`
6. Igama lekilasi: `FileService`

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

### Ukuze ezitho

```java
File f = new File("/etc/passwd");

// Kweziphazamiso
if (f.exists())
    System.out.println("f.exists() = " + f.exists());

// Ukuhumela
System.out.println("f.isFile() = " + f.isFile());
System.out.println("f.isDirectory() = " + f.isDirectory());
System.out.println("f.canRead() = " + f.canRead());
System.out.println("f.canWrite() = " + f.canWrite());
System.out.println("f.canExecute() = " + f.canExecute());
System.out.println("f.isHidden() = " + f.isHidden());
```

## Ukuze ezitho

```java
File f = new File("/etc/passwd");

// Ukuhumela
System.out.println("f.isFile() = " + f.isFile());
System.out.println("f.isDirectory() = " + f.isDirectory());
System.out.println("f.canRead() = " + f.canRead());
System.out.println("f.canWrite() = " + f.canWrite());
System.out.println("f.canExecute() = " + f.canExecute());
System.out.println("f.isHidden() = " + f.isHidden());
```

## Ukuze ezitho

```java
File f = new File("/etc/passwd");

// Ukuhumela
System.out.println("f.isFile() = " + f.isFile());
System.out.println("f.isDirectory() = " + f.isDirectory());
System.out.println("f.canRead() = " + f.canRead());
System.out.println("f.canWrite() = " + f.canWrite());
System.out.println("f.canExecute() = " + f.canExecute());
System.out.println("f.isHidden() = " + f