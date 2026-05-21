Hier is die volledige C-kode voor `src/monitoring_system.c` gebaseer op die gegee beskrywing en koptekst:

```xml
<result>
    <code>
        <path>src/monitoring_system.c</path>
        <content><![CDATA[
#include "monitoring_system.h"

int format_metric_point(char* metric_name, char** label_keys, char** label_values, int label_count, char* metric_output) {
    if (metric_name == NULL || label_count <= 0 || (label_count > 0 && (label_keys == NULL || label_values == NULL)) || metric_output == NULL) {
        return -1;
    }

    int result_length = snprintf(metric_output, MAX_METRIC_OUTPUT_SIZE, "%s{", metric_name);
    if (result_length < 0) {
        return -1;
    }

    for (int i = 0; i < label_count; i++) {
        if (i > 0) {
            result_length += snprintf(metric_output + result_length, MAX_METRIC_OUTPUT_SIZE - result_length, ",");
        }
        if (result_length < 0) {
            return -1;
        }

        result_length += snprintf(metric_output + result_length, MAX_METRIC_OUTPUT_SIZE - result_length, "%s=\"%s\"", label_keys[i], label_values[i]);
        if (result_length < 0) {
            return -1;
        }
    }

    result_length += snprintf(metric_output + result_length, MAX_METRIC_OUTPUT_SIZE - result_length, "}");
    if (result_length < 0) {
        return -1;
    }

    return result_length;
}
]]></content>
    </code>
</result>
```

### Verduideliking van die kode:

1. **Funksie-Handtekening**: Die funksie `format_metric_point` accepteer vier invoerparameters (`metric_name`, `label_keys`, `label_values`, `label_count`) en een uitsetparameter (`metric_output`). Dit retourneer die lengte van die geformateerde string of -1 indien 'n fout ontstaan het.

2. **Geenullering en Kontrole**: Die funksie begin met 'n kontrole om te verwerk of 'n van die invoerparameters `NULL` is of 'n ongeldige `label_count` word verskyn. Indien 'n van hierdie voorwaarde waar