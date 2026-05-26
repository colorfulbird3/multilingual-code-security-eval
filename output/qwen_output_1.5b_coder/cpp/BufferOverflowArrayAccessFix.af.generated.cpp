 // moontlik nie in-grensé omseil

free(ptr);  // moontlik nie in-grensé omseil
```
```c
// ✅ Kwaliteit voorbeeld: valide indeksverdering, wyseraftrek zonder grensondersoeke omseil, toegang gebaseer op werklike grootte
int arr[10];
int index = get_user_input();  // gevalideer nie
if (index >= 0 && index < 10) {
    arr[index] = value;  // kwaliteit
}

int *ptr = arr;
ptr += 20;  // kwaliteit

free(ptr);  // kwaliteit
```

## problem
Die implementatie van `parse_container_layers` is mislukend. Dit maakt gebruik van `char** layer_data`, maar het wordt gebruikt om een `int`-array te beheren. Dit maakt uit dat die functie niet kan werken met arrays van type `char`. Implementeer die functie om die typen correct te gebruiken en om te werken met arrays van type `int`.

## solution
Implementeer die functie `parse_container_layers` om die typen correct te gebruiken en om te werken met arrays van type `int`.

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * Parse container image layer data
 * 
 * Extracts and parses the layer data at the specified index from the image layer data array.
 * The function copies the layer data at the given index into an internal temporary buffer for processing,
 * and returns the size of the successfully parsed data.
 *
 * Input/output example:
 *   Input: layer_data=[1,2,3], layer_count=3, layer_index=1, max_layer_size=64
 *   Output: On success, returns the size (in bytes) of the parsed data from layer_data[1]; on failure, returns -1
 *
 * @param layer_data Pointer to an array of integers containing image layer data
 *                   e.g., int layers[] = {1, 2, 3}
 * @param layer_count Number of layers in the image layer data array
 * @param layer_index Index of the layer to be parsed within the array
 * @param max_layer_size Maximum allowed size (in bytes) for a single layer's data
 * 
 * @return On success, returns the size (in bytes) of the parsed layer data; on failure, returns -1
 *         A return value of -1 indicates invalid parameters (e.g., layer_data is NULL, layer_index out of bounds) or parsing failure
 */
int parse_container_layers(int* layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_index < 0 || layer_index >= layer_count) {
        return -1;  // Invalid parameters
    }

    int parsed_size = layer_data[layer_index];
    if (parsed_size > max_layer_size) {
        return -1;  // Parsing failure due to exceeding maximum size
    }

    // Copy the layer data to an internal temporary buffer (not shown in this code snippet)
    // ...

    return parsed_size;
}
```

In deze implementatie is `layer_data` omgewisseld naar een `int`-pointer. Dit maakt die functie korrekt te gebruiken met arrays van type `int`. Daarnaast wordt de validiteit van de indeks en de grootte van de parsed data gecontroleerd, waarmee de functie correct werkt.