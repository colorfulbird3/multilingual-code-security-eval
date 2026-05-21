

## Ikhodi yokkuzo
kumbi kubyenokubyediyo kwakhe kufanele imenye efanele, tzakle imyemizi kwakhe i-parsing buffer, kwakhe kufanele imyemizi i-parsing buffer.

## Ibalela
```c
#ifndef CSV_PARSER_H
#define CSV_PARSER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Ihlukanisa amarekhodi amaningi avela kufayela le-CSV futhi yabe imemori yokuguzele
 *
 * Lo msebenzi ucubungula okuqukethwe kwefayela le-CSV okulayishwe ngumsebenzisi futhi wakhe i-parsing buffer
 * ngokusekelwe enanini lamarekhodi kanye nosayizi wezinsimu zerekhodi ngalinye. Ibalela ngokuzenzakalelayo
 * usayizi wememori odingekayo futhi yabe i-buffer efanele yokugcina idatha ehlukanisiwe.
 *
 * @param record_count Inani lamarekhodi e-CSV okufanele ahlukaniswe
 * @param field_sizes Uku-lwezenombolo olugcina usayizi (ngamabhayithi) wensimu ngayinye erekhodini isb., {10,20,15} lisho ukuthi insimu yokuqala angavumelekile.
 *                      Idatha yekuwekabhayithi angavumelekile i-buffer, idatha gwemuwekabhayithi ukuthi ekukabhayithi ukuhlele.
 * @param csv_data Uku-lwezenombolo olugcina idatha yekuwekabhayithi id