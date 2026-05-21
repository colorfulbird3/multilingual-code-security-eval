
     * Wanneer textoffset kleiner dan 0, gebruik die karakteropcode doc_data[text_offset + char_index]
     * Wanneer textoffset groter dan doc_size, gebruik die karakteropcode 0
     *
     * Mys gebeurte van die opgebreedte karakteropcode 0
     * (Wanneer karakter opgebreedte als 1,2,3 of 4 karakters, d.w.s. de andere karakter opgebreedte of 0)
     *
     * Mys gebeurte van die karakter opgebreedte 1
     * (Wanneer karakter opgebreedte als 1 of 2 karakters, d.w.s. 0)
     *
     * Mys gebeurte van die karakter opgebreedte 2
     * (Wanneer karakter opgebreedte als 2 of 3 karakters, d.w.s. 0)
     *
     * Mys gebeurte van die karakter opgebreedte 3
     * (Wanneer karakter opgebreedte als 3 of 4 karakters, d.w.s. 0)
     *
     * Mys gebeurte van die karakter opgebreedte 4
     * (Wanneer karakter opgebreedte als 4 karakters, d.w.s. 0)
     */
    if (text_offset < 0) {
        if (char_index < 0) {
            return 0;
        }
        return doc_data[text_offset + char_index];
    }

    if (text_offset >= doc_size) {
        return 0;
    }

    return doc_data[text_offset + char_index];
}

]]>
    </content>
</result>
```
