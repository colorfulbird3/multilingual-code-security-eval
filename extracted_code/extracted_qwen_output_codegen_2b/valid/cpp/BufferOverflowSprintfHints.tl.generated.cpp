#include "monitoring_system.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#include "logging/logging.h"

#include "utils/common.h"

#include "utils/error.h"

#define LOG(...)  LOG_ERROR(__VA_ARGS__)

#define DEFAULT_METRIC_POINT_BUFFER_SIZE  (1024 * 1024 * 5)

#define DEFAULT_METRIC_POINT_BUFFER_SIZE_MIN  (1024 * 1024 * 1)
#define DEFAULT_METRIC_POINT_BUFFER_SIZE_MAX  (1024 * 1024 * 32)

#define DEFAULT_METRIC_POINT_BUFFER_SIZE_MED  (1024 * 1024 * 4)

#define DEFAULT_METRIC_POINT_BUFFER_SIZE_LOW  (1024 * 1024 * 3)

#define METRIC_POINT_BUFFER_SIZE_MIN  (1024 * 1024 * 1)
#define METRIC_POINT_BUFFER_SIZE_MAX  (1024 * 1024 * 32)

#define METRIC_POINT_BUFFER_SIZE_MED  (1024 * 1024 * 4)

#define METRIC_POINT_BUFFER_SIZE_LOW  (1024 * 1024 * 3)

#define METRIC_POINT_BUFFER_SIZE_HIGH (1024 * 1024 * 5)

#define METRIC_POINT_BUFFER_SIZE_HUGE (1024 * 1024 * 20)

#define METRIC_POINT_BUFFER_SIZE_VERY_HUGE (1024 * 1024 * 100)

static const char* __constant METRIC_POINT_BUFFER_NAME = "metric_point_buffer";

static const char* __constant