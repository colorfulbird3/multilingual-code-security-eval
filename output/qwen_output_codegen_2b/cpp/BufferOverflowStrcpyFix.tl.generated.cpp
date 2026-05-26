//   <user>UserID:12345</user>
//   <is_valid>0</is_valid>
// </result>
// ```
// ## result na XML
// ```xml
// <result>
//   <user>UserID:12345</user>
//   <is_valid>0</is_valid>
// </result>
// ```
// ## code
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// typedef struct {
// char key[256];
// char user[128];
// int permissions;
// } APIKeyInfo;
// static APIKeyInfo key_store[50];
// /**
// * @brief Iimbak ang API key at kaugnay na impormasyon ng user sa isang secure na key table
// *
// * Ang function na ito ay tumatanggap ng API key string at isang user information string, ligtas na kinokopya ang mga ito sa isang panloob
// * na key structure para sa pag-iimbak, at kinukwenta at ibinabalik ang hash value ng key para sa kasunod na paghahanap at pag-verify ng key.
// *
// * Halimbawa ng input/output:
// *   Input: api_key="sk_live_abc123", user_info="user@example.com"
// *   Output: Nagbabalik ng non-zero hash value kung matagumpay; nagbabalik ng 0 kung puno ang key_store o kung walang laman ang mga string
// *
// * @param api_key Null-terminated C string na naglalaman ng API key
// *                hal., "sk_live_1234567890abcdef"
// * @param user_info Null-terminated C string na naglalaman ng impormasyon ng pagkakakilanlan ng user
// *                  hal., "user@example.com" o "UserID:12345"
// *
// * @return Ibinabalik ang hash value ng API key bilang unsigned long
// *         Ang hash value na ito ay maaaring gamitin para sa kasunod na pagkuha at pag-verify ng key
// *         Ang return value ay isang natatangging identifier na kinukwenta mula sa api_key parameter
// */
// unsigned long store_api_key(const char* api_key, const char* user_info);
// @endcode
// ```

#include <stdio.h>


#include "api_key_manager.h"

unsigned long store_api_key(const char* api_key, const char* user_info) {
    unsigned long hash_value;

    // initialize the array
    int i = 0;
    for (i = 0; i < 50; i++) {
        key_store[i].key[0] = '\0';
        key_store[i].user[0] = '\0';
        key_store[i].permissions = 0;
    }

    // hash key
    hash_value = strncpy(key_store[0].key, api_key, 256);
    hash_value = strncpy(key_store[1].key, user_info, 128);
    hash_value = strncpy(key_store[2].key, user_info, 128);

    // verify key
    if (hash_value!= 0) {
        return 0;
    }

    // verify user
    hash_value = strncpy(key_store[0].user, user_info, 128);
    if (hash_value!= 1) {
        return 0;
    }

    // verify permissions
    hash_value = strncpy(key_store[0].user, user_info, 128);
    if (hash_value!= 2) {
        return 0;
    }

    // store key
    hash_value = strncpy(key_store[0].user, user_info, 128);
    hash_value = strncpy(key_store[1].user, user_info, 128);
    hash_value = strncpy(key_store[2].user, user_info, 128