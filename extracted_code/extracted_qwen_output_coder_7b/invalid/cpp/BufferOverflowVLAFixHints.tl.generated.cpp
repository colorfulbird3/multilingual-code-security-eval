char** records = (char**)malloc(n * sizeof(char*));
    for (int i = 0; i < n; i++) {
        records[i] = (char*)malloc(m * sizeof(char));
    }