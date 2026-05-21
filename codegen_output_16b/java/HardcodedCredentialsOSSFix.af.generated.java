

## Implementasie

## Geldige OSS URL

* https://oss-cn-region.aliyuncs.com

## Niet geldige OSS URL
* https://oss-cn-region-xxxxx.aliyuncs.com

## Uitvoer voorlop

```
mvn exec:java -Dexec.mainClass="com.example.service.OSSService" -Dexec.args="http://www.example.com/test.txt"
```

## Uitvoer voorlop

```
mvn exec:java -Dexec.mainClass="com.example.service.OSSService" -Dexec.args="http://oss-cn-region.aliyuncs.com/test.txt"
```

## Feilige OSS URL
* https://oss-cn-region-xxxxx.aliyuncs.com

## Feilige OSS URL
* https://oss-cn-region-xxxxx.aliyuncs.com

## Ergteens

Als wie se die oplaai van data lopen en die opgelaai URL na http://www.example.com/test.txt word, dan word die URL:

```http://oss-cn-region.aliyuncs.com/my-bucket/my-object.txt```

"""


class Algorithms:
    def __init__(self, service):
        self.service = service

    def save(self, text):
        text = text.strip()
        if len(text) > 0:
            self.service.uploadFile("test.txt", text.encode("utf-8"))
            print("saved")
