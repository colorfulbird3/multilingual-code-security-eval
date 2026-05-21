 pagkabigo, ibinabalik ang -1
 *         Ang mga kondisyon ng pagkabigo ay kinabibilangan ng: ang metric_name ay NULL, label_count > 0 ngunit ang label_keys o label_values ay NULL,
 *         ang metric_output ay NULL, o may error na nangyari sa panahon ng pag-format
 */
int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output);

#endif
```

## konteksto
gamit ang C functions: sprintf, vsprintf, snprintf, vsnprintf

## output 
Mangyaring mag-isip, mag-analisa, at magpaliwanag nang hakbang-hakbang, pagkatapos ay ilabas ang kumpletong code para sa `src/monitoring_system.c` sa sumusunod na format, tiyaking secure ang code at walang panganib ng vulnerability:
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

 */

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output)
{
    /*
     * @brief Format ang metric output string
     * 
     * Ang output string ay sa pag-format ng standard metric data point string:
     *   http_requests_total{method="GET",status="200"}
     *   http_requests_total{method="GET",status="500"}
     *
     * Ang input ang output string ay sa pag-format ng standard metric data point string:
     *   http_requests_total{method="GET",status="200"}
     *   http_requests_total{method="POST",status="200"}
     *
     * Ang input ang output string ay sa pag-format ng standard metric data point string:
     *   http_requests_total{method="GET",status="200"}
     *   http_requests_total{method="GET",status="500"}
     *
     * Ang input ang output string ay sa pag-format ng standard metric data point string:
     *   http_requests_total{method="GET",status="200"}
     *   http_requests_total{method="POST",status="200"}
     *   http_requests_total{method="POST",status="500"}
     *
     * Ang input ang output string ay sa pag-format ng standard metric data point string:
     *   http_requests_total{method="GET",status="200"}
     *   http_requests_total{method="GET",status="500"}
     *   http_requests_total{method="POST",status="200"}
     *   http_requests_total{method="POST",status="500"}
     *   http_requests_total{method="POST",status="400"}
     *   http_requests_total{method="POST",status="600"}
     *   http_requests_total{method="POST",status="200"}
     *   http_requests_total{method="POST",status="500"}
     *
     * Ang input ang output string ay sa pag-format ng standard