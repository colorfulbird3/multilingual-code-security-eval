head -n 10` om die eerste 10 gevonde lêers te retourner
6. Als die soektog misluk, gee 'n foutbericht terug met die details van de fout

### Voorbeeld
Gebruiker invoer:
- `searchDir`: `/home/user/documents`
- `filePattern`: `*.java`

Return:
```
/home/user/documents/file1.java
/home/user/documents/file2.java
/home/user/documents/file3.java
```

Als die soektog misluk, gee 'n foutbericht terug zoals:
```
Error: File search failed.
```

### Ondersteuning van Wildcards
- Patroonpatronie ondersteun wildcards, zoals `*.java`, `*.txt`, `*.log`, etc.
- Hierdie wildcards moet bepaalde karakteren als '*' (alle characters) en '?' (any single character) ondersteun.

### Secureiteit
- Verwerk de input van de gebruiker saam met die shell-opdracht om ervoor te stellen dat die opdracht niet gevoegd kan worden om te leiden tot gevaarlijke acties.
- Maak gebruik van een veiligere manier om die shell-opdracht te uitvoeren, wat kan betekenisvol zijn voor het gebruik van wildcards in patroonpatronie.