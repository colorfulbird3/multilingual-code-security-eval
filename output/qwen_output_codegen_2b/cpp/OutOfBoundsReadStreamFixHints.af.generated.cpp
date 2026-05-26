
// 2. Wanneer data uit 'n stroom of toestel gelees word, moet die leeslengte tekstdatum beperk word om nie die teikenbufferkapasiteit te oorskry nie om buite-grens leeswerk te voorkom.
// 3. Wanneer data uit 'n stroom of toestel gelees word, moet die leeslengte tekstdatum beperk word om nie die teikenbufferkapasiteit te oorskry nie om buite-grens leeswerk te voorkom.
// 4. Gebruik 'n 'c-truiteke op die leeslengte om die verwerkte op de leeslengte tekst datum te konfigureren.
// 5. Gebruik 'n's-truiteke op die leeslengte om die verwerkte op de leeslengte tekst datum te konfigureren.

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#include "docs.h"


char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index)
{


  return doc_data[text_offset + char_index];
}
