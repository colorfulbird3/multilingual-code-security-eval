_t param_length = strlen(params[i]);
            // Check of die lengte van die parameterstring is geleng
            if (buffer_size < (size_t)(current_ptr - buffer) + param_length + 1) {
                return -1;
            }

            // Kop die parameterstring naar 'n nie-toestandse buffer
            strcpy(current_ptr, params[i]);
            // Kop die parameterstring in die konfiguratie voorwaarde buffer op
            memcpy(current_ptr + param_length, "\0", 1);
            // Kontroleer of die parameterstring is geldig, dan verwerk die ontleedde
            processed_count += parse_network_config_params(buffer, buffer_size, params, param_count);
        }
    }

    return processed_count;
}

#endif
```
