// *
// * @see http://stackoverflow.com/questions/182088/how-to-use-c-standard-c-c99-c-header-files-for-metric-calculations
// */
// int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output)
// {
//     int metric_output_size = 4096;
//     char metric_output[metric_output_size];
//     char* end_of_metric_output = metric_output;
//     int i = 0;
//     for (i = 0 ; i < label_count; i++) {
//         snprintf(end_of_metric_output, metric_output_size, "%s=%s", label_keys[i], label_values[i]);
//         end_of_metric_output += strlen(metric_output + i);
//     }
//     snprintf(end_of_metric_output, metric_output_size, ";");
//     end_of_metric_output += strlen(metric_output + i);
//     int result = snprintf(metric_output, metric_output_size, "%s", metric_name);
//     //printf("result: %d\n", result);
//     if (result >= metric_output_size) {
//         printf("metric_output_size: %d\n", metric_output_size);
//         result = -1;
//     }
//     return result;
// }
// #endif
//
// int main() {
//     char* label_keys[] = {
//         "method",
//         "status",
//     };
//     char* label_values[] = {
//         "GET",
//         "200",
//     };
//     int label_count = sizeof(label_keys) / sizeof(label_keys[0]);
//     char* metric_name = "http_requests_total";
//     char metric_output[] = "http_requests_total=GET;200";
//     int result = format_metric_point(metric_name, label_keys, label_values, label_count, metric_output);
//     if (result == -1) {
//         printf("result: %d\n", result);
//         exit(0);
//     }
//     printf("metric_output: %s\n", metric_output);
//     return 0;
// }
// #endif