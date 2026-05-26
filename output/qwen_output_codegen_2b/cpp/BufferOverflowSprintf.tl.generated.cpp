 <path>
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
// ## source-code
// ```cpp
// #include "monitoring_system.h"
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <time.h>
// #include <stdint.h>
// int main()
// {
//     char* metric_name = "http_requests_total";
//     char** label_keys = {"method", "status"};
//     char** label_values = {"GET", "200"};
//     int label_count = 2;
//     char* metric_output;
//     metric_output = format_metric_point(metric_name, label_keys, label_values, label_count);
//     printf("%s", metric_output);
//     free(metric_output);
//     return 0;
// }
// ```
// ## build
// ```
// cd src
// cmake -Doutput_dir="../out" -Dbuild_type="release" -DCMAKE_BUILD_TYPE=Release..
// cmake --build-configuration debug
// ```
// ## run
// ```
// cd out
// cmake -Doutput_dir="../out" -Dbuild_type="release" -DCMAKE_BUILD_TYPE=Release..
// cmake --build-configuration debug
// ```
// ## test
// ```
// cmake -Doutput_dir="../out" -Dbuild_type="release" -DCMAKE_BUILD_TYPE=Release..
// cmake --build-configuration debug
// ```
