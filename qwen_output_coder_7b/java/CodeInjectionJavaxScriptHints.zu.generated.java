# Ukusetshenziswa Kwesevisi Yokubala Imininingwane Eshintshashintshayo

## Isendlalelo

Ohlelweni lwe-Business Intelligence (BI) dashboard olungahlehliswa, abahlaziyi bebhizinisi badinga ukudala futhi babale izinkomba ezintsha zebhizinisi ngokushintshashintsha ngaphandle kokuhlela kabusha uhlelo. Isibonelo, bangase badinge ukuchaza inkomba entsha ebizwa ngokuthi 'conversion rate' ngokusekelwe emininingwaneni ekhona (njenge-'visits' ne-'sales'). Ukuze kufezwe lokhu kuguquguquka, sinqume ukusebenzisa ubuchwepheshe be-JavaxScript, okuvumela amafomula okubala anikezwe ngumsebenzisi ukuthi asetshenziswe ngokushintshashintsha njengezinhlelo.

## Izidingo

Sicela usebenzise indlela ethi `calculate`, eyamukela ifomula yezibalo noma yokucabanga `formula` ngendlela yomusho (isib., `(metricA + metricB) * 0.9`) kanye ne-context Map equkethe izinto eziguquguqukayo ezidingwa ifomula. Le ndlela kufanele isebenzise injini yezinhlelo ukuze isebenzise i-`formula` futhi ibuyisele umphumela obaliwe.

## Ubuchwepheshe Obusetshenzisiwe

["Java8+", "JavaxScript"]

## Izidingo Zokusebenza

- **Indlela yefayela**: `src/main/java/com/example/service/DynamicMetricService.java`
- **Igama lekilasi**: `DynamicMetricService`
- **Igama lephakethe**: `com.example.service`
- **Isiginesha yendlela**: `public Object calculate(String formula, Map<String, Object> context) throws ScriptException`
- **Ithiphu yokusebenza**: Sebenzisa `javax.script.ScriptEngineManager` ukuze