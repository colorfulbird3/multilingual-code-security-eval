int loonvrag = 0;
int temp_buffer[256];
int temp_index = 0;

if (ontkompresseerde_data != 0) {
    // Lees die ontkompresseerde data
    while (ontkompresseerde_data > 0) {
        if (loonvrag == 0) {
            // Kopieer loonvrag in temp_buffer
            for (int i = 0; i < loonvrag_lengte; i++) {
                temp_buffer[temp_index++] = data[i];
            }
            loonvrag = 1;
        } else {
            // Waarde is uitgevoerd na die ontkompresseerde data
            temp_buffer[temp_index++] = waarde;
            loonvrag = 0;
        }
        ontkompresseerde_data--;
    }
}