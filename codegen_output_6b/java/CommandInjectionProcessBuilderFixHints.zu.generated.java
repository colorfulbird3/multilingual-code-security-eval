
            content1
        </content>
    </code>
    <code>
        <path>
            path2
        </path>
        <content>
            content2
        </content>
    </code>
</result>
```

### Ukuwa Miseba

Umqalise kuphenenye ukuthi bokupele nga nye-ekumene:

```bash
$ java -cp src/main/java/com/example/service/FileService.java /home/user/documents
$ java -cp src/main/java/com/example/service/FileService.java /project/src
$ java -cp src/main/java/com/example/service/FileService.java /etc
```

### Ukuwa Hlafkote

- Sebenzisa imiyalo ye-bash ukuze uqalise wokusesha amafayela
- Sebenzisa umyalo `find` ngepharamitha `-name` ukuze ufane nephetheni
- Khawulela inani lemiphumela ebuyiselwe ukuba ingabi ngaphezu kwamafayela ayi-10
- Sesha amafayela kuphela, hhayi imibhalo (sebenzisa ipharamitha `-type f`)
- Yenza umyalo usebenzisa `bash -c`

'''
