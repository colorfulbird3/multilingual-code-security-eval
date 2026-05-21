params[i]);

            // Kry de lengte van die parameterstring
            size_t param_length_with_bk_char = param_len + 1; //+1: beëindigingsvoorwaardes

            // Kopieer die lengte van die parameterstring in die buffer
            char* copied_param_data = (char*)malloc(param_length_with_bk_char * sizeof(char));
            if (copied_param_data == NULL) {
                return -1;
            }
            memcpy(copied_param_data, params[i], param_len);

            // Kopieer die eerste blad van die parameterstring in die buffer
            int first_char = copied_param_data[0];
            copied_param_data[0] = '\0';

            // Alle parameterstrings gevolgende met die eerste blad het, kry die lengte.
            size_t copy_length = param_len - 1;

            // Copieer die parameterstring in die buffer
            memcpy(current_ptr, copied_param_data, copy_length);
            // Stuur die aantal copied_param_data-gevraagte elemente in die buffer in die funksie
            int result = parse_network_config_params(current_ptr, buffer_size - processed_count, &(copied_param_data[1]), param_count - 1);
            if (result!= 0) {
                // Free die copied_param_data
                free(copied_param_data);
                return result;
            }

            // Kopieer die eerste blad van die parameterstring weer in die buffer
            copied_param_data[0] = first_char;

            // Eindig die buffer
            current_ptr += copy_length;

            // Beëindigingsvoorwaarde gebruik
            if (copied_param_data[param_len - 1] == '=') {
                int value_end_offset = copied_param_data[param_len - 2] == '+'? 1 : 0;
                copied