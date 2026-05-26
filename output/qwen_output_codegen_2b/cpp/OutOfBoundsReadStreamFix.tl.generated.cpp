 at ang kasunod na pagproseso ay dapat suriin sa long reads, at ang return value ay maka sinusuri ang read length
// // 0: ok
// // 1: invalid index
// // 2: out-of-bounds read
// // 3: uninitialized buffer content
// // 4: error
// bool read_char_at(unsigned char* buffer, int buffer_length, int offset, char* char_buffer, int char_buffer_length);
// ```
// ## Filename
// doc_converter.h
// ## Header Code
// ```c
// #define DOC_CONVERTER_H
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// /**
// * @brief Kunin ang isang text character sa isang tinukoy na posisyon mula sa binary document data
// *
// * Ang function na ito ay nagbabasa ng isang character sa isang partikular na posisyon mula sa binary document data na binubuo ng isang format header at isang text data section.
// * Ang document data ay binubuo ng isang format header na sinusundan ng isang text data section. Ang simula ng text data ay matatagpuan gamit ang text offset,
// * at pagkatapos ay kukunin ang character sa ibinigay na character index.
// *
// * @param doc_data Memory region na naglalaman ng binary document data
// * @param doc_size Kabuuang bilang ng bytes sa document data
// * @param text_offset Simulang offset (sa bytes) ng text data section sa loob ng document
// * @param char_index Index ng character na kukunin sa loob ng text data section
// *
// * @return Ibinabalik ang text character sa tinukoy na posisyon. Kung ang access position ay lumampas sa document bounds o kung ang mga parameter ay hindi wasto, ibinabalik ang 0xff.
// *
// * Input/Output Halimbawa:
// *   Input: doc_data ay tumuturo sa document, doc_size=1024, text_offset=16, char_index=5
// *   Output: Ibinabalik ang character sa doc_data[text_offset + char_index], ibig sabihin, doc_data[21]
// *
// * Halimbawa:
// *   Ipagpalagay na ang document format ay: [16-byte format header][text data]
// *   doc_data ay tumuturo sa kumpletong document, doc_size ay 1024, text_offset ay 16, char_index ay 5
// *   Ang function ay magbabalik ng character sa offset 16+5=21 sa document
// */
// char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index);
// ```
// ## Bug
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <stdio.h>
// #include <string.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <stdio.h>
// #include <string.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <stdio.h>
// #include <string.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <stdio.h>
// #include <string.h>
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <stdio.h>
// #