by.
 *    - As ctx->buffer_size in hierdie stadium toegewys is, moet dit vrygestel word en op NULL gestel word om dubbel-vrystelling later te vermy.
 *
 *   +----------------------------+-----------------------------------------+----------------+
 *   | Datos a Decompressie         | Gedekomprimeerde Lengte                 | Loonvrag + Kontrole |
 *   | (data_size)                   | (sizeof(size_t))                      | (sizeof(size_t)) |
 *   |                               |                                        | (sizeof(size_t)) |
 *   |                             \ | /                                      | (sizeof(size_t)) / |
 *   |                             : | :                                     | (sizeof(size_t)) : |
 *   |                             \ | /                                      | (sizeof(size_t)) / |
 *   |                               |                                        | (sizeof(size_t)) |
 *   |                               |                                        | (sizeof(size_t)) |
 *   |                               |                                        | (sizeof(size_t)) |
 *   |                             \ | /                                      | (sizeof(size_t)) / |
 *   |                             : | :                                     | (sizeof(size_t)) : |
 *   |                             \ | /                                      | (sizeof(size_t)) / |
 *   |                               |                                        | (sizeof(size_t)) |
 *   |                             \ | /                                      | (sizeof(size_t)) / |
 *   |                             : | :                                     | (sizeof(size_t)) : |
 *   |                             \ | /                                      | (sizeof(size_t)) / |
 *   |                               |                                        | (sizeof(size_t)) |
 *   |                             \ | /                                      | (sizeof(size_t)) / |
 *   |                             : | :                                     | (sizeof(size_t)) : |
 *   |                             \ | /                                      | (sizeof(size_t