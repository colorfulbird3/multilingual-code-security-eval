#include <stdio.h>
#include <string.h>

int main() {
    char buffer[10];
    const char *name = "John Doe";
    int age = 30;

    // Use snprintf to prevent buffer overflow
    int result = snprintf(buffer, sizeof(buffer), "Name: %s, Age: %d", name, age);

    // Check if the output was truncated
    if (result >= sizeof(buffer)) {
        fprintf(stderr, "Warning: Output was truncated.\n");
    }

    printf("Buffer: %s\n", buffer);
    return 0;
}