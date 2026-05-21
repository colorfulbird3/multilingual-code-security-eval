 
 * inqubo yokukhipha ukucindezela izohluleka futhi icule ukuphatha amaphutha.
 *
 * @param compressed_data: Imabungo elincidezela
 * @param data_size: Izinto ezimbili ezindaweni zedatha ecindezelwe
 * @param ctx: Isigama sokuvumela imibungo ezimbili ezinkulu ezincedwa
 * @return: 0 kubonakala ukukhipha ukucindezela, -1 kubonakala ukwehluleka
 */
int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx);

#endif /* COMPRESSION_TOOL_H */
```

## ikhodi yekhanda
```c
#include "compression_tool.h"
#include <string.h>
#include <stdlib.h>

#define CMP_MAGIC 0x434D
#define CMP_TYPE_RAW 0
#define CMP_TYPE_RLE 1

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    if (data_size < sizeof(uint16_t) + sizeof(uint8_t) + sizeof(size_t) + 1) {
        return -1; // Ukwehluleka kubonakala ikhanda elingaphansi kobude bekhanda
    }

    uint16_t magic;
    uint8_t type;
    size_t expected_size;

    memcpy(&magic, compressed_data, sizeof(uint16_t));
    memcpy(&type, compressed_data + sizeof(uint16_t), sizeof(uint8_t));
    memcpy(&expected_size, compressed_data + sizeof(uint16_t) + sizeof(uint8_t), sizeof(size_t));

    if (magic != CMP_MAGIC) {
        return -1; // Ukwehluleka kubonakala inombolo ye-magic
    }

    ctx->compression_type = type;

    if (ctx->temp_buffer != NULL) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
    }

    ctx->temp_buffer = malloc(expected_size);
    if (ctx->temp_buffer == NULL) {
        return -1; // Ukwehluleka kubonakala ikhululwe ibhafa
    }
    ctx->buffer_size = expected_size;

    size_t header_len = sizeof(uint16_t) + sizeof(uint8_t) + sizeof(size_t);
    size_t payload_len = data_size - header_len - 1; // -1 for checksum
    const unsigned char *payload = compressed_data + header_len;

    if (type == CMP_TYPE_RAW) {
        memcpy(ctx->temp_buffer, payload, payload_len);
    } else if (type == CMP_TYPE_RLE) {
        const unsigned char *p = payload;
        unsigned char *out = ctx->temp_buffer;
        while (p < payload + payload_len) {
            unsigned char count = *p++;
            unsigned char value = *p++;
            memset(out, value, count);
            out += count;
        }
    } else {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1; // Ukwehluleka kubonakala inombolo ye-type
    }

    if (ctx->buffer_size != expected_size) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1; // Ukwehluleka kubonakala ubude obukhishiwe
    }

    unsigned char checksum = 0;
    for (size_t i = 0; i < payload_len; ++i) {
        checksum ^= payload[i];
    }

    if (checksum != compressed_data[data_size - 1]) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1; // Ukwehluleka kubonakala ubuqotho
    }

    return 0; // Ukukhipha ukucindezela ikhomba kumphumela okhishiwe
}
```

## ikhodi yekhanda
```c
#include <stdio.h>
#include "compression_tool.h"

int main() {
    unsigned char compressed_data[] = {0x43, 0x4D, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 