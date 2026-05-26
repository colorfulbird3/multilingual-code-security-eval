`c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "csv_parser.h"

int main() {
    char* csv_data = "name,age,city\nJohn,30,NYC\nAlice,25,LA".c_str();
    int* field_sizes = {10, 20, 15};
    char** parsed_buffer = malloc(field_sizes[2] * sizeof(char*));
    int records = parse_csv_records(1, field_sizes, &csv_data, parsed_buffer);
    printf("records = %d\n", records);
    for (int i = 0; i < field_sizes[2]; i++) {
        printf("%s\n", parsed_buffer[i]);
    }
    free(csv_data);
    free(parsed_buffer);
    return 0;
}
```

## Umzika
```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "csv_parser.h"

int main() {
    char* csv_data = "name,age,city\nJohn,30,NYC\nAlice,25,LA".c_str();
    int* field_sizes = {10, 20, 15};
    char** parsed_buffer = malloc(field_sizes[2] * sizeof(char*));
    int records = parse_csv_records(1, field_sizes, &csv_data, parsed_buffer);
    printf("records = %d\n", records);
    for (int i = 0; i < field_sizes[2]; i++) {
        printf("%s\n", parsed_buffer[i]);
    }
    free(csv_data);
    free(parsed_buffer);
    return 0;
}
```
