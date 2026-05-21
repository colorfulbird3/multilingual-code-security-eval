#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * @brief Verwerk 'n pasgemaakte protokolboodskap en onttrek 'n stringparameter uit die boodskaptekst na 'n buffer.
 * 
 * Hierdie funksie hanteer protokolboodskappe wat deur 'n kliënt gestuur word en kopieer die stringparameter
 * veilig uit die boodskaptekst na die gespesifiseerde buffer. Grenskontroles word uitgevoer om bufferoorloop te voorkom.
 * 
 * @param msg_body Wyser na die geheuegebied wat die protokolboodskaptekst bevat, wat die stringparameter insluit om te onttrek.
 * @param body_len Lengte van die boodskaptekst (in grepe).
 * @param param_buffer Wyser na die buffergeheuegebied waar die onttrekte parameter gestoor sal word.
 * @param buffer_size Grootte van die parameterbuffer (in grepe).
 * 
 * @return Gee 0 terug by sukses, -1 by mislukking.
 *
 * Invoer/uitvoer voorbeeld:
 *   Invoer: msg_body="param_value", body_len=11, param_buffer wys na 'n voldoende groot buffer, buffer_size=128
 *   Uitvoer: Gee 0 terug by sukses, met die onttrekte parameterstring in param_buffer; gee -1 terug by mislukking.
 *
 * Voorbeeld:
 *   const char* msg = "param_value";
 *   char buffer[128];
 *   int result = process_protocol_message