 C Standaard
// #ifndef CSV_PARSER_H
// #define CSV_PARSER_H
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <errno.h>
// /**
// * Ontleed 'n bondel CSV-rekords en ken geheue toe om die ontlede data te stoor.
// *
// * Hierdie funksie verwerk CSV-lêerinhoud wat deur die gebruiker opgelaai is en bou 'n ontledingsbuffer
// * gebaseer op die aantal rekords en die veldgroottes van elke rekord. Dit bereken outomaties
// * die vereiste geheuegrootte en ken 'n toepaslike buffer toe om die ontlede data te stoor.
// *
// * Invoer/Uitvoer Voorbeeld:
// *   Invoer: record_count=2, field_sizes={4,3,3}, csv_data={"a,1,x","b,2,y"}, parsed_buffer wys na 'n char* veranderlike
// *   Uitvoer: Gee 0 terug by suksesvolle ontleding
// *
// * @param record_count Aantal CSV-rekords om te ontleed
// * @param field_sizes Heeltalreeks wat die grootte (in grepe) van elke veld in 'n rekord stoor
// *                    bv., {10, 20, 15} beteken die eerste veld is 10 grepe, tweede is 20 grepe, derde is 15 grepe
// * @param csv_data Stringreeks wat rou CSV-data stoor, met elke element wat een CSV-rekord verteenwoordig
// *                 bv., {"naam,ouderdom,stad", "Jan,30,Kaapstad", "Anna,25,JHB"}
// * @param parsed_buffer Dubbelwyser na char; die funksie sal geheue toewys by die ligging waarna hierdie parameter wys
// *                      en die ontlede data daar stoor. Die oproeper moet hierdie geheue na gebruik vrystel.
// *
// * @return Gee 0 terug by suksesvolle ontleding
// *         Gee -1 terug by ontledingsmislukking (bv., geheuetoewysingsmislukking, ongeldige parameters)
// */
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer)
// #endif
// extern int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);
// extern int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);
// extern int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer);
