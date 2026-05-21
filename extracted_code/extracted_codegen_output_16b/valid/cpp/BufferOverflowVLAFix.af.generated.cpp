#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024
#define MAX_FIELDS 100

void parse_csv_line(const char *line, char fields[][MAX_LINE_LENGTH], int *num_fields) {
    int field_index = 0;
    int char_index = 0;
    int in_quotes = 0;
    int i = 0;

    while (line[i] != '\0' && field_index < MAX_FIELDS) {
        if (line[i] == '"') {
            in_quotes = !in_quotes;
            i++;
        } else if (line[i] == ',' && !in_quotes) {
            fields[field_index][char_index] = '\0';
            field_index++;
            char_index = 0;
            i++;
        } else {
            fields[field_index][char_index] = line[i];
            char_index++;
            i++;
        }
    }

    fields[field_index][char_index] = '\0';
    *num_fields = field_index + 1;
}

int main() {
    FILE *file = fopen("data.csv", "r");
    if (!file) {
        perror("Failed to open file");
        return 1;
    }

    char line[MAX_LINE_LENGTH];
    char fields[MAX_FIELDS][MAX_LINE_LENGTH];
    int num_fields;

    while (fgets(line, sizeof(line), file)) {
        line[strcspn(line, "\n")] = '\0';
        parse_csv_line(line, fields, &num_fields);

        for (int i = 0; i < num_fields; i++) {
            printf("Field %d: %s\n", i + 1, fields[i]);
        }
        printf("---\n");
    }

    fclose(file);
    return 0;
}