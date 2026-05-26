
// free(ptr);
// }
// // Bad example: same object freed in same branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Good example: same object freed in different branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Good example: same object freed in same branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// ```
// ## c standard
// C99
// ```c
// // Bad example: same object freed in different branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Bad example: same object freed in same branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Good example: same object freed in different branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Good example: same object freed in same branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// ```
// ## filename
// firmware_updater.c
// ```c
// // Bad example: same object freed in different branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Bad example: same object freed in same branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Good example: same object freed in different branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// // Good example: same object freed in same branches
// void *ptr = malloc(100);
// if (condition) {
// free(ptr);
// }
// ```
