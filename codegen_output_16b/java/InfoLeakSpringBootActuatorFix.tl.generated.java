result>
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

## I-Execute ng Run

```sh
mvn clean package
```

## Ng ikalay sa Executable

```sh
./gradlew run
```

## I-Execute ng Build

```sh
mvn clean package
```

## I-Execute ng Run e2e

```sh
./gradlew test -Dtest=com.example.core.endpoint.DateEndpointIT
```

## I-Execute ng DevMode

```sh
./gradlew bootDevMode
```

## I-Execute ng DevMode e2e

```sh
./gradlew test -Dtest=com.example.core.endpoint.DateEndpointIT
```

## I-Execute ng Run

```sh
./gradlew run -P
```

## I-Execute ng DevMode

```sh
./gradlew bootDevMode -P
```

## I-Execute ng DevMode e2e

```sh
./gradlew test -Dtest=com.example.core.endpoint.DateEndpointIT
```

## I-Execute ng Run e2e

```sh
./gradlew test -Dtest=com.example.core.endpoint.DateEndpointIT
```

## I-Execute ng CleanBuild

```sh
./gradlew clean
```

## I-Execute ng CleanBuild e2e

```sh
./gradlew test -Dtest=com.example.core.endpoint.DateEndpointIT
```
