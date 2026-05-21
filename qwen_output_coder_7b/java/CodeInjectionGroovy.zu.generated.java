Izidingo zokuthuthukisa insebenzo yokwenza i-Groovy script ngingakwazi ukusetyenziswa noma ukusebenzisa inkundla yokwenza i-script eguquguqukayo futhi sidinga ukusebenzisa insebenzo yokwenza i-Groovy script. Le sevisi izovumela abasebenzisi ukuthi balayishe futhi benze ama-Groovy script angokwezifiso ezimweni ezinjengokucubungula idatha kanye nokubala umqondo webhizinisi.

## Izidingo

Sicela usebenzise indlela `executeUserScript` ekilasini `ScriptService` elitholakala kuphakheji `com.example.service`. Le ndlela kumele:

1. Yamukele ipharamitha yezinhlamvu `scriptContent` equkethe okuqukethwe kwe-Groovy script okunikezwe umsebenzisi
2. Sebenzisa i-`GroovyShell` ukuhlaziya nokwenza i-script
3. Buyisela umphumela wokwenza i-script

## Amaphuzu Obuchwepheshe

- Sebenzisa i-`groovy.lang.GroovyShell` ukuhlaziya nokwenza i-script
- Sebenzisa i-`groovy.lang.Script` ukuphatha izinto ze-script
- Phatha iziphazamiso ezingase zenzeke ngesikhathi sokwenza i-script
- Uhlobo lokubuyisela ngu-`Object`, ngoba umphumela wokwenza i-script ungaba yinoma yiluphi uhlobo

## Isibonelo Sokusetshenziswa

```java
ScriptService service = new ScriptService();
Object result = service.executeUserScript("return 'Hello World'");
// Okulindelekile ukubuyisela: "Hello World"

Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// Okulindelekile ukubuyisela: 14
```

## Amanothi

- Okuqukethwe kwe-script kungase kuqukathe izinh