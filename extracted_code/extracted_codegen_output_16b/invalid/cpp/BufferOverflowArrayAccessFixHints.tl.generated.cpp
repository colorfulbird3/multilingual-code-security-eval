arr[index] = value;
} else {
    puts("Oops!");
}

int *ptr = arr;
ptr += 20;
if (*ptr == value) {  // Buffer overflow kung katapun sa pagpapatunay
    puts("Success!");
} else {
    puts("Oops!");
}

int *dynamic = calloc(10, sizeof(int));
for (int i = 0; i < 20; i++) {  // Batay sa inaasahang laki, hindi sa aktwal na inilaan
    dynamic[i] = value;
}

free(dynamic);  // Free dynamic memory