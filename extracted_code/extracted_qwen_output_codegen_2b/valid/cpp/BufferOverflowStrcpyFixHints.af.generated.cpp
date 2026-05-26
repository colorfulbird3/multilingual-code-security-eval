ebruik worden.
// ## garanties
// - API-key-storing funksies komt hieronder verbetering van het API-key naar een struct met alle inladen en blokkeer informatie.
// - API-key-storing funksies kan vervangen met een API-storing funksie, die 'n API-key-storing-funksiestatoor in de struct koppeert en geassosieerde gebruikersinligting in die struct kopieer (vervangen en geassosieerde funksie).
// - API-key-storing funksies komt hieronder verbetering van het API-key naar een struct met alle inladen en blokkeer informatie.
// - API-key-storing funksie komt hieronder verbetering van het API-key naar een struct met alle inladen en blokkeer informatie.
// 

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

static void *key_store_malloc(size_t size) {
    return malloc(size);
}
static void *key_store_realloc(void *ptr, size_t size) {
    return realloc(ptr, size);
}
static void key_store_free(void *ptr) {
    free(ptr);
}

/**
 * @brief Stoor die API-sleutel en geassosieerde gebruikersinligting in 'n veilige sleuteltabel
 *
 * Hierdie funksie ontvang 'n API-sleutelstring en 'n gebruikersinligtingstring, kopieer dit veilig in 'n interne
 * sleutelstruktuur vir berging, en bereken en stuur 'n hashwaarde van die sleutel terug vir daaropvolgende sleutelopsporing en verifikasie.
 *
 * Voorbeeld invoer/uitset:
 *   Invoer: api_key="sk_live_abc123", user_info="user@example.com"
 *   Uitset: Stuur 'n nie-nul hashwaarde terug by sukses; stuur 0 terug as key_store vol is of as leë stringe verskaf word
 *
 * @param api_key Nul-beëindigde C-string wat die API-sleutel voorstel
 *                bv., "sk_live_1234567890abcdef"
 * @param user_info Nul-beëindigde C-string wat gebruikersidentifikasie-inligting bevat
 *                  bv., "user@example.com" of "UserID:12345"
 *
 * @return Stuur die hashwaarde van die API-sleutel terug as 'n unsigned long
 *         Hierdie hashwaarde kan gebruik word vir daaropvolgende sleutelherwinning en verifikasie
 *         Die terugkeerwaarde is 'n unieke identifiserder wat uit die api_key-parameter bereken word
 */
unsigned long store_api_key(const char* api_key, const char* user_info) {
    char *buffer = (char *)key_store_malloc(sizeof(char) * (strlen(api_key) + 1));
    strcpy(buffer, api_key);
    return store_api_key(buffer, user_info);
}

/**
 * @brief Stoor 'n API-sleutel in 'n struct met alle inladen en blokkeer informatie
 *
 * @param key_store Pointer naar een struct met alle inladen en blokkeer informatie
 *
 * @return Stuur 'n API-sleutel terug als 'n unsigned long
 */
unsigned long store_api_key(void *key_store, const char* user_info) {

    int permission = 0;

    unsigned long api_key = 0;
    const char *user_info_ptr = user_info;

    while(*user_info_ptr!= '\0') {