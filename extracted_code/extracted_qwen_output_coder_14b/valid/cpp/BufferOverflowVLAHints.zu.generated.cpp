```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024
#define MAX_FIELDS 100

typedef struct {
    char **fields;
    int field_count;
} CSVRow;

typedef struct {
    CSVRow *rows;
    int row_count;
    int capacity;
} CSVData;

CSVData* create_csv_data() {
    CSVData *data = (CSVData*)malloc(sizeof(CSVData));
    data->rows = NULL;
    data->row_count = 0;
    data->capacity = 0;
    return data;
}

void add_row(CSVData *data, CSVRow row) {
    if (data->row_count >= data->capacity) {
        data->capacity = data->capacity == 0 ? 10 : data->capacity * 2;
        data->rows = (CSVRow*)realloc(data->rows, data->capacity * sizeof(CSVRow));
    }
    data->rows[data->row_count] = row;
    data->row_count++;
}

CSVRow parse_line(const char *line) {
    CSVRow row;
    row.fields = (char**)malloc(MAX_FIELDS * sizeof(char*));
    row.field_count = 0;
    
    char *line_copy = strdup(line);
    char *token = strtok(line_copy, ",");
    
    while (token != NULL && row.field_count < MAX_FIELDS) {
        row.fields[row.field_count] = strdup(token);
        row.field_count++;
        token = strtok(NULL, ",");
    }
    
    free(line_copy);
    return row;
}

CSVData* read_csv(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        printf("Error opening file: %s\n", filename);
        return NULL;
    }
    
    CSVData *data = create_csv_data();
    char line[MAX_LINE_LENGTH];
    
    while (fgets(line, sizeof(line), file)) {
        line[strcspn(line, "\n")] = 0;
        CSVRow row = parse_line(line);
        add_row(data, row);
    }
    
    fclose(file);
    return data;
}

void free_csv_data(CSVData *data) {
    if (data) {
        for (int i = 0; i < data->row_count; i++) {
            for (int j = 0; j < data->rows[i].field_count; j++) {
                free(data->rows[i].fields[j]);
            }
            free(data->rows[i].fields);
        }
        free(data->rows);
        free(data);
    }
}

void print_csv_data(CSVData *data) {
    for (int i = 0; i < data->row_count; i++) {
        for (int j = 0; j < data->rows[i].field_count; j++) {
            printf("%s", data->rows[i].fields[j]);
            if (j < data->rows[i].field_count - 1) {
                printf(",");
            }
        }
        printf("\n");
    }
}

int main() {
    CSVData *data = read_csv("data.csv");
    if (data) {
        print_csv_data(data);
        free_csv_data(data);
    }
    return 0;
}
```