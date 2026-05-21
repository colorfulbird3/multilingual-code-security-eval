#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#include "protocol_handler.h"

void *malloc(size_t size);
void *realloc(void *ptr, size_t size);
void free(void *ptr);

#include <signal.h>

void signal_handler(int signal);
int main(int argc, char* argv[]) {
    char buffer[128];
    int result = 0;

    result = process_protocol_message(buffer, sizeof(buffer), buffer, sizeof(buffer));

    return result;
}

void signal_handler(int signal) {
    free(buffer);
    return;
}
#endif