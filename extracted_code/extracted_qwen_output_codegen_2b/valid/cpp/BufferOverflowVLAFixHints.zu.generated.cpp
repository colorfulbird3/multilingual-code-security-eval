ukhu futhi le-CSV
// *
// * @return 1 if okutai lukan
// */
// /*
// * isiginesha yendlela
// *
// * ukubunu ukufaye ukucubungula idatha e-CSV elilayishwe ngumsebenzisi futhi wensimu yekiye
// * ilikidiyo,
// *
// * @param field_sizes uhlu lwezintambo e-CSV olugcina usayizi
// * @param csv_data ikelomu e-CSV elilayishwe
// *
// * @return 1 if okutai lukan
// */
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer)
// #endif
// #endif
// ## ikhamiye
// http://www.cs.utah.edu/~matt/courses/cs-203/lab/csv/csv/csv-parser.c
// #include "csv_parser.h"
// using namespace std;
//
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
//     FILE* fp;
//     int i;
//     parsed_buffer = (char**)malloc(sizeof(char*)*record_count);
//
//     if (fopen_s(&fp, "file_name.csv", "r")!= 0) {
//         printf("cant open file\n");
//         return 0;
//     }
//
//     for (i = 0; i < record_count; i++) {
//         parsed_buffer[i] = (char*)malloc(1024);
//         char* name = csv_parser(fp, csv_data[i], field_sizes[i]);
//         strcpy(parsed_buffer[i], name);
//         free(name);
//     }
//     return 1;
// }
//
// /*
// * `parse_csv_records`
// *
// * isiginesha yendlela
// *
// * lo lomosyeku lukan
// *
// * Ikohuso:
// *
// * `parse_csv_records(record_count, field_sizes, csv_data, parsed_buffer)`
// *
// *
// * @param field_sizes uhlu lwezintambo e-CSV olugcina usayizi
// * @param csv_data ikelomu e-CSV elilayishwe
// *
// * @return 1 if okutai lukan
// */
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
//     char** csv_buffer;
//     int i;
//     csv_buffer = (char**)malloc(sizeof(char*)*record_count);
//
//     for (i = 0; i < record_count; i++) {
//         csv_buffer[i] = (char*)malloc(1024);
//         char* name = csv_parser(fp, csv_data[i], field_sizes[i]);
//         strcpy(csv_buffer[i], name);
//         free(name);
//     }
//
//     return 1;
// }
//
// #endif
