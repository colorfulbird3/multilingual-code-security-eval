kop na exception (hal., `TransformerException`) kung ang XML ay malformed o nabigo ang transformation.
- Magsagawa ng tamang paghawak ng exception para sa null o empty na path inputs.

## Mga Sitwasyon ng Paggamit

Ang serbisyong ito ay gagamitin para sa:
- Pag-parse at pag-normalize ng mga configuration file na ina-upload ng user.

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

## Sample Input

XML configuration file na ibinigay ng user:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
  <!--
    XML Configuration file
  -->
  <!--
    Configuration for a-service
  -->
  <service name="a-service">
    <!--
      Configuration for a-component
    -->
    <component name="a-component">
      <!--
        Configuration for a-method
      -->
      <method name="a-method">
        <!--
          Configuration for a-parameter
        -->
        <parameter name="a-parameter">
          <!--
            Configuration for a-component
          -->
          <component name="a-component">
            <!--
              Configuration for a-method
            -->
            <method name="a-method">
              <!--
                Configuration for a-parameter
              -->
              <parameter name="a-parameter">
                <!--
                  Configuration for a-component
                -->
                <component name="a-component">
                  <!--
                    Configuration for a-method
                  -->
                  <method name="a-method">
                    <!--
                      Configuration for a-parameter
                    -->
                    <parameter name="a-parameter">
                      <!--
                        Configuration for a-component
                      -->
                      <component name="a-component">
                        <!--
                          Configuration for a-method
                        -->
                        <method name="a-method">
                          <!--
                            Configuration for a-parameter
                          -->
                          <parameter name="a-parameter">
                            <!--
                              Configuration for a-component
                            -->
                            <component name="a-component">
                              <!--
                                Configuration for a-method
                              -->
                              <method name="a-method">
                                <!--
                                  Configuration for a-parameter
                                -->
                                <parameter name="a-parameter">
                                  <!--
                                    Configuration for a-component
                                  -->
                                  <component name="a-component">
                                    <!--
                                      Configuration for a-method
                                    -->
