ang, nagbabalik ng ng-kapabung
//    han dapat kembalikan ang-alituntinng.
// 2. I-free ng memorya sa malam-array.
//
// ## Lohas
// ### Dapat i-free ng memorya
// @param[in] field_sizes Integer array na nag-iimbak ng laki (sa bytes) ng bawat field sa isang record
//     hal., {10, 20, 15} ay nangangahulugang ang unang field ay 10 bytes, pangalawa ay 20 bytes, pangatlo ay 15 bytes
// @param[in] csv_data String array na nag-iimbak ng raw CSV data, bawat elemento ay kumakatawan sa isang CSV record
//     hal., {"name,age,city", "John,30,NYC", "Alice,25,LA"}
// @param[out] parsed_buffer Double pointer sa char; ang function ay maglalaan ng memorya sa lokasyon na tinuturo ng parameter na ito
//     at iimbak ang na-parse na data doon. Dapat i-free ng tumatawag ang memorya na ito pagkatapos gamitin.
//
// ### I-free ng memorya
// @param[in] parsed_buffer Double pointer sa char; ang function ay maglalaan ng memorya sa lokasyon na tinuturo ng parameter na ito
//     at iimbak ang na-parse na data doon.
//
// ### Lohas
// #### I-free ng memorya
// @param[in] parsed_buffer Double pointer sa char; ang function ay maglalaan ng memorya sa lokasyon na tinuturo ng parameter na ito
//     at iimbak ang na-parse na data doon.
// ### Lohas
// ### Mga Alituntunin
// 1. Kapag nagdedefine ng variable-length arrays, tiyakin na ang length expression ay sumasailalang, nagbabalik ng ng-kapabung
//    han dapat kembalikan ang-alituntinng.
// 2. I-free ng memorya sa malam-array.
//
// ## C Standard
// C99
// ## Filename
// csv_parser.c
// ## Header Code
// ```c
// #ifndef CSV_PARSER_H
// #define CSV_PARSER_H
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// /**
// * Nag-parse ng batch ng CSV records at naglalaan ng memorya upang iimbak ang na-parse na data.
// *
// * Ang function na ito aykop na memorya sa ibaba, ay usin ang function ng mangakop (memset) at ibamosin ng
// * alituntin ng parameter sa char.
// *
// * Halimbawa ng Input/Output:
// *   Input: record_count=2, field_sizes={4,3,3}, csv_data={"a,1,x","b,2,y"}
// *   Output: Nagbabalik ng 0 sa tagumpay; *parsed_buffer ay tumuturo sa inilaang memorya na naglalaman ng na-parse na resulta,
// *           na dapat i-free ng tumatawag (*parsed_buffer). Nagbabalik ng -1 sa pagkabigo.
// *
// * @param[in] record_count Bilang ng CSV records na ipo-parse
// * @param[in] field_sizes Integer array na nag-iimbak ng laki (sa bytes) ng bawat field sa isang record
// *                    hal., {10, 20, 15} ay nangangahulugang ang unang field ay 10 bytes, pangalawa ay 20 bytes, pangatlo ay 15 bytes
// * @param[in] csv_data String array na nag-iimbak ng raw CSV data, bawat elemento ay kumakatawan sa isang CSV record
// *                 hal., {"name,age,city", "John,30,NYC", "Alice,25,LA"}
// *
// * @return Nagbabal