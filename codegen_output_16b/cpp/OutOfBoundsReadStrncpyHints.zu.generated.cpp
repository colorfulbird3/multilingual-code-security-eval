

## Isibonelo
```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * @brief Okupha lapho ngokuphakele okufanele (ngamabhayithi).
 * 
 * @param msg_body Laka ngesinyathelo okuhobona (ngamabhayithi).
 * @param body_len Laka ngesinyathelo okuhobona (ngamabhayithi).
 * @param param_buffer Okupha lapho ngokuphakele okufanele (ngamabhayithi).
 * @param buffer_size Okupha lapho ngokuphakele okufanele (ngamabhayithi).
 * 
 * @return Ibuyisela u-0 uma iphumelele, -1 uma ihlulekile.
 */
int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size);
```

## Umongo
```c
#define BUFFER_SIZE (128)

typedef enum {
    CONSTANT,
    GET_CODE,
    GET_PATH,
    GET_CONTENT,
} CODE;

typedef enum {
    EQUALS,
    NOTEQUALS,
    CONTAINS,
    NOTCONTAINS,
} OPERATOR;

#define CODE_CONSTANT 0
#define CODE_GET_CODE 1
#define CODE_GET_PATH 2
#define CODE_GET_CONTENT 3

#define EQUALS 0
#define NOTEQUALS 1
#define CONTAINS 2
#define NOTCONTAINS 3

typedef struct {
    CODE code;
    OPERATOR operator;
    char* value;
} PARAM;

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size);

int process_protocol_message(const char* msg_body, int body_