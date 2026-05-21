The provided XML snippet contains the source code for a function `decompress_data` which is part of a data compressor utility. This function takes compressed data as input and attempts to decompress it into an output buffer.

Here's a breakdown of how the function works:

1. **Parameters**:
   - `unsigned char *compressed_data`: A pointer to the compressed data.
   - `int compressed_len`: The length of the compressed data.
   - `unsigned char *output_buffer`: A pointer to the buffer where the decompressed data will be stored.
   - `int output_size`: The size of the output buffer.

2. **Function Logic**:
   - The function initializes two indices: `input_index` for reading from the compressed data and `output_index` for writing to the output buffer.
   - It enters a loop that continues until either the end of the compressed data is reached or the output buffer is full.
   - Inside the loop:
     - It checks if there are at least two bytes remaining in the compressed data. If not, it breaks out of the loop.
     - It checks if the output buffer has enough space to accommodate more data. If not, it checks if there's still data left in the compressed data. If so, it returns `-1` indicating an overflow.
     - It reads the next two bytes from the compressed data: the first byte represents the count of repeated characters, and the second byte represents the character itself.
     - It validates the count to ensure it's between 1 and 255 (0 is reserved).
     - It writes the character `count` times into the output buffer, checking for buffer overflow each time.
   - Once the loop exits, the function returns the length of the decompressed data.

3. **Return Values**:
   - On successful decompression, it returns the length of the decompressed data.
   - If there's an overflow or invalid data, it returns `-1`.

This function is designed to handle simple run-length encoded data decompression. It assumes that the compressed data follows a specific format where each pair of bytes represents a count and a value.