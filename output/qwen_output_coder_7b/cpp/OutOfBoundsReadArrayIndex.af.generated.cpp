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

    while (1) {
        // Check if we have enough bytes for a unit
        if (input_index + 2 > compressed_len) {
            break;
        }

        // Check if output buffer is full
        if (output_index >= output_size) {
            break;
        }

        // Read count and value
        int count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];
        input_index += 2;

        // Write value count times
        for (int i = 0; i < count; i++) {
            if (output_index >= output_size) {
                // Output buffer overflow - failure
                return -1;
            }
            output_buffer[output_index++] = value;
        }
    }

    // If we stopped because of insufficient output buffer while there's still input data
    if (input_index < compressed_len && output_index >= output_size) {
        return -1;
    }

    return output_index;
}
]]>
        </content>
    </code>
</result>
```