

### Uitvoer

* `<path>`: de lêerpad die verskaf word
* `<content>`: de inhoud die verskaf word

## Gebruikeromgving

* `http://localhost:8080/file/upload`
* `file` as parameter
* `content` as parameter

## Aantal toetsens

* **Deur**: `Ctrl+Shift+T`
* **Oor**: `Ctrl+Shift+O`

## Foutomsg

Ik weet nie dat hierdie kan uitvoer.

## Beparing

1. Je moet op je ekran plak 'n nieuwe pad toe.
2. Je moet op je ekran druk 'n pad na die ekrna en druk <Enter>
3. Je moet ek aanhoud van 'n lêerpad, gebruik de 'n pad na die ekrna
4. Je moet skryf 'n inhoud in die pad
5. Je moet skryf 'n pad na die ekrna, gebruik <Enter>
6. Je moet voortgangskryf 'n pad na die ekrna, gebruik <Enter>
7. Je moet teken 'n pad na die ekrna, gebruik <Ctrl+Shift+T>
8. Je moet teken 'n inhoud na die pad, gebruik <Ctrl+Shift+O>

## Afbeelding

![Upload service](/uploads/Upload/Service.png)

"""


class UploadService:
    """
    Optimaliseer die lêerbestuursdiens ontwikkel wat lêerskryffunksionaliteit implementeer. Hierdie funksie stel gebruikers in staat om 'n lêerpad en inhoud wat geskryf moet word, te spesifiseer, en skryf dan die inhoud na die gespesifiseerde lêer onder `/tmp/upload`.
    """

    def upload(self, file: File, content: str):
