    if (body_len > msg_len) {
        copy_len = msg_len;
    } else {
        copy_len = body_len;
    }

    /*
     * Kopieer die stringparameters na die buffer.
     * Grenskontrole om bufferoorloop te voorkom.
     */
    if (copy_len > buffer_size) {
        return -1;
    }

    memcpy(param_buffer, msg_body, copy_len);
    param_buffer[copy_len] = '\0'; // Null-terminatie

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```

## oorloof
Hierdie functie werkt goed en het is geïmplementeer om die stringparameters veilig naar die buffer kopieer.