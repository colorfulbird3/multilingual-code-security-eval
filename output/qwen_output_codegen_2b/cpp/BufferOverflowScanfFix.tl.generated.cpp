 ang buffer sa target buffer samao sa input parameter, sa target buffer sa size, sa maximum field width.
// 5. fgets (deprecated): Huwag kailan ang buffer sa target buffer samao sa input parameter, sa target buffer sa size, sa maximum field width.
// 6. fscanf/sscanf: Kapag kapag nagbabusa ng string, ang target buffer sa size, sa maximum field width.
// 7. scanf/fscanf: Kapag kapag nagbabusa ng string, sa target buffer sa size, sa maximum field width.
// 8. sscanf/vsscanf: Kapag kapag nagbabusa ng string, sa target buffer sa size, sa maximum field width.
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <limits.h>
// #include <stdint.h>
// #include <stdbool.h>
// #define VM_CONFIG_PARSER_H
// #include "vm_config_parser.h"
// #define VM_CONFIG_PARSER_CPP
// #include "vm_config_parser.cpp"
//
// int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config)
// {
// int ret;
// char* endptr;
// char* line = NULL;
// size_t line_size = 0;
// int max_sz = 256;
// int wc;
// char* wc_max_sz = NULL;
// char* wc_line = NULL;
// char* wc_endptr;
// int length = 0;
//
// do
// {
// line = malloc(max_sz);
// endptr = NULL;
// length = 0;
// ret = snprintf(line, max_sz, "%s", config_line);
// if (ret <= 0)
// {
// line_size = 0;
// free(line);
// return -1;
// }
// line_size = ret;
//
// // First line check
// if (line_size > 1)
// {
// wc_max_sz = malloc(line_size);
// if (wc_max_sz == NULL)
// {
// line_size = 0;
// free(line);
// return -1;
// }
// // First line format
// ret = sscanf(line, "%s%n", wc_line, &wc_endptr);
// if (ret!= 1)
// {
// line_size = 0;
// free(line);
// free(wc_max_sz);
// wc_max_sz = NULL;
// wc_line = NULL;
// wc_endptr = NULL;
// return -1;
// }
// // Check if first line is empty
// if (*wc_endptr == '\0')
// {
// free(line);
// line = NULL;
// }
// // Second line
// ret = sscanf(wc_endptr, "%s%n", wc_max_sz, &wc_endptr);
// if (ret!= 1)
// {
// line_size = 0;
// free(line);
// free(wc_max_sz);
// wc_max_sz = NULL;
// wc_line = NULL;
// wc_endptr = NULL;
// return -1;
// }
// // Check if second line is empty
// if (*wc_endptr == '\0')
// {
// line_size = 0;
// free(line);
// line = NULL;
// }
// }
// // First line
// if (line == NULL)
// {
// line = line_size == 1? malloc(1) : malloc(line_size);
// if (line == NULL)
// {
// line_size = 0;
// return -1;
// }
// ret = sscanf(line, "%s%n", wc_line, &wc_endptr);
// line_size = ret;
// if (line_size > 1)
// {
// free(line);
// line = NULL