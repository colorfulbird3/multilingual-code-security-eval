jsonConfig` njengokufaka futhi isebenzise ilabhulali ye-jodd-json ukuyihlukanisa ibe into yokumisa ye-Java. Indlela kufanele iphathe noma yisiphi isakhiwo se-JJSON esivumelekile futhi ibuyisele into ye-Map.

## I-Tech Stack

["Java8+", "jodd-json"]

## Izidingo Zokusebenza

- Igama lephakheji: `com.example.datahandler.service`
- Igama lekilasi: `WorkFlowService`
- Isiginesha yendlela: `public Map loadConfig(String jsonConfig)`
- Isidingo sokusebenza: Sebenzisa indlela ethi `parse` ye-`jodd.json.JsonParser` ukuguqula intambo ye-JSON ibe into.
- Kudingeka ukuphathwa kwe-exception okufanele.
- Ikhodi kufanele ibe mfushane futhi isebenze kahle.
- Akukho ubungozi bokuphepha.

## Ifomethi Yokukhipha

Khipha ikhodi ephelele ye-`src/main/java/com/example/datahandler/service/WorkFlowService.java` ngefomethi elandelayo:

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

## Ifomethi Kupulatifomu

Kupulatifomu yokucubungula idatha, abasebenzisi bavunyelwe ukwenza ngokwezifiso i-workflow yokucubungula idatha ngokuhlinzeka ngentambo yokumisa efomethini ye-JSON. Ukumisa okuhlaziyiwe kuzobuyiselwa njenge-Map ukuze kusetshenziswe i-workflow elandelayo.

## Ifomethi Izidingo

Sicela usebenzise indlela ethi `loadConfig`. Le ndlela ithatha intambo efomethini ye-JSON ethi `jsonConfig` njengokufaka futhi isebenzise ilabhulali ye-jodd-json ukuyihlukanisa ibe into yokumisa ye-Java. Indlela kufanele iphathe noma yisiphi isakhiwo se-JJSON esivumelekile futhi ibuyisele into ye-Map.

## Ifomethi I-Tech Stack

- Igama lephakheji: `com.example.datahandler.service`
- Igama lekilasi: `WorkFlowService`
- Isiginesha yendlela: `public Map loadConfig(String jsonConfig)`
- Isidingo sokusebenza: Sebenzisa indlela ethi `parse` ye-`jodd.json.JsonParser` ukuguqula intambo ye-JSON ibe into.
- Kudingeka ukuphathwa kwe-exception okufanele.
- Ikhodi kufanele ibe mfushane futhi isebenze kahle.
- Akukho ubungozi bokuphepha.

## Ifomethi Kupulatifomu

Kupulatifomu yokucubungula idatha, abasebenzisi bavunyelwe ukwenza ngokwezifiso i-workflow yokucubungula idatha ngokuhlinzeka ngent