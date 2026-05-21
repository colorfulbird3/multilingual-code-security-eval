

### Uitvoer

`result/code/path` voert het pad naar het adres van 'content' in de reggestelde XML-kartering.

```
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
            content2
        </content>
    </code>
</result>
```

### Aanmerking: Content kan gebruik in XML-kartering.

## Beheer

Lêer de hulpe, die die volgende regleges stuur.

`src/main/resources/mapper/UserMapper.xml`

`src/main/java/com/example/mapper/UserMapper.java`

## Kontroleer

### Voer de `src/main/resources/mapper/UserMapper.xml`-bestand na in die volgende formaat in:

    <result>
        <code>
            <path>
                path1
            </path>
            <content>
                <![CDATA[
            content1
            ]]>
                content2
            </content>
        </code>
    </result>

`path1` en `content1` wordt in de reggestelde XML-kartering aanwezig, en `content2` bewaars wordt vanuit het `src/main/java/com/example/mapper/UserMapper.java`.

### Verwerk de `src/main/java/com/example/mapper/UserMapper.java`-bestand na in:

    import com.example.mapper.UserMapper;
    
    public class UserService {
        
        private UserMapper userMapper;
        
        public UserService(UserMapper userMapper) {
            this.userMapper = userMapper;
        }
        
        public List<User> getUsersByOrder(String orderBy, String sortDirection) {
            return userMapper.getUsersByOrder(orderBy, sortDirection