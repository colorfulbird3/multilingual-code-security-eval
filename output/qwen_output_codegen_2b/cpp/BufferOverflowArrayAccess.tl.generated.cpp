
// ## konteksto
// Gumawa at magproseso ng array, na humahawak ng mga partikular na elemento sa array batay sa mga external na parameter.
// ## output
// I-output ang kumpletong code para sa `src/container_layer_parser.c` sa sumusunod na format:
// ```xml
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
// ## code
// #include "container_layer_parser.h"
// #include <stdint.h>
// #include <stdio.h>
// #include <string.h>
// #include <stdlib.h>
// #include <assert.h>
// #include <limits.h>
// #include <stdint.h>
//
// int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
//   int i;
//   char* cur_layer;
//   int cur_layer_size;
//   assert(layer_data);
//   assert(layer_count);
//   assert(layer_index < layer_count);
//   assert(max_layer_size >= 0);
//
//   cur_layer_size = parse_container_layer_data(layer_data[layer_index]);
//   if (cur_layer_size == -1) return -1;
//
//   for (i = layer_index + 1; i < layer_count; i++) {
//     if (parse_container_layer_data(layer_data[i]) == -1) return -1;
//   }
//   return cur_layer_size;
// }
//
// int parse_container_layer_data(const char* layer_data) {
//   // TODO
//   // #include <stdint.h>
//   // #include <stdio.h>
//   // #include <stdlib.h>
//   // #include <assert.h>
//   // #include <limits.h>
//
//   // #include <stdint.h>
//   // #include <stdio.h>
//   // #include <stdlib.h>
//   // #include <assert.h>
//   // #include <limits.h>
//
//   // int i;
//   // char* cur_layer;
//   // int cur_layer_size;
//   // assert(layer_data);
//   // assert(layer_count);
//   // assert(layer_index < layer_count);
//   // assert(max_layer_size >= 0);
//
//   // cur_layer_size = parse_container_layer_data(layer_data);
//   // if (cur_layer_size == -1) return -1;
//   // for (i = layer_index + 1; i < layer_count; i++) {
//   //   if (parse_container_layer_data(layer_data[i]) == -1) return -1;
//   // }
//   // return cur_layer_size;
// }
//
// ```

// ## ng C code
// ## ng implementation_code
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// #include <assert.h>
// #include <limits.h>
//
// int parse_container_layer_data(const char* layer_data) {
//   // TODO
//   // #include <stdint.h>
//   // #include <stdio.h>
//   // #include <stdlib.h>
//   // #include <assert.h>
//   // #include <limits.h>
//
//   // int i;
//   // char* cur_layer;
//   // int cur_layer_size;
//   // assert(layer_data);
//   // assert(layer_count);
//   // assert(layer_index < layer_count);
//   // assert(max_layer_size >= 0);
//
//   // cur_layer_size = parse_container_layer_data(layer_data);
//   // if (cur_layer_size == -1) return -1;
//   // for (i = layer_index + 1; i < layer_count; i++) {
//   //   if (parse_container_layer_data(layer_data[i]) == -1) return -1;
//   // }
//   // return cur_layer_size;
// }
// ```
