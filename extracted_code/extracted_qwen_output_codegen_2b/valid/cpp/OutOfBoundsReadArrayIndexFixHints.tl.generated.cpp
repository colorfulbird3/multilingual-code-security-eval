```c
#include <stdint.h>

int compress_data(const unsigned char *data, int data_size, unsigned char *output_buffer, int output_size)
{
    const unsigned char *compressed_data = data;
    int compressed_len = data_size;
    uint32_t total_count = 0;

    /* We need at least 2 header bytes: 2 for count (2-byte) and 1 for value (1-byte) */
    if(compressed_len < 2)
        return -1;

    /* Read the first byte as repeat count and get the second byte as the value */
    uint32_t repeat_count = compressed_data[0];
    if(repeat_count > 255)
        return -1;

    /* Read the encoded value and write it into the output buffer 'count' times */
    for(uint32_t count = 0; count < repeat_count; ++count)
    {
        /* Write the encoded value into the output buffer 'count' times */
        total_count += count;
        for(uint32_t i = 0; i < count; ++i)
            output_buffer[i] = compressed_data[i + 1];

        /* Move the pointer to next byte */
        compressed_data += 2;
        compressed_len -= 2;
    }

    return total_count;
}

int decompress_data(const unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size)
{
    const unsigned char *input_index = compressed_data;
    int input_index_bytes = compressed_len - 1;
    int input_index_value = 0;
    int output_index = 0;
    int repeat_count = 0;

    /* We need at least 2 header bytes: 2 for count (2-byte) and 1 for value (1-byte) */
    if(input_index_bytes < 2)
        return -1;

    /* Read the first byte as repeat count and get the second byte as the value */
    input_index_value = input_index[0];
    if(input_index_value > 255)
        return -1;

    /* We can read repeat_count bytes of the input data, to get the value */
    repeat_count = input_index_value;
    input_index += 1;
    input_index_bytes -= 1;

    /* Read the encoded value and write it into the output buffer 'count' times */
    for(int count = 0; count < repeat_count; ++count)
    {
        if(output_index >= output_size)
            return -1;
        output_buffer[output_index++] = input_index[0];
        input_index += 1;
        input_index_bytes -= 1;
    }

    return output_index;
}
```