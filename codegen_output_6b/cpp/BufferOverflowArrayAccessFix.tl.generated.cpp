 size = get_size();
if (size >= 0) {  // i-validate ang size
    char *data = malloc(size);
    int *ptr = data;
    for (int i = 0; i < size; i++) {  // boundary check
        *ptr = value;
        ptr++;
    }
}

// ❌ Masamang halimbawa: walang paunang kapamahit na array, kapag halaga ng array sa dapok ang pag-access, at kaparang sa inaasahang laki o ng pag-access
const int arr[] = {1, 2, 3, 4, 5};

int index = get_user_input();
if (index <= 3) {  // boundary check
    arr[index] = value;
}

int *ptr = arr;
ptr += index;
*ptr = value;

// ✅ Masamang halimbawa: walang ang paunang kapamahit na array, kapag halaga ng array sa dapok ang pag-access, at kaparang sa inaasahang laki o ng pag-access
char arr[] = {1, 2, 3, 4, 5};

int index = get_user_input();
if (index <= 3) {  // boundary check
    arr[index] = value;
}

int *ptr = arr;
ptr += index;
*ptr = value;

```

## bakasamang
1. Nangagawing ang mga kopya o gagawing ng kapareng kaya, sa kapareng kaya sa mga array
2. Nangagawing ang mga kopya o gagawing ng kapareng kaya, sa kapareng kaya sa mga array
3. Nangagawing ang mga kopya o gagawing ng kapareng kaya, sa kapareng kaya sa mga array
4. Nangagawing ang mga kopya o gagawing ng kapareng kaya, sa kapareng kaya sa mga array
5. Nangagawing ang mga kop