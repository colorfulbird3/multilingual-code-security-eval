 || label_values[i] == NULL) {
                return -1;
            }
            written += sprintf(metric_output + written, "%s=\"%s\"", label_keys[i], label_values[i]);
            if (i + 1 < label_count) {
                written += sprintf(metric_output + written, ",");
            }
        }
        // Append closing brace for labels
        written += sprintf(metric_output + written, "}");
    }

    // Append a newline character to the metric
    written += sprintf(metric_output + written, "\n");

    return written;
}
]]>
</content>
</result>
```

## aantal funksies
1. Formatering (bv. sprintf)
2. Uitsetlenging maatstafstring

## aantal kontroleren
1. Labels opvangen in uitset
2. Labels korrigeren
3. Formaterings funksies kontroleren
