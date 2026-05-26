#define MONITORING_SYSTEM_C_H
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdint.h>
#include <string.h>
#include <stdarg.h>
#include <va_list.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>
#include <limits.h>
#include <malloc.h>
#include <errno.h>
#include <unistd.h>

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output);