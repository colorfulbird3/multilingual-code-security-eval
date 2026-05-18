The provided code snippet is a C function that attempts to decompress data using the Run-Length Encoding (RLE) algorithm. However, it contains a critical security vulnerability known as an out-of-bounds read (CWE-125). Let's analyze the code and identify the issue:

### Code Analysis

1. **Function Signature**:
   ```c
   int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size)
   ```
   - `compressed_data`: Pointer to the compressed data.
   - `compressed_len`: Length of the compressed data.
   - `output_buffer`: Buffer where the decompressed data will be stored.
   - `output_size`: Size of the output buffer.

2. **Input Validation**:
   ```c
   if (compressed_data == NULL || output_buffer == NULL || compressed_len <= 0 || output_size <= 0) {
       return -1;
   }
   ```
   This check ensures that the input pointers and lengths are valid.

3. **Decompression Loop**:
   ```c
   while (input_index < compressed_len) {
       unsigned char count = compressed_data[input_index];
       unsigned char value = compressed_data[input_index + 1];
       input_index += 2;

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
   ```
   - The loop iterates over the compressed data.
   - For each iteration, it reads a `count` and a `value`.
   - It then writes the `value` `count` times to the output buffer.

### Vulnerability Identification

The vulnerability lies in the loop condition and the way the `count` and `value` are read:

1. **Loop Condition**:
   ```c
   while (input_index < compressed_len)
   ```
   This condition only checks if `input_index` is less than `compressed_len`.

2. **Reading `count` and `value`**:
   ```c
   unsigned char count = compressed_data[input_index];
   unsigned char value = compressed_data[input_index + 1];
   input_index += 2;
   ```
   Inside the loop, `count` and `value` are read from `