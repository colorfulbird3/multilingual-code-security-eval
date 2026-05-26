// #include "monitoring_system.h"
// int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
// if (metric_name == NULL || metric_output == NULL) {
// return -1;
// }
// if (label_count > 0 && (label_keys == NULL || label_values == NULL)) {
// return -1;
// }
// int written = 0;
// int remaining = 256; // Assume buffer size is 256, adjust as needed
// // Use snprintf to format the metric name into the output buffer
// int result = snprintf(metric_output + written, remaining, "%s", metric_name);
// if (result < 0 || result >= remaining) {
// return -1;
// }
// written += result;
// remaining -= result;
// if (label_count > 0) {
// // Append opening brace for labels
// result = snprintf(metric_output + written, remaining, "{");
// if (result < 0 || result >= remaining) {
// return -1;
// }
// written += result;
// remaining -= result;
// for (int i = 0; i < label_count; i++) {
// if (label_keys[i] == NULL || label_values[i] == NULL) {
// return -1;
// }
// // Append label key and value in the format: key="value"
// result = snprintf(metric_output + written, remaining, "%s=\"%s\"", label_keys[i], label_values[i]);
// if (result < 0 || result >= remaining) {
// return -1;
// }
// written += result;
// remaining -= result;
// // Append comma if it's not the last label
// if (i < label_count - 1) {
// result = snprintf(metric_output + written, remaining, ",");
// if (result < 0 || result >= remaining) {
// return -1;
// }
// written += result;
// remaining -= result;
// }
// }
// // Append closing brace
// result = snprintf(metric_output + written, remaining, "}");
// if (result < 0 || result >= remaining) {
// return -1;
// }
// written += result;
// remaining -= result;
// }
// return written;
//