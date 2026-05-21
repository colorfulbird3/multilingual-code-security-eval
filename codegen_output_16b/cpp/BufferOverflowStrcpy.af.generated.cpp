

## uitvoer voorbeeld
Die beparende code kan word voorkomme in die `src/api_key_manager.c`-file:
```clang-format
/*
 * Copyright (c) 2015-2018 Ridoutor AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#include "api_key_manager.h"


/**
 * @brief Stoor die API-sleutel en geassosieerde gebruikersinligting in 'n veilige sleuteltabel
 * 
 * Hierdie funksie ontvang 'n API-sleutelstring en 'n gebruikersinligtingstring, kopieer hulle veilig
 * in 'n interne sleutelstruktuur vir berging, en bereken en gee die hashwaarde van die sleutel terug
 * vir daaropvolgende sleutelopsporing en verifikasie.
 *
 * Invoer/uitvoer voorbeelde:
 *   Invoer: api_key="sk_live_abc123", user_info="user@example.com"
 *   Uitvoer: Gee 'n nie-nul hashwaarde terug by sukses; gee 0 terug as key_store vol is of as leë stringe verskaf word
 *
 * @param api_key Nul-beëindigde C-string wat die API-sleutel voor