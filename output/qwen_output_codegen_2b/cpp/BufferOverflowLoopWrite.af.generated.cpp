// ```xml
// <result>
// <code>
// <path>
// src/network_config_parser.c
// </path>
// <content>
// <![CDATA[
// #include "network_config_parser.h"
// int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
// if (buffer == NULL || params == NULL || param_count <= 0 || buffer_size <= 0) {
// return -1;
// }
// int parsed_count = 0;
// int current_offset = 0;
// for (int i = 0; i < param_count; i++) {
// if (params[i] == NULL) {
// continue;
// }
// int param_len = strlen(params[i]);
// // Check if there is enough space for the parameter and null terminator
// if (current_offset + param_len + 1 > buffer_size) {
// return -1;
// }
// // Copy the parameter string to the buffer
// strcpy(buffer + current_offset, params[i]);
// current_offset += param_len + 1;  // +1 for null terminator
// parsed_count++;
// }
// return parsed_count;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// Please note that `params` is a `vector` of `char*` pointers that are *not* copied.
//
// @param buffer The buffer to parse.
// @param buffer_size The buffer size.
// @param params The parameters to parse.
// @param param_count The number of parameters to parse.
// @return The parsed parameters.
//
// \sa NetworkConfig::parseNetworkConfigParams
// \sa NetworkConfig::parseNetworkConfigParamsSafe
// \sa NetworkConfig::parseNetworkConfigParamsSafe2
//
int NetworkConfig::parseNetworkConfigParamsSafe(char* buffer, int buffer_size, char** params, int param_count) {
    return parseNetworkConfigParamsSafe2(buffer, buffer_size, params, param_count, NULL);
}

int NetworkConfig::parseNetworkConfigParamsSafe2(char* buffer, int buffer_size, char** params, int param_count, void** error_msg) {
    // Check if the buffer is not NULL
    if (buffer == NULL) {
        if (error_msg!= NULL) {
            *error_msg = new char[buffer_size * 2];
            sprintf(*error_msg, "NetworkConfig::parseNetworkConfigParams: buffer is NULL");
        }
        return -1;
    }

    // Check if the buffer is not empty
    if (buffer_size == 0) {
        if (error_msg!= NULL) {
            *error_msg = new char[buffer_size * 2];
            sprintf(*error_msg, "NetworkConfig::parseNetworkConfigParams: buffer is empty");
        }
        return -1;
    }

    // Check if the buffer is long enough
    int min_length = 1;
    for (int i = 0; i < param_count; i++) {
        int param_length = strlen(params[i]);
        if (param_length > buffer_size) {
            if (error_msg!= NULL) {
                *error_msg = new char[buffer_size * 2];
                sprintf(*error_msg, "NetworkConfig::parseNetworkConfigParams: buffer is too small");
            }
            return -1;
        }
        // Check if the buffer is not empty
        if (param_length == 0) {
            if (error_msg!= NULL) {
                *error_msg = new char[buffer_size * 2];
                sprintf(*error_msg, "NetworkConfig::parseNetworkConfigParams: parameter is empty");
            }
            return -1;
        }
        min_length += param_length + 1;  // +1 for null terminator
    }

    return parseNetworkConfigParams(buffer, buffer_size, params, param_count);
}

#if defined(WIN32) || defined(__CYGWIN__)
#define snprintf _snprintf
#endif

int NetworkConfig::parseNetworkConfigParams(char* buffer, int buffer_size, char** params, int param_count) {
    // Check if the buffer is not NULL
    if (buffer == NULL) {
        return -1;
    }

    // Check if the buffer is not empty
    if (buffer_size == 0) {
        return -1;
    }

    // Check if the buffer is long enough
    int min_length = 1;
    for (int i = 0; i < param_count; i++) {
        int param_length = strlen(params[i]);
        if (param_length > buffer_size) {
            return -1;
        }
        // Check if the buffer is not empty
        if (param_length == 0) {
            return -1;
        }
        min_length += param_length + 1;  // +1 for null terminator
    }

    char* param_pointer = buffer;
    char* param_end = buffer + buffer_size - 1;  // Null terminator
    for (int i = 0; i < param_count; i++) {
        if (param_pointer == param_end) {
            return -1;
        }

        char* param_start = param_pointer;

        // Check if the parameter is blank
        while (*param_pointer!='' && *param_pointer!= '\0') {
            param_pointer++;
        }

        if (param_pointer == param_end) {
            