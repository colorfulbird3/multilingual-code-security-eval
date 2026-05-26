

## sample input

```xml
<request>
    <metric_name>http_requests_total</metric_name>
    <label_keys>
        <label_key>method</label_key>
        <label_key>status</label_key>
    </label_keys>
    <label_values>
        <label_value>GET</label_value>
        <label_value>200</label_value>
    </label_values>
    <duration>1.00000</duration>
</request>
```

## sample output
(Pagkabigo: http_requests_total{method="GET",status="200"})
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## author
Author:  Krishna Ram

## revision
Revision: 0
"""

## begin
import sys

## initialize
header_code = '''
#ifndef MONITORING_SYSTEM_H
#define MONITORING_SYSTEM_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <time.h>

/**
 * @brief I-format ang performance metric data points para sa monitoring system
 * 
 * I-format ang metric name at label key-value pairs sa standardized monitoring data point string.
 * Ang nabuong format ay: metric_name{label_key1="label_value1",label_key2="label_value2",...}
 *
 * Halimbawa ng input/output:
 *   Input: metric_name="http_requests_total", label_keys=["method","status"], label_values=["GET","200"], label_count=2, metric_output ay tumuturo sa sapat na malaking buffer
 *   Output: Sa tagumpay, ibinabalik ang haba ng formatted string; ang metric_output ay naglal