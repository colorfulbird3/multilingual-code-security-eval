int parse_layer_data(const char* layer_data[], int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_index < 0 || layer_index >= layer_count) {
        return -1;
    }
    if (layer_data[layer_index] == NULL) {
        return -1;
    }
    int length = 0;
    while (layer_data[layer_index][length] != '\0') {
        length++;
    }
    if (length > max_layer_size) {
        return -1;
    }
    return length;
}