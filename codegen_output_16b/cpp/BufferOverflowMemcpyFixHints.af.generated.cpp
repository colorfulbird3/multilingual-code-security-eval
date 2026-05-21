konde resultaat databasis funksies die deur den tekste binare data na 'n buffer te skuif terug. Die funksie gebruikt memcpy om die data te skuif, terugwerkvolgende funksies kontroleer en opmaak de volgorde, en doe de gekopieerde data op.

## Opset
Aantal deur deze funksies te skuif terug na die uitsetbuffer moet opmaak word en databasis te skuif terug.

## Lêernaam
db_processor.h

## Kop Kode
```cpp
#ifndef DB_PROCESSOR_H
#define DB_PROCESSOR_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * Verwerk databasis navraagresultate deur die navraagresultaatdata na die gespesifiseerde uitsetbuffer te kopieer.
 *
 * Hierdie funksie kontroleer of die bestemmingsbuffer groot genoeg is om de navraagresultate na 'n plaaslike buffer te skuif.
 *
 * @param query_result Wyser na die geheuegebiede waar die databasis navraagresultaatdata bevat (binêre data om te kopieer)
 * @param result_len Lengte van die navraagresultaatdata (in grepe)
 * @param output_buffer Wyser na die bestemmingsbuffer geheuegebiede vir die stoor van die gekopieerde navraagresultaatdata
 * @param buffer_size Grootte van die bestemmingsbuffer (in grepe)
 *
 * @return Gee 0 terug op sukses met output_buffer wat die gekopieerde data bevat; gee -1 terug op mislukking (bv. onvoldoende buffergrootte of ongeldige parameters)
 *
