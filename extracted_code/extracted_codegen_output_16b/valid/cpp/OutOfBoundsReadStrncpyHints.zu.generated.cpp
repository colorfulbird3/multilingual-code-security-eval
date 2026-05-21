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