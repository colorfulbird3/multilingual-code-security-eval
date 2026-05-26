## context
- `temp_buffer`: Buffer where the decompressed data will be stored.
- `buffer_size`: Size of the `temp_buffer`.
- `compression_type`: Type of compression algorithm used in the file.

## ayusin
Ang mga isyu na naroroon sa code:

1. **Magic Number Validation**: The function should validate the magic number in the header to ensure that the file is indeed a CMP file. If the magic number is incorrect, the function should return an error code.
2. **Buffer Allocation**: When allocating the `temp_buffer`, the function should check if there is enough space in the available memory before proceeding. If not, the function should return an error code.
3. **Data Length Validation**: Before decompressing the payload, the function should verify that the payload length matches the expected decompressed length. If not, the function should return an error code.
4. **Checksum Calculation**: The function should calculate the checksum of the decompressed data using the appropriate algorithm specified in the CMP format. If the checksum calculation fails, the function should return an error code.
5. **Resource Cleanup**: After decompression, the function should free the `temp_buffer` if it was allocated within this stage. This ensures that no memory leaks occur.

### Pregunta:
Magiging pagbabago ng header_code ay ang code ayon sa paglalarawan. Isang isyu na naroroon sa code ay maaaring magsalita ng pangalan ng isyu. Anumang isyu ay maipakita ng isyu?