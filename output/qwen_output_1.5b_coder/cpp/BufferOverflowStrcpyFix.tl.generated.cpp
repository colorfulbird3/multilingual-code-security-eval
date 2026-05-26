 /* Ginumili hash value ng API key */
    uint32_t hash = 0;
    for (int i = 0; api_key[i] != '\0'; i++) {
        hash = (hash << 5) + hash + api_key[i];
    }
    hash &= 0xFFFFFFFF;

    // Increment the index to move to the next slot
    current_index++;

    return hash;
}
            ]]>
        </content>
    </code>
</result>
```



