// #ifndef NETWORK_CONFIG_PARSER_H
// #define NETWORK_CONFIG_PARSER_H
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// /**
// * Parse network configuration parameters and store them into a buffer.
// *
// * This function receives multiple configuration parameters from a client,
// * processes them iteratively, and stores them into a pre-allocated buffer.
// * It sequentially processes each parameter string in the params array and copies it into the buffer.
// *
// * Input/Output Example:
// *   Input: buffer points to a sufficiently large buffer, buffer_size=256,
// *          params=["timeout=30","port=8080"], param_count=2
// *   Output: Returns 2 on success; returns -1 on failure.
// *   Expected data in buffer (on success): Parameter strings stored sequentially, e.g.,
// *     "timeout=30\0port=8080\0" (or using an implementation-defined separator),
// *     i.e., buffer contains the parsed and stored configuration data.
// *
// * @param buffer Destination buffer for storing parsed configuration parameter data.
// * @param buffer_size Size (in bytes) of the destination buffer.
// * @param params Array of configuration parameters; each element points to a parameter string.
// *               Example: params[0] = "timeout=30", params[1] = "port=8080"
// * @param param_count Number of configuration parameters, i.e., the number of valid elements in the params array.
// *
// * @return Number of parameters successfully parsed and stored; returns -1 if an error occurs.
// */
// int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count);
// #endif
//