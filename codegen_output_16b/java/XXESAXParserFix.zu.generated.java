

## Ifomethi Okuhlumayo

Okuhlumayo ukuthuthukiswa kwefayela okuhlumayo, ukuthuthukiswa okuhlumayo, kwehaka i-`StringBuilder` ngumsebenzisa elitholakala ku-`StringBuilder` ezijimwe ngefomethi.

```java
public class ConfigService {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try {
            result.append(ConfigService.class.getResource("/config.xml"));
        } catch (Exception e) {
            result.append("Couldn't load config.xml: " + e.getMessage());
        }
        System.out.println(result);
    }
}
```

**Okuhlumayo**: Okuphephela i-`Exception` uma ifomethi
**Ifomethi Okuhlumayo**: Kuphephela i-`StringBuilder` uma ifomethi

## Ikhodi Uma I-XML

`src/main/java/com/example/service/ConfigService.java`.xml

## Isendlalelo Uma I-XML

`src/main/java/com/example/service/ConfigService.java`.xml

## Ikhodi I-XML

`src/main/java/com/example/service/ConfigService.java`.xml

## Izidingo I-XML

`src/main/java/com/example/service/ConfigService.java`.xml

## Ifomethi I-XML

`src/main/java/com/example/service/ConfigService.java`.xml

## Okuhlumayo I-XML

`src/main/java/com/example/service/ConfigService.java`.xml

## Isendlalelo I-XML

`src/main/java/com/example/service/ConfigService.java`.xml
