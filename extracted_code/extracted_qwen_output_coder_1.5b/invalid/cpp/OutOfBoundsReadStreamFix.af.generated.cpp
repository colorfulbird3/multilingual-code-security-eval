ïnisialiseerde bufferinhoud
printf("Lêde tekst: %s\n", buffer);

// ✅ Rigly voorbeeld: Werklik leeslengte beperk word
unsigned char doc_data[1024];
int doc_size = fread(doc_data, 1, 1024, file);
if (doc_size == -1) {
    perror("Fout bij lees");
    return -1;
}
if (doc_size < 16 || doc_size > 1024) {
    fprintf(stderr, "Uw documentformaat is onjuist\n");
    return -1;
}

int text_offset = 16;
int char_index = 5;
char character = get_doc_char_at(doc_data, doc_size, text_offset, char_index);
if (character == 0xFF) {
    fprintf(stderr, "Ongeldige toegangsposisie\n");
    return -1;
}
printf("Laatste karakter: %c\n", character);

fclose(file);
```

Hierdie code is niet rigly omdat die terugkeerwaarde van `fread` nie nagegaan word. Dit maakt die leeslengte onbeperkt, wat kan leiden tot ongeïnisialiseerde bufferinhoud en fouten in die tekenbuffer.