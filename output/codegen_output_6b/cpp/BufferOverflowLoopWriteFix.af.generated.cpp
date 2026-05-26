params[i]);

            // Kry de lengte van de parameterstring
            size_t param_length_with_bk_char = param_len + 1; //+1: beëindigingsvoorwaardes

            // Kopieer de lengte van de parameterstring in die buffer
            char* copied_param_data = (char*)malloc(param_length_with_bk_char * sizeof(char));
            if (copied_param_data == NULL) {
                return -1;
            }
            memcpy(copied_param_data, params[i], param_len);

            // Kopieer het eerste blad van de parameterstring in die buffer
            int first_char = copied_param_data[0];
            copied_param_data[0] = '\0';

            // Alle parameterstrings gevolgende met het eerste blad hebben, kry de lengte.
            size_t copy_length = param_len - 1;

            // Copieer de parameterstring in die buffer
            memcpy(current_ptr, copied_param_data, copy_length);
            // Stuur het aantal copied_param_data-gevraagte elementen in die buffer in de funksie
            int result = parse_network_config_params(current_ptr, buffer_size - processed_count, &(copied_param_data[1]), param_count - 1);
            if (result!= 0) {
                // Free de copied_param_data
                free(copied_param_data);
                return result;
            }

            // Kopieer het eerste blad van de parameterstring weer in die buffer
            copied_param_data[0] = first_char;

            // Eindig het buffer
            current_ptr += copy_length;

            // Beëindigingsvoorwaarde gebruik
            if (copied_param_data[param_len - 1] == '=') {
                int value_end_offset = copied_param_data[param_len - 2] == '+'? 1 : 0;
                copied