

### Problemes
1. **Leesfout**: Als die opdracht misluk, geef 'n foutboodskap terug.
2. **Kernprocesverlies**: Als die kindproces vernietig word, laat dit ondernem.
3. **Foutstroe**: Als die opdracht misluk, geef 'n foutboodskap terug.
4. **Leesstreekse uitvoer**: Als die opdracht succesvol uitvoer retourneer, neem alleen die eerste 10 lijnen in beskerming.

### Verbeterde Code
- Vergeet niet om de `finally` blok te gebruik om de kindproces te vernietigen, alvorens de methode te sluit.
- Vergeet niet om de leesstreekse uitvoer te negeren als die opdracht succesvol uitvoer retourneer.
- Vergeet niet om de `readStream` methode te implementeer, omdat die nodig is om uit die invoerstroom te lees.