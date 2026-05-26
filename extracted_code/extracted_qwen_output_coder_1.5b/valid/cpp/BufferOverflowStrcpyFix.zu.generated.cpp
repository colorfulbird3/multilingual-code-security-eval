#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

typedef struct {
    char key[256];
    char user[128];
    int permissions;
} APIKeyInfo;

static APIKeyInfo key_store[50];

/**
 * @brief Gcina ukhiye we-API nolwazi lomsebenzisi oluhambisanayo kuthebula eliphephile lokhiye
 * 
 * Lo msebenzi uthola intambo yokhiye we-API kanye nentambo yolwazi lomsebenzisi, izikopishe ngokuphephile
 * esakhiweni sangaphandle sokhiye ukuze zigcinwe, futhi ibale futhi ibuyisele inani le-hashi lokhiye
 * ukuze kutholwe futhi kuqinisekiswe ukhiye ngokulandelayo.
 *
 * Isibonelo sokufaka/ukuphuma:
 *   Okufakiwe: api_key="sk_live_abc123", user_info="user@example.com"
 *   Okuphumayo: Ibuyisela inani le-hashi elingeyona i-zero uma iphumelele; ibuyisela u-0 uma key_store igcwele noma uma kunikezwe izintambo ezingenalutho
 *
 * @param api_key Intambo ye-C ephethwe ngu-null equkethe ukhiye we-API
 *                isib., "sk_live_1234567890abcdef"
 * @param user_info Intambo ye-C ephethwe ngu-null equkethe ulwazi lokuhlonza umsebenzisi
 *                  isib., "user@example.com" noma "UserID:12345"
 * 
 * @return Ibuyisela inani le-hashi lokhiye we-API njenge-unsigned long
 *         Leli nani le-hashi lingasetshenziswa ukuthola nokuqinisekisa ukhiye ngokulandelayo
 *         Inani elibuyiselwayo liwumkhombisi ohlukile obalwa kusukela ku-paramitha ye-api_key
 */
unsigned long store_api_key(const char* api_key, const char* user_info);