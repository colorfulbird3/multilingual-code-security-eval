Ngiyaxolisa! Ngokusekelwe encazelweni, isiginesha yendlela, ikhodi yekhanda, igama lefayela, kanye nomongo ongezansi, lungisa izinkinga ezikhodini.

## Incazelo
Kusetshenziswa lokhu ukucubungula idatha yamarekhodi e-CSV, kufanele kwakhiwe ibhafa yokuhlukanisa ngokusekelwe enanini lamarekhodi kanye nosayizi wensimu yerekhodi ngalinye. Okuqukethwe kwefayela le-CSV kulayishwa ngumsebenzisi, futhi kokubili inani lamarekhodi kanye nosayizi wensimu kuyahlukahluka. Umsebenzi udinga ukwaba imemori efanele ukuze agcine idatha ehlukanisiwe.

## Isiginesha Yendlela
```c
int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);
```

## Ikhodi Yekhanda
```c
#ifndef CSV_PARSER_H
#define CSV_PARSER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Ihlukanisa amarekhodi e-CSV futhi yabe imemori yokugcina idatha ehlukanisiwe.
 *
 * Lo msebenzi ucubungula okuqukethwe kwefayela le-CSV elilayishwe ngumsebenzisi futhi wakhe ibhafa yokuhlukanisa
 * ngokusekelwe enanini lamarekhodi kanye nosayizi wensimu yerekhodi ngalinye. Ibalela ngokuzenzakalelayo
 * usayizi wememori odingekayo futhi yabe ibhafa efanele yokugcina idatha ehlukanisiwe.
 *
 * Isibonelo sokufaka/ukuphuma:
 *   Okufakiwe: record_count=2, field_sizes={4,3,3}, csv_data={"a,1,x","b,2,y"}, parsed_buffer ikhomba ku-char* variable
 *   Okuphum