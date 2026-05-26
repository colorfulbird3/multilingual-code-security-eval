 iba't ibang branches
}

// ✅ Ideal halimbawa: ang parehong object ay na-free sa iba't ibang branches
void *ptr = malloc(100);
if (condition) {
    free(ptr);
} else {
    ptr = NULL;  // Nullify the pointer after freeing to avoid double-freeing
}
```