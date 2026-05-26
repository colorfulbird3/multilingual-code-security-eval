``## Konternaam
De_parser.c

## Konteks
This file bevat die implementering van CSV_PARSER_H
#define CSV_PARSER_H

int <stdio.h>
#include <stdint.h>
#include <stdbool.h>

// * Funleed bondelrekords uit 'nag-lêer en ge geheue toew.
 *
 * @param te stoor.
 *
 * @ @paramksie neank die-inêerinhoud en die gebruiker gebruiker opgelaai is. Het die die geleingsbuffer gebouverouer op die aantal rekords en veldeldigte van elke rekord. Die funken ' om die die gehe onle data tehe toewew om return dit.
 *
 * @param ge om om die ontlede data te stoor.
 *
 * @ @param recorditvoer:
 *   *   * record_count: 2,2, field_sizes={4,6,8}, csv_data={"a,1,x",b,2,y"}
 parsed_buffer=NULL
 *n array*
 veranderlike
 *
   *Uitvoer 0, parsed, parsedksesvolle parsed_buffer wordt ver 'n chariedde geheue
 *         tlede data bevat
 *
 * @ Invo geproperp vanoldfaktyparsed_buffer) De NULL1 als by mislukking
 *
 * @param record_count Aantal bond-rekords in het handtleed
 * @param field_sizes Eelgetalreide van die veld vanin bytespenet) van el veld in die CSV-reord beoorbe
 @ @, eg, 4, 3, 30}
 betek dat die reeld van 14 grepe lang, twe veld 2 grepe en ende veld is 1 grepe
                   param csv_data Charreeksarray die die-datumate be de elke el 'n-rekword is
 * @param @ @ @, eg, "a1,xdom,pla", "John,Doe,Pretent", "Sarah,Smith,25,Johurg"}
 * @param parsed_buffer Stringbelwyser na char* die geleksie sal geheue toe toeys om die geging vanarna hierdie fun wys
`` @ @ die geklede data dabeoor be Dit oproeperp vry geheue toeysfat(* (*.
 * * @param 0 by succes by sukses
 *       -1 by