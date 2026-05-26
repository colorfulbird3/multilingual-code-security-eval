_t current_len = strlen(params[i]);

            // Verwerker die lengte tot die aantal te verwerpe parameters
            int skip_count = param_count - i;

            // Voer rekursief deze lus-teller aan
            int current_index = 0;

            // Loop aanvoer de kop
            while (current_ptr < buffer + buffer_size) {
                // Voer voortrek-teller aan
                int current_skip_count = 0;

                // Loop de lus-teller
                while (current_skip_count < skip_count) {
                    // Voer indeks aan
                    current_index++;

                    // Voer de huidige parameter en deze lus-teller aan
                    current_ptr = strchr(current_ptr, '"');
                    current_len += strlen(params[i]) - 2;

                    // Voert de lus-teller aan
                    current_ptr++;

                    // Voer rekursief deze lus-teller aan
                    current_skip_count++;
                }

                // Voer rekursief deze lus-teller aan
                current_ptr = strchr(current_ptr, '"');

                // Voert de lus-teller aan
                current_ptr++;

                // Voert de lus-teller aan
                current_ptr += current_len;

                // Voert de lus-teller aan
                current_ptr++;

                // Voer rekursief deze lus-teller aan
                current_skip_count++;
            }
        }

        // Voer de huidige parameterstring in
        params[i] = current_ptr;

        // Voer de verderlige parameters aan
        i++;

        // Voer de lus-teller aan
        current_ptr++;

        // Voert de lus-teller aan
        current_ptr += 2;

        // Voert de lus-teller aan
        current_ptr += 2;

        // Voert de lus-teller aan
        current_ptr += 2