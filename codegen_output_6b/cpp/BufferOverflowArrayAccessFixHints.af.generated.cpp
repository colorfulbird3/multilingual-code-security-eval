validering
    arr[index] = value;  // Verwysing
}

int *ptr = arr;
ptr += index * sizeof(int);  // Wyseraanwysing
*ptr = value;  // Verwysing
```

## toegwysing

- De gebaseerde grootte wysenda wat de wyseraanwysing moet nagegaan, moet gebaseer op een waarvoor nog toegwysing moet gebaseer word.
- Hoeveelheid gebeurte van de wyseraanwysing moet benodig word nagegaan (waarschijnlijk ook het aantal waardes toegwysing moet gebaseer word).
- Hoeveelheid waardes moeten gebaseer word in een waarschijnlijk gebaseerde wyservaar (waarschijnlijk waardes toegwysing moet gebaseer word).

```c
// ❌ Slegte voorbeeld: Binnen-waarde woorden en waardes, gebaseer op waarschijnlijk gebaseerde wyservaar
int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int index = get_user_input();  // Nie gevalideer nie
arr[index] = value;  // Potensiëlle buite-grense toegang

// ❌ Slegte voorbeeld: Binnen-waarde woorden en waardes
int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int index = get_user_input();
arr[index] = value;
```

## testcases

```c
#include "container_layer_parser.h"

int main(int argc, char** argv) {
    int buffer_length = 1024;
    char* buffer = (char*)malloc(buffer_length);
    int index = parse_container_l