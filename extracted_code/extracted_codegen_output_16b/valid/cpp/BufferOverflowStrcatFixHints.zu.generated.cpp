```c
#include <stdio.h>
#include <string.h>

int main() {
    char str1[50] = "Hello, ";
    char str2[] = "World!";
    char str3[50] = "Umongo";
    
    // strlen - ukuthola ubude besigcawu
    printf("Ubude be-'%s' ngu: %zu\n", str3, strlen(str3));
    
    // strcat - ukuhlanganisa izigcawu
    strcat(str1, str2);
    printf("Ngemva kwe-strcat: %s\n", str1);
    
    // strncat - ukuhlanganisa izigcawu ngobude obuthile
    char str4[50] = "Sawubona, ";
    strncat(str4, str3, 3);
    printf("Ngemva kwe-strncat: %s\n", str4);
    
    return 0;
}
```