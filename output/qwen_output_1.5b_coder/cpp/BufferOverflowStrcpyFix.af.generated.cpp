].key, api_key);
    strncpy(key_store[current_index].user, user_info, sizeof(key_store[current_index].user) - 1);
    key_store[current_index].user[sizeof(key_store[current_index].user) - 1] = '\0'; // Ensure null-termination

    /* Generate a unique ID for the key */
    unsigned long id = generate_unique_id(api_key);

    key_store[current_index].permissions = 0; // Initialize permissions to zero

    current_index++;

    return id;
}

unsigned long generate_unique_id(const char* api_key) {
    // Implement logic to generate a unique ID based on the API key
    // For simplicity, let's just use the first 8 characters of the API key
    return strtoul(api_key, NULL, 16); // Convert hexadecimal string to unsigned long
}
            ]]>
        </content>
    </code>
</result>
```