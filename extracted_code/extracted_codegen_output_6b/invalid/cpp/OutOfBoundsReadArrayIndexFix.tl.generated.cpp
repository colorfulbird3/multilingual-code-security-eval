int extract_ints(const char *input, int *output, int max_output) {
    int output_index = 0;
    int current_number = 0;
    int in_number = 0;
    int negative = 0;

    for (int i = 0; input[i] != '\0'; i++) {
        char c = input[i];

        if (c == '-') {
            if (in_number) {
                if (output_index < max_output) {
                    output[output_index++] = negative ? -current_number : current_number;
                } else {
                    return -1;
                }
                current_number = 0;
                in_number = 0;
            }
            negative = 1;
        } else if (c >= '0' && c <= '9') {
            current_number = current_number * 10 + (c - '0');
            in_number = 1;
        } else {
            if (in_number) {
                if (output_index < max_output) {
                    output[output_index++] = negative ? -current_number : current_number;
                } else {
                    return -1;
                }
                current_number = 0;
                in_number = 0;
                negative = 0;
            }
        }
    }

    if (in_number) {
        if (output_index < max_output) {
            output[output_index++] = negative ? -current_number : current_number;
        } else {
            return -1;
        }
    }

    return output_index;
}