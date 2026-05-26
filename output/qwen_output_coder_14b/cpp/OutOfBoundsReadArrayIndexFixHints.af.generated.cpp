The provided code snippet is from a function named `decompress_data` in the file `src/data_compressor.c`. This function is intended to decompress data using the Run-Length Encoding (RLE) algorithm. However, it contains a critical security vulnerability known as an out-of-bounds read (CWE-125).

### Vulnerability Analysis

#### Function Overview
- **Purpose**: Decompress data encoded using the RLE algorithm.
- **Parameters**:
  - `unsigned char *compressed_data`: Pointer to the compressed data.
  - `int compressed_len`: Length of the compressed data.
  - `unsigned char *output_buffer`: Buffer to store the decompressed data.
  - `int output_size`: Size of the output buffer.

#### Vulnerability Location
The vulnerability lies in the loop where the function reads two bytes from the `compressed_data` array:
```c
while (input_index < compressed_len) {
    unsigned char count = compressed_data[input_index];
    unsigned char value = compressed_data[input_index + 1];
    input_index += 2;
```

#### Issue
- **Condition**: The loop checks if `input_index` is less than `compressed_len` before accessing `compressed_data[input_index + 1]`.
- **Problem**: If `compressed_len` is odd, the last iteration of the loop will attempt to access `compressed_data[input_index + 1]`, which is out of bounds since `input_index` will be equal to `compressed_len` at that point.

#### Example
Consider the following example:
- `compressed_data` = `[3, 'a', 2, 'b']`
- `compressed_len` = 4

In the last iteration:
- `input_index` = 2
- `count` = `compressed_data[2]` = 2
- `value` = `compressed_data[3]` = 'b'

However, after this iteration, `input_index` becomes 4, which is equal to `compressed_len`. The next iteration will try to access `compressed_data[4]`, which is out of bounds.

### Fix
To fix this vulnerability, you should ensure that the loop does not attempt to read beyond the end of the `compressed_data` array. One way to do this is by checking if `input_index + 1` is still within the bounds of `compressed_len` before accessing `compressed_data[input_index + 1]`.

Here is the corrected version of the function:

```c
int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    if (compressed_data == NULL || output_buffer == NULL || compressed_len <= 0 || output_size <= 0) {
        return -1;
    }

    int input_index = 0;
    int output_index = 0;

    while (input_index < compressed_len) {
        unsigned char count = compressed_data[input_index];
        input_index++;

        // Check if there is enough data left for the value
        if (input_index >= compressed_len) {
            return -1; // Error: Not enough data for the value
        }

        unsigned char value = compressed_data[input_index];
        input_index++;

        for (int i = 0; i < (int)count; i++) {
            if (output_index < output_size) {
                output_buffer[output_index++] = value;
            } else {
                if (input_index < compressed_len) {
                    return -1;
                }
                break;
            }
        }
    }

    return output_index;
}
```

### Summary
- **Original Issue**: Out-of-bounds read when `compressed_len` is odd.
- **Fix**: Ensure that `input_index + 1` is within bounds before accessing `compressed_data[input_index + 1]`.
- **Impact**: Potential crash or undefined behavior due to accessing invalid memory.

This fix ensures that the function handles the end of the `compressed_data` array correctly, preventing any out-of-bounds memory accesses.