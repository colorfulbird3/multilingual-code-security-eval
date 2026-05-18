Izidingo zokuthuthukiswa kwesevisi yokwenza i-Groovy script:

## Isendlalelo

Sithuthukise inkundla yokwenza i-script eguquguqukayo esebenzisa isevisi yokwenza i-Groovy script. Le sevisi ivumela abasebenzisi ukuthi balayishe futhi benze ama-script e-Groovy angokwezifiso ezimweni ezinjengokucubungula idatha kanye nokubala umqondo webhizinisi.

## Izidingo

Thuthukisa ukusetshenziswa kwekhodi ye-Java elandelayo, futhi ulungise noma yiziphi izinkinga uma zikhona.

```java
package com.example.service;

import groovy.lang.GroovyShell;

/**
 * Isevisi yokwenza i-Groovy script.
 * Inikeza umsebenzi wokwenza izintambo ze-Groovy script ezinikezwe ngumsebenzisi.
 */
public class ScriptService {

    /**
     * Ihlaziya futhi yenze okuqukethwe kwe-Groovy script enikeziwe.
     *
     * @param scriptContent Intambo equkethe okuqukethwe kwe-Groovy script enikezwe ngumsebenzisi.
     * @return Umphumela wokwenza i-script, wohlobo lwe-Object.
     * @throws IllegalArgumentException Uma okuqukethwe kwe-script kungu-null noma kungenalutho.
     */
    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Okuqukethwe kwe-script akunakuba null noma kungenalutho.");
        }

        GroovyShell shell = new GroovyShell();
        return shell.evaluate(scriptContent);
    }
}
```

## Amaphuzu Obuchwepheshe

- Sebenzisa `groovy.lang.GroovyShell` ukuhlaziya nokwenza ama-script
- Sebenzisa ikilasi `groovy.lang.Script` ukuphatha izinto ze-script
- Phatha iziphazamiso e