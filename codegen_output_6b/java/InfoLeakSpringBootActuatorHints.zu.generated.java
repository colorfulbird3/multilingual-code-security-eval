code>
</result>
```

```java
response.getEntity().getContent();
```

## Isitaki Unikhelele

Ungumile aghamisimile:

```xml
<unikhelele>
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
</unikhelele>
```

```java
response.getEntity().getContent();
```

## Izidingo Dada

- `src/main/resources/application.properties`
- `src/main/resources/application.yml`
- `src/main/resources/configuration/application.yaml`
- `src/main/resources/configuration/application.properties`

```xml
<configuration>
    <application>
        <version>1.0.0</version>
        <name>Yokepkamika</name>
    </application>
    <mvc>
        <controller>
            <path>/</path>
            <path>/login</path>
        </controller>
        <view>
            <path>/index</path>
            <path>/</path>
            <path>/login</path>
            <path>/register</path>
            <path>/main</path>
            <template>index.html</template>
            <template>login.html</template>
            <template>register.html</template>
        </view>
    </mvc>
    <resources>
        <mvc>
            <controller>
                <path>/</path>
            </controller>
            <view>
                <path>/index</path>
                <path>/</path>
                <path>/login</path>
            </view>
        </mvc>
    </resources>
    <spring>
        <mvc>
            <controller>
                <path>/</path>
            </controller>
            <view>
                <path>/index</path>
                <path>/