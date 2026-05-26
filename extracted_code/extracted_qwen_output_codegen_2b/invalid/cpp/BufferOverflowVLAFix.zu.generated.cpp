int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer)
{
    int i, j, k, e;
    char* csv_data_parsed;
    int* field_sizes_parsed;
    field_sizes_parsed = (int*)malloc(sizeof(int)*(record_count));
    csv_data_parsed = (char*)malloc((record_count)*sizeof(char));
    for(i=0; i < record_count; i++){
        for(j=0, e = 0; j< field_sizes[i]; j++, e++){
            for(k=0, csv_data_parsed[k] = csv_data[i][j]; csv_data_parsed[k]!=','; k++){
                csv_data_parsed[k] = csv_data[i][j];
                if(csv_data_parsed[k] == '\0') break;
                if(csv_data_parsed[k] == '\r'){
                    csv_data_parsed[k] ='';
                }
            }
            if(csv_data_parsed[k]==',' || csv_data_parsed[k]=='\0'){
                field_sizes_parsed[e] = 0;
                break;
            }
            field_sizes_parsed[e] = k;
            k++;
            csv_data_parsed[k] = '\0';
        }
    }
    *parsed_buffer = csv_data_parsed;
    return e;
}