incwadi zokuqinisekisa.
 *
 * @param compressed_data: Idata ecindezelwe ibe yi-temporary buffer.
 * @param data_size: Isize esisebenta isizindawo esisebenzise.
 * @param ctx: Icontext elithi isetshenziswa ngokukhipha ukucindezela.
 * @return: U-0 ukwenzekile ngokuphatha kwezinsiza kanye namaphutha, u--1 ukwenzekile noma yisiphi isigaba.
 */
int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx);

#endif // COMPRESSION_TOOL_H
```

## i-context
```c
struct compression_context {
    unsigned char *temp_buffer;
    size_t buffer_size;
    int compression_type;
};
```

## i-implementation
```c
#include "compression_tool.h"
#include <stdlib.h>
#include <string.h>

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    // 1. Ukuhlaziya i-header
    if (data_size < sizeof(uint16_t) + sizeof(uint8_t) + sizeof(size_t)) {
        return -1; // Idata_size uyadlula ubude be-header
    }

    uint16_t magic = *(uint16_t *)compressed_data;
    if (magic != 0x434D) {
        return -1; // Iheader uyahlolweni
    }

    uint8_t type = *(compressed_data + sizeof(uint16_t));
    size_t expected_size = *(size_t *)(compressed_data + sizeof(uint16_t) + sizeof(uint8_t));

    if (ctx->temp_buffer == NULL || ctx->buffer_size < expected_size) {
        free(ctx->temp_buffer); // Ukhulule ukwaba
        ctx->temp_buffer = (unsigned char *)malloc(expected_size);
        if (ctx->temp_buffer == NULL) {
            return -1; // Ukugcina ukwaba
        }
        ctx->buffer_size = expected_size;
    }

    // 2. Ukukhipha ukucindezela kwedatha
    size_t payload_size = data_size - sizeof(uint16_t) - sizeof(uint8_t) - sizeof(size_t);
    if (payload_size > ctx->buffer_size) {
        free(ctx->temp_buffer); // Ukhulule ukwaba
        ctx->temp_buffer = NULL;
        return -1; // Ubude be-payload uyadlula i-ctx->buffer_size
    }

    memcpy(ctx->temp_buffer, compressed_data + sizeof(uint16_t) + sizeof(uint8_t) + sizeof(size_t), payload_size);

    // 3. Ukuqinisekisa ubuqotho
    uint8_t checksum = *(compressed_data + data_size - sizeof(uint8_t));
    uint8_t calculated_checksum = 0;
    for (size_t i = 0; i < payload_size; ++i) {
        calculated_checksum += ctx->temp_buffer[i];
    }

    if (checksum != calculated_checksum) {
        free(ctx->temp_buffer); // Ukhulule ukwaba
        ctx->temp_buffer = NULL;
        return -1; // Ibuqotho uyahlolweni
    }

    // 4. Ukuphathwa kwezinsiza kanye namaphutha
    return 0;
}
```

## i-issues
```c
// Izingxenye ezimbili ezintathu:
// 1. Ikubonelo okungaphantsi ukuba i-ctx->temp_buffer yakhulule futhi isethwe ibe NULL ukuze kugwenywe i-double-free kamuva.
// 2. Ukuqinisekisa ukuthi i-ctx->temp_buffer ikhululwa kanye kuphela ezindleleni zamaphutha ukuze kugwenywe i-double-free.
```

## i-solutions
```c
// Izingxenye ezimbili ezintathu:
// 1. Kunika i-ctx->temp_buffer yakhulule, isethwe ibe NULL ukuze kugwenywe i-double-free kamuva.
// 2. Ukuqinisekisa ukuthi i-ctx->temp_buffer ikhululwa kanye kuphela ezindleleni zamaphutha ukuze kugwenywe i-double-free.
```

## i-verification
```c
#include "compression_tool.h"
#include <stdio.h>

void test_decompress_file() {
    unsigned char compressed_data[] = {0x43, 0x4D, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F, 0x20, 0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, 0x2A, 0x2B, 0x2C, 0x2D, 0x2E, 0x2F, 0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x3A, 0x3B, 0x3C, 0x3D, 0x3E, 0x3F, 0x40, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4A, 0x4B, 0x4C, 0x4D, 0x4E, 0x4F, 0x50, 0x51, 0x52, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58, 0x59, 0x5A, 0x5B, 0x5C, 0x5D, 0x5E, 0x5F, 0x60, 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A, 0x7B, 0x7C, 0x7D, 0x7E, 0x7F, 0x80, 0x81, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87, 0x88, 0x89, 0x8A, 0x8B, 0x8C, 0x8D, 0x8E, 0x8F, 0x90, 0x91, 0x92, 0x93, 0x94, 0x95, 0x96, 0x97, 0x98, 0x99, 0x9A,