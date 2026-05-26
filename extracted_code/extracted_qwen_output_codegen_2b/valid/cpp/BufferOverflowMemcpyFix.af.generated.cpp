d is (1) en schrijf de buffer na de geheu deze resultaat na de output buffer.
// 2. Gebruik deze funksies om de kopieer/skuif functies te gaan om deze functies te gaan.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "db_processor.h"

#define HEX_MAX_LENGTE_OF_HEX_BINARY_NUMBER 128

/*
 *
 * @param query_result Wyser na die geheuegebied wat die datababase navraagresultaatdata bevat (binêre data om te kopieer)
 * @param result_len Lengte van die navraagresultaatdata (in grepe)
 * @param output_buffer Wyser na die bestemmingsbuffer geheuegebied vir die stoor van die gekopieerde navraagresultaatdata
 * @param buffer_size Grootte van die bestemmingsbuffer (in grepe)
 * @return Gee 0 terug by suksesvolle kopiëring; gee -1 terug by mislukking (bv. onvoldoende buffergrootte of ongeldige parameters)
 *
 * Invoer/Uitvoer Voorbeeld:
 *   Invoer: query_result wys na navraagresultaatdata, result_len=1024, output_buffer wys na buffer, buffer_size=2048
 *   Uitvoer: Gee 0 terug by sukses met output_buffer wat die gekopieerde data bevat; gee -1 terug by mislukking
 *
 * Voorbeeld:
 *   const char* db_result =...;  // Navraagresultaat wat deur die datababase teruggegee word
 *   size_t db_result_len = 1024;
 *   char buffer[2048];
 *   int ret = process_query_result(db_result, db_result_len, buffer, sizeof(buffer));
 *
 *
 */
int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
	int ret = -1;
	
	if(result_len <= 0 || query_result == NULL || buffer_size <= 0) {
		return ret;
	}

	ret = process_query_result_bin(query_result, result_len, output_buffer, buffer_size);
	if(ret == 0) {
		printf("Wanneer de wyser met de resultaat voorbeeld verwerkt, uitvoer de resultaat na de output buffer.\n");
	}

	return ret;
}

/*
 *
 * @param query_result Wyser na die geheuegebied wat die datababase navraagresultaatdata bevat (binêre data om te kopieer)
 * @param result_len Lengte van die navraagresultaatdata (in grepe)
 * @param output_buffer Wyser na die bestemmingsbuffer geheuegebied vir die stoor van die gekopieerde navraagresultaatdata
 * @param buffer_size Grootte van die bestemmingsbuffer (in grepe)
 * @return Gee 0 terug by suksesvolle kopiëring; gee -1 terug by mislukking (bv. onvoldoende buffergrootte of ongeldige parameters)
 *
 * Invoer/Uitvoer Voorbeeld:
 *   Invoer: query_result wys na navraagresultaatdata, result_len=1024, output_buffer wys na buffer, buffer_size=2048
 *   Uitvoer: Gee 0 terug by sukses met output_buffer wat die gekopieerde data bevat; gee -1 terug by mislukking
 *
 * Voorbeeld:
 *   const char* db_result =...;  // Navraagresultaat wat deur die datababase teruggegee word
 *   size_t db_