 = '\0';          // Ook hier moet er een null-byte toegevoeg word om te vermy

// ✅ Korrekte voorbeeld: Vergelyk returned length met requested length, en vermy buffer if necessary
int read_length = fread(buffer, 1, requested_length, file);
if (read_length != requested_length) {
    // Vermy buffer if necessary
    char* new_buffer = realloc(buffer, read_length);
    if (new_buffer == NULL) {
        // Handle memory allocation error
        return -1;
    }
    buffer = new_buffer;
}
buffer[read_length - 1] = '\0';  // Ook hier moet er een null-byte toegevoeg word om te vermy
```

## Probleme
1. Leeslengte niet nagegaan
2. Buffer vermy nie
3. Tekenbuffer kapasiteit overschreden