 CSV-lêergebruik, en dat de CSV-lêergebruik
// in die gebruiker opgelaai.
//
// ## lêernaam
// csv_parser.c
// ## kopkode
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include "csv_parser.h"
//
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);
// ```
// ## verwerkingsmetode
// *parse_csv_records kon de oudere funksie konstante, indien de gebruiker opgelaai, *parsed_buffer wys na 'n char* veranderlike en de
// * oproeper moet verwerk dit, dit veranderlik bevat *parsed_buffer en die oproepers het resultaat bevat.
// *
// * @param record_count Aantal CSV-rekords om te ontleed
// * @param field_sizes Heelgetalreeks wat die grootte (in grepe) van elke veld in 'n rekord stoor
// *                    bv., {10, 20, 15} beteken die eerste veld is 10 grepe, tweede is 20 grepe, derde is 15 grepe
// * @param csv_data Reeks van stringe wat rou CSV-data bevat; elke element verteenwoordig een CSV-rekord
// *                 bv., {"naam,ouderdom,stad", "Jan,30,Kaapstad", "Anna,25,Joburg"}
// * @param parsed_buffer Dubbele wyser na char; die funksie sal geheue toewys by die ligging waarna gewys word
// *                      deur hierdie parameter en die ontlede data daar stoor. Die oproeper moet hierdie geheue na gebruik
// *                      volgende: *parsed_buffer wys na toegewysing van de verwerking. *parsed_buffer gebruikst de
// *                      functies wyser als de gebruiker opgelaai.
// *
// * @return Gee 0 terug by suksesvolle ontleding
// *         Gee -1 terug by ontledingsmislukking (bv., geheuetoewysingsmislukking, ongeldige parameters)
// ```
// ## verwerkingsmetode
// *parse_csv_records kon de oudere funksie konstante, indien de gebruiker opgelaai, *parsed_buffer wys na 'n char* veranderlike en de
// * oproepers het resultaat bevat.
// *
// * @param record_count Aantal CSV-rekords om te ontleed
// * @param field_sizes Heelgetalreeks wat die grootte (in grepe) van elke veld in 'n rekord stoor
// *                    bv., {10, 20, 15} beteken die eerste veld is 10 grepe, tweede is 20 grepe, derde is 15 grepe
// * @param csv_data Reeks van stringe wat rou CSV-data bevat; elke element verteenwoordig een CSV-rekord
// *                 bv., {"naam,ouderdom,stad", "Jan,30,Kaapstad", "Anna,25,Joburg"}
// * @param parsed_buffer Dubbele wyser na char; die funksie sal geheue toewys by die ligging waarna gewys word
// *                      deur hierdie parameter en die ontlede data daar stoor. Die oproeper moet hierdie geheue na gebruik
// *                      volgende: *parsed_buffer wys na toegewysing van de verwerking. *parsed_buffer gebruikst de
// *                      functies wyser als de gebruiker opgelaai.
// *
// * @return Gee 0