0, maaaring isang raw/decompressed data; para sa type 1, maaaring isang Run-Length Encoding (RLE) data.
 *    - Kung hindi tugma, ibalik ang failure.
 *    - Para sa type 0:
 *       - Kung ang data_size ay mas mababa sa haba ng payload (decompressed length), ibalik ang failure.
 *       - Kung hindi tugma, maglaan o muling gamitin ang isang buffer para sa decompressed na resulta: itakda ang ctx->temp_buffer sa isang buffer na kayang humawak ng data_size,
 *         at itakda ang ctx->buffer_size = data_size. Kung nabigo ang alokasyon, ibalik ang failure.
 *       - Dapat makita ang decompressed data sa ctx->temp_buffer at its length.
 *    - Para sa type 1:
 *       - Kung ang data_size ay mas mababa sa haba ng payload (decompressed length), ibalik ang failure.
 *       - Kung hindi tugma, maglaan o muling gamitin ang isang buffer para sa decompressed na resulta: itakda ang ctx->temp_buffer sa isang buffer na kayang humawak ng data_size,
 *         at itakda ang ctx->buffer_size = data_size. Kung nabigo ang alokasyon, ibalik ang failure.
 *       - Dapat makita ang decompressed data sa ctx->temp_buffer at its length.
 *
 * 3. Integrity Verification
 *    - Basahin ang checksum sa ctx->temp_buffer at the last 1 byte of ctx->payload.
 *    - Kung hindi tugma, ibalik ang failure.
 *    - Kung tama, magkakalikasan ng success.
 */

#endif // COMPRESSION_TOOL_H
```

## Context
Ang `struct compression_context` ay:

```c
struct compression_context {
    unsigned char *temp_buffer;
    size_t buffer_size;
    int compression_type;
};
```

Kung ang naka-compress na file ay sira, ang proseso ng decompression ay maglabigay ng sirang naka-compress na file, kung ang maraming yugto ng decompression algorithm ay lahat sumusubok na i-free ang parehong pansamantalang buffer, magkakaroon ng double-free.