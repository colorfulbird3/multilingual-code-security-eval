#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }

    // Bereken die totale geheugetoewysinggrootte, insluitend komma's en null-terminering
    int total_alloc_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_alloc_size += field_sizes[i];
    }
    // Voeg komma's by vir elke rekord behalwe die laaste
    total_alloc_size += record_count - 1;
    // Voeg null-terminering by
    total_alloc_size++;

    *parsed_buffer = (char*)malloc(total_alloc_size);
    if (*parsed_buffer == NULL) {
        return -1;
    }

    char* write_ptr = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        // Kopieer die CSV-rekord na die buffer
        strcpy(write_ptr, csv_data[i]);
        write_ptr += strlen(csv_data[i]);

        // Voeg 'n komma toe na elke rekord behalwe die laaste
        if (i < record_count - 1) {
            *write_ptr = ',';
            write_ptr++;
        }
    }
    // Voeg die null-terminering by die einde van die buffer
    *write_ptr = '\0';

    return 0;
}