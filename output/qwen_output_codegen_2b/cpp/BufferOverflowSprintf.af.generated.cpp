// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## klasse
// @class monitoring_system
// @package monitoringsystem

// ## helper functions
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// #include <time.h>
// #include <limits.h>
// #include <stdint.h>
// /**
// * @brief Print error message and exit with a status of 1
// *
// * Prints error message and exits program with status 1
// *
// * @param error_msg Error message
// */
// void print_error_and_exit(char* error_msg)
// {
//   fprintf(stderr, "%s\n", error_msg);
//   exit(1);
// }
//
// /**
// * @brief Print warning message and exit with a status of 0
// *
// * Prints warning message and exits program with status 0
// *
// * @param warn_msg Warning message
// */
// void print_warning_and_exit(char* warn_msg)
// {
//   fprintf(stderr, "%s\n", warn_msg);
//   exit(0);
// }
// ```
// ## helper functions
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// #include <time.h>
// #include <limits.h>
// #include <stdint.h>
// /**
// * @brief Generate a monitering system header file
// *
// * Generate a monitering system header file to serve as a template
// *
// * @param out_filename File to write to
// *
// * @return On success, returns the length of the formatted string (excluding the '\0' terminator); on failure, returns -1
// */
// int generate_header(char* out_filename)
// {
//   int error_code = 0;
//   FILE* fp = NULL;
//   char* header_code = NULL;
//   char* filename = NULL;
//
//   // Open output file
//   fp = fopen(out_filename, "w");
//   if (fp == NULL)
//     {
//       print_error_and_exit("Could not open the output file %s for writing\n", out_filename);
//     }
//
//   // Generate header code
//   header_code = generate_header_code();
//   if (snprintf(fp, header_code, filename) < 0)
//     {
//       print_error_and_exit("Could not generate header code\n");
//     }
//   fclose(fp);
//   free(header_code);
//   return strlen(filename);
// }
//
// /**
// * @brief Generate a monitering system header file
// *
// * Generate a monitering system header file to serve as a template
// *
// * @param out_filename File to write to
// *
// * @return On success, returns the length of the formatted string (excluding the '\0' terminator); on failure, returns -1
// */
// char* generate_header_code()
// {
//   int header_code_size = 0;
//   int error_code = 0;
//   char* header_code = NULL;
//
//   // Pre-condition: filename is not NULL
//   if (filename == NULL)
//     {
//       print_error_and_exit("Filename is NULL, cannot generate header file\n");
//     }
//
//   header_code_size = strlen(filename);
//   header_code = (char*)malloc(header_code_size + 1); // '\0' termination
//   if (snprintf(header_code, header_code_size + 1, "%s", filename) < 0)
//     {
//       print_error_and_exit("Could not generate header code\n");
//     }
//
//   return header_code;
// }
// ```
// ## program
// ```c
// #include <stdio.h>
// #include <std