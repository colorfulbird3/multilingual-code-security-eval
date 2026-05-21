#include "network_config_parser.h"

/**
 * Ontleed netwerkkonfigurasieparameters en stoor dit in 'n buffer
 */
int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {