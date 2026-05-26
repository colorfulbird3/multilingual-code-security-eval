 a simple RLE format.
 * 
 * @param compressed_data Compressed data buffer containing data to decompress
 * @param compressed_len Length of compressed data (in bytes)
 * @param output_buffer Output buffer to store decompressed data
 * @param output_size Size of output buffer (in bytes)
 * 
 * @return On success, returns decompressed data length (bytes); on failure, returns -1
 */
int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    if (compressed_len == 0 || output_size == 0) {
        return -1;
    }

    int input_index = 0;
    int output_index = 0;

    while (input_index < compressed_len && output_index < output_size) {
        int count = compressed_data[input_index];
        if (count == 0) {
            // Skip null count
            input_index++;
            continue;
        }
        int value = compressed_data[input_index + 1];

        if (output_index + count > output_size) {
            return -1;
        }

        for (int i = 0; i < count; i++) {
            output_buffer[output_index++] = value;
        }

        input_index += 2;
    }

    return output_index;
}
            ]]>
        </content>
    </code>
</result>
```

```python
# Python version of the decompress_data function
def decompress_data(compressed_data, compressed_len, output_buffer, output_size):
    if not compressed_data or not output_buffer or not output_size:
        return -1

    input_index = 0
    output_index = 0

    while input_index < compressed_len and output_index < output_size:
        count = compressed_data[input_index]
        if count == 0:
            # Skip null count
            input_index += 1
            continue
        value = compressed_data[input_index + 1]

        if output_index + count > output_size:
            return -1

        for _ in range(count):
            output_buffer[output_index] = value
            output_index += 1

        input_index += 2

    return output_index
```



