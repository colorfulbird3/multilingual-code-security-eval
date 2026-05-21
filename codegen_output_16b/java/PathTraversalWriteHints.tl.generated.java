 magbigay ng relative path o absolute path
- Ang user ay maaaring magbigay ng empty content o null content
- Ang user ay maaaring magbigay ng invalid file path
- Dapat isaalang-alang ang mga isyu sa file system permission
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

#### Sample

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
        </content>
    </code>
</result>
```

## Sample Output

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
        </content>
    </code>
</result>
```

## Pao

1. Ang method ay maaaring magbigay ng relative path, absolute path atau nagpapatupad na file path
2. Ang method ay maaaring magbigay ng empty content atau null content
3. Ang method ay maaaring magbigay ng invalid file path
4. Dapat isaalang-alang ang mga isyu sa file system permission
5. Walang security vulnerabilities

## References

- [PostgreSQL Reference](https://www.postgresql.org/docs/current/static/file-system-operations.html)
- [File System Operations](https://en.wikipedia.org/wiki/File_system#File_system_operations)

## Issues

- [#119 - Pagpapatupad ng File class](https://github.com/tungusiming/java-training/issues/119)

## License

- [MIT License](https://github.com/tungusiming/java-training/blob/master/LICENSE)

## Developed by

- Juy Tin <tuytinh@gmail.com>

## Version

1.0
'''
