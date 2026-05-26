## context
Een lêer met name 'n CSV-bestand, waarin gegevens over stadiek en sport is gespriet. Hier is die voorbeeld van die CSV-lêer:

| stadiek | sporttype | datum      | aantal_kampioenen |
|---------|------------|--------------|------------------|
| Amsterdam| Football   | 2023-05-10 | 10               |
| Berlin  | Basketball | 2023-05-15 | 5                |
| Amsterdam| Volleyball | 2023-05-20 | 7                |

## problem
Die CSV-lêer is korrekt ingepakkeerd en de data is goed gespieet. Daarom wordt er geen probleem aangetrekken met de CSV-lêer.

## solution
Maak gebruik van die `decompress_file` funksie om die CSV-lêer te dekompresie. Voeg die kompressorie-proces toe aan de `decompress_file` funksie en maak gebruik van die `struct compression_context` om die dekompressie-oplossing op te slaan.

## code snippet