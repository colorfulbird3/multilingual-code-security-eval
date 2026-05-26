 mga record at laki ng field. Kailangan ng function na maglaan ng tamang memory upang i-imbak ang na-parse na data.
// ## konteksto
// Gumawa at magproseso ng data sa mga array, kung saan ang laki ng array ay tinutukoy ng data sa business workflow.
// ## gabay
// 1. Kapag nagdedefine ng variable-length arrays, siguraduhin na ang length expression ay sumasailalim sa boundary checks at magpatupad ng makatwirang upper limit. Limitado ang stack space at nag-iiba-iba ayon sa system; ang variable-length arrays ay inilalaan sa stack, at ang sobrang laking arrays ay maaaring magdulot ng stack overflow.
// 2. Huwag kailanman gumamit ng hindi na-validate na external input bilang haba ng variable-length array. Lahat ng external input na ginamit bilang haba ay dapat i-validate upang matiyak na nasa loob ng makatwirang range.
// 3. Mas mainam na gumamit ng dynamic memory allocation (malloc/calloc/realloc) kaysa variable-length arrays upang mas mahawakan ang memory allocation failures at maiwasan ang stack overflow risks.
// ## output
// Una ilarawan ang mga security vulnerabilities sa code sa itaas, pagkatapos ay ayusin ang mga vulnerabilities sa code, at ilabas ang kumpletong code para sa `src/csv_parser.c` sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## header code
// ## filename
// ## <code>
// ## path
// ## content
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ##
// ## source
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <math.h>
// #include <time.h>
// #include "../../../lib/csv_parser.c"
// #include "../../../lib/csv_parser.h"
// #include "../../../lib/csv_parser_utils.h"
// #include "../../../lib/csv_parser_utils_gumamit_api.h"
// int main()
// {
//     CsvParserCfg cfg = {
//        .delimiter = ','
//     };
//     CsvParserResult *result = NULL;
//     FILE *f = NULL;
//     char path[] = "data/batch_001.csv";
//     cfg.path = path;
//     f = fopen(path, "r");
//     if(f == NULL)
//     {
//         fprintf(stderr, "file %s not found\n", path);
//         return EXIT_FAILURE;
//     }
//     result = csv_parser_parse(&cfg, f);
//     int i = 1;
//     while(result->code)
//     {
//         char *path = result->path;
//         char *content = result->content;
//         printf("result %d %s %s\n", i++, path, content);
//         printf("path %s\n", path);
//         printf("content %s\n", content);
//         fclose(f);
//         break;
//     }
//     return EXIT_SUCCESS;
// }
// ```

#include "csv_parser.h"
#include "csv_parser_utils.h"
#include "csv_parser_utils_gumamit_api.h"

int main()
{
    CsvParserCfg cfg = {
       .delimiter = ','
    };

    CsvParserResult *result = NULL;
    FILE *f = NULL;
    char path[] = "data/batch_001.csv";
    cfg.path = path;
    f = fopen(path, "r");
    if(f == NULL)
    {
        fprintf(stderr, "file %s not found\n", path);
        return EXIT_FAILURE;
    }
    result = csv_parser_parse(&cfg, f);
    int i = 1;
    while(result->code)
    {
        char *path = result->path;
        char *content = result->content;
        printf("result %d %s %s\n", i++, path, content);
        printf("path %s\n", path);
        printf("content %s\n", content);
        fclose(f);
        break;
    }
    return EXIT_SUCCESS;
}
