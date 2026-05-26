body_len > 0 && msg_body[body_len - 1] == '\0') ? body_len - 1 : body_len;

    /*
     * Vergelik die lengte van die boodskapliggaam met die capaciteit van die parameterbuffer.
     * Indien die boodskapliggaam groter is as die capaciteit van die parameterbuffer, retourneer -1.
     */
    if (msg_len > buffer_size) {
        return -1;
    }

    /*
     * Kopiere die string uit die boodskapliggaam naar die parameterbuffer.
     * Indien die boodskapliggaam groter is as die capaciteit van die parameterbuffer, retourneer -1.
     */
    strncpy(param_buffer, msg_body, buffer_size);
    param_buffer[buffer_size - 1] = '\0'; // Stel die buffer als null-beëindigd.

    return 0;
}
            ]]>
        </content>
    </code>
</result>
```

### Ondersteunende informering
In die boodskapliggaam word 'n string tussen twee null-bytes gevind. Hierdoor moet die lengte van die boodskapliggaam bereken word met `strlen(msg_body)`, maar dit kan ook die lengte van die boodskapliggaam zonder null-bytes bereken as `body_len`.