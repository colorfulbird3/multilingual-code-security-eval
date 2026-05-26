```xml
<result>
    <code>
        <path>
            src/data_compressor.c
        </path>
        <content>
            <![CDATA[
#include "data_compressor.h"

int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    int input_index = 0;
    int output_index = 0;

    while (input_index + 2 <= compressed_len && output_index < output_size) {
        unsigned char count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];

        if (count == 0) {
            // Reserved value, should not occur in valid data
            return -1;
        }

        input_index += 2;

        for (unsigned char i = 0; i < count && output_index < output_size; i++) {
            output_buffer[output_index++] = value;
        }
    }

    // Check if we stopped due to insufficient output size
    if (input_index < compressed_len) {
        return -1; // Output buffer overflow
    }

    return output_index; // Return the length of decompressed data
}
]]>
        </content>
    </code>
</result>
```