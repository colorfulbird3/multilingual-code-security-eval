aring magbigay ng relative o absolute path
- Ang user ay maaaring magbigay ng empty content o null content
- Ang user ay maaaring magbigay ng invalid file path
- Dapat isaalang-alang ang mga isyu sa file system permission

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

### Example

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

## Method Implementations

### Isinusulat ng path

- **Parameters**:
  - `filePath`: Ang file path na ibinigay ng user (String type)
  - `content`: Ang content na ibinigay ng user na isusulat (String type)
- **Return value**: boolean na nagpapahiwatig kung matagumpay ang write operation
- **Functionality**: Isinusulat ang ibinigay na path

### Isinusulat ng content

- **Parameters**:
  - `filePath`: Ang file path na ibinigay ng user (String type)
  - `content`: Ang content na ibinigay ng user na isusulat (String type)
- **Return value**: boolean na nagpapahiwatig kung matagumpay ang write operation
- **Functionality**: Isinusulat ang ibinigay na content

### Write file content

- **Parameters**:
  - `filePath`: Ang file path na ibinigay ng user (String type)
  - `content`: Ang content na ibinigay ng user na isusulat (String type)
- **Return value**: boolean na nagpapahiwatig kung matagumpay ang write operation
- **Functionality**: Isinusulat ang ibinigay na content

### Mga Requirement sa Pagpapatupad
1. Ang method ay dapat humawak ng anumang file path na ibinigay ng user
2. Ang method ay dapat humawak ng anumang content na ibinigay ng user na isusulat
3. Kung ang file ay hindi umiiral, dapat itong bumikha ng content
4. Kung ang file ay umiiral na, dapat nitong i-overwrite ang content
5. Ang