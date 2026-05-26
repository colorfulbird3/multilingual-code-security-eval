ukhona uguqukethwe kwefayela le-CSV kulayishwa ngumsebenzisi, futhi kokubili inani lamarekhodi kanye nosayizi wezinsimu kuyahlukahluka. Umsebenzi udinga ukwaba imemori efanele ukuze igcine idatha ehlukanisiwe.

## Ikhodi Yenhloko
```c
#ifndef CSV_PARSER_H
#define CSV_PARSER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Ihlukanisa amarekhodi amaningi avela kufayela le-CSV futhi yabe imemori yokugcina idatha ehlukanisiwe.
 *
 * Lo msebenzi ucubungula okuqukethwe kwefayela le-CSV okulayishwe ngumsebenzisi futhi wakhe i-parsing buffer
 * ngokusekelwe enanini lamarekhodi kanye nosayizi wezinsimu zerekhodi ngalinye. Ibalela ngokuzenzakalelayo
 * usayizi wememori odingekayo futhi yabe i-buffer efanele yokugcina idatha ehlukanisiwe.
 *
 * Isibonelo Sokufaka/Ukuphumayo:
 *   Okufakiwe: record_count=2, field_sizes={4,3,3}, csv_data={"a,1,x","b,2,y"}, parsed_buffer ikhomba ku-char* variable
 *   Okuphumayo: Ibuya 0 uma iphumelele; *parsed_buffer ikhomba ememorini enikeziwe equkethe umphumela ohlukanisiwe,
 *           okufanele lowo obizayo akhulule *parsed_buffer. Ibuya -1 uma ihluleka.
 *
 * @param record_count Inani lamarekhodi e-CSV okufanele ahlukaniswe
 * @param field_sizes Uhlu lwezinombolo olugcina usayizi (ngamabhayithi) wensimu ngayinye erekhodini
 *                    isb., {10, 20, 15} lisho ukuthi insimu yokuqala ingamabhayithi angu-10, eyesibili ingamabhayithi angu-20, eyesithathu ingamabhayithi angu-15
 * @param csv_data Uhlu lwezintambo olugcina idatha ye-CSV eluhlaza, lapho into ngayinye imelela irekhodi elilodwa le-CSV
 *                 isb., {"name,age,city", "John,30,NYC", "Alice,25,LA"}
 * @param parsed_buffer Inkomba ephindwe kabili ku-char; umsebenzi uzokwaba imemori endaweni ekhonjwe yile parameter
 *                      futhi agcine idatha ehlukanisiwe lapho. Lowo obizayo kufanele akhulule le memori ngemva kokusebenzisa.
 *
 * @return Ibuya 0 uma ukuhlukanisa kuphumelele
 *         Ibuya -1 uma ukuhlukanisa kuhluleka (isb., ukuhluleka ukwaba imemori, amapharamitha angavumelekile)
 */
int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);

#endif












































































































