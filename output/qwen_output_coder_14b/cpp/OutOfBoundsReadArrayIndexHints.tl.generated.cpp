Sure! Below is the implementation of the `decompress_data` function based on the provided description, method signature, header code, filename, and context. The function decompresses data using Run-Length Encoding (RLE).

```c
#include "data_compressor.h"

int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    int input_index = 0;
    int output_index = 0;

    while (input_index + 2 <= compressed_len && output_index < output_size) {
        unsigned char count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];

        if (count == 0) {
            // Reserved value, treat as error
            return -1;
        }

        for (unsigned char i = 0; i < count; i++) {
            if (output_index >= output_size) {
                // Output buffer overflow
                return -1;
            }
            output_buffer[output_index++] = value;
        }

        input_index += 2;
    }

    // If we stopped due to insufficient output_size while input_index < compressed_len, treat as output buffer overflow
    if (input_index < compressed_len) {
        return -1;
    }

    return output_index;
}
```

### Explanation:

1. **Initialization**:
   - `input_index` is initialized to 0 to track the current position in the compressed data.
   - `output_index` is initialized to 0 to track the current position in the output buffer.

2. **Loop through the compressed data**:
   - The loop continues as long as there are at least two bytes left in the compressed data (`input_index + 2 <= compressed_len`) and there is space in the output buffer (`output_index < output_size`).

3. **Read the count and value**:
   - `count` is read from the first byte of the current encoding unit.
   - `value` is read from the second byte of the current encoding unit.

4. **Check for reserved value**:
   - If `count` is 0, it is treated as an error because 0 is reserved and unused.

5. **Write the value repeatedly**:
   - A loop writes `value` into the output buffer `count` times, checking that `output_index` does not exceed `output_size` before each write.

6. **Update indices**:
   - `input_index` is incremented by 2 to move to the next encoding unit.
   - `output_index` is incremented within the inner loop to write the decompressed data into the output buffer.

7. **Check for buffer overflow**:
   - If the loop terminates because `input_index` is less than `compressed_len`, it indicates that the output buffer was too small to hold all the decompressed data, so the function returns -1.

8. **Return the length of decompressed data**:
   - If the decompression is successful, the function returns `output_index`, which is the length of the decompressed data.

This implementation ensures that the decompression process is efficient and safe, handling potential errors such as reserved values and buffer overflows.