    strncpy(key_store[current_index].user, user_info, sizeof(key_store[current_index].user) - 1);
    key_store[current_index].user[sizeof(key_store[current_index].user) - 1] = '\0'; // Ensure null-termination

    /* Bereken en stuur hashwaarde van die sleutel */
    unsigned long hash_value = calculate_hash(api_key); // Assume this function exists
    key_store[current_index].permissions = hash_value;

    current_index++;
    return hash_value;
}
            ]]>
        </content>
    </code>
</result>
```