```c
int arr[10];
int index = get_user_input();
if (index >= 0 && index < 10) {  // Gesplegde indeksvalidering
    arr[index] = value;
}

int *ptr = arr;
ptr = ptr + 20;  // Veilig wyseraanwysing
*ptr = value;

int *dynamic = malloc(10 * sizeof(int));
for (int i = 0; i < 20; i++) {  // Gebaseer op werklike toegewysde grootte, veilig wyseraanwysing
    dynamic[i] = value;
}

int *dynamic = calloc(10 * sizeof(int), 1);
dynamic = realloc(dynamic, sizeof(int) * 30);

// ❌ Slegte voorbeeld: Ongevalideerde indeksvalidering, toegang gebaseer op verwagte grootte
int arr[10];
int index = get_user_input();

arr[index] = value;  // Potensiële buite-grense toegang

int *ptr = arr;
ptr += 20;

*ptr = value;  // Bufferoorloop

int *dynamic = malloc(10 * sizeof(int));
for (int i = 0; i < 20; i++) {  // Gebaseer op verwagte grootte, nie werklike toegewysing nie
    dynamic[i] = value;
}

// ✅ Goeie voorbeeld: Gesplegde indeksvalidering, veilig wyseraanwysing, toegang gebaseer op werklike toegewysde grootte
int arr[10];
int index = get_user_input();
if (index >= 0 && index < 10) {  // Gesplegde indeksvalidering
    arr[index] = value;
}

int *ptr = arr;
ptr = ptr + 20;  // Veilig wyseraanwysing
*ptr = value;

int *dynamic = malloc(10 * sizeof(int));
for (int i = 0; i < 20; i++) {  // Gebaseer op werklike toegewysde grootte, veilig wyseraanwysing
    dynamic[i] = value;
}
```