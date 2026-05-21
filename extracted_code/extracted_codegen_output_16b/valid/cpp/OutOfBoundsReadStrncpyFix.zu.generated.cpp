#include "protocol_handler.h"

int process_protole_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0 || body_len <= 0) {
        return -1;
    }

    /* 
     * Thola ubude bomlayezo emzimbeni womlayezo.
     * Cabanga ukuthi umzimba womlayezo uwuchungechunge oluphethwe ngu-null, nakuba i-body_len icacisa ububanzi.
     */
    int msg_len = (int)strlen(msg_body);

    /* Hlola ukuthi i-msg_len ayidluli i-body_len ukuze kugwenywe ukufunda imemori engaqalisiwe */
    if (msg_len > body_len) {
        msg_len = body_len;
    }

    int copy_len;
    if (msg_len < buffer_size) {
        copy_len = msg_len;
    } else {
        copy_len = buffer_size - 1;
    }

    /* Yenza ikhophi yememori */
    memcpy(param_buffer, msg_body, copy_len);
    
    /* Qinisekisa ukuthi uchungechunge luphethwe ngu-null */
    param_buffer[copy_len] = '\0';

    return 0;
}