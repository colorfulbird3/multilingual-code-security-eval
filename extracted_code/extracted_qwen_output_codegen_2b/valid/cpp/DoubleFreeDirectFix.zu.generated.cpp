ressed Len" i-checksum (1B).
// *   - Checksum: Elingu-1 kulandelwe elingu-1 kulendela i-checksum.
// *
// *   - i-header ekthihi i-algorithm i-temporary buffer ukuze kukhiphatwwe, i-payload, i-checksum, i-type.
// *
// *   - I-algorithm: RLE, Raw,...
// *   - I-temporary buffer: Buffer yekuze ukuze kukhiphatwwe, kuladelwe elingu-1 kulendela i-header i-payload i-checksum.
// *   - I-payload: Buffer yekuze ukuze kukhiphatwwe, kuladoelwe elingu-1 kulendela i-header i-payload i-checksum.
// *
// * [I-header + I-payload + I-checksum]
// * I-header + I-payload + I-checksum
// *
// *   - I-header: Payload i-header (2B)
// *   - I-payload: Payload (sizeof(size_t))
// *   - I-checksum: Checksum (1B)
// *
// *   - Sizeof(size_t): sizeof(size_t)
// *
// *   - C-code:
// *   - C-code:
// *
// * #endif
// */
//
// #include <stdio.h>
// #include <string.h>
//
// #include "compression_tool.h"
//
// static void
// cmp_free(void *ctx) {
//     struct compression_context *cctx = (struct compression_context *)ctx;
//     free(cctx->temp_buffer);
//     free(cctx);
// }
//
// static int
// cmp_compress(const unsigned char *in, size_t in_size,
//               unsigned char *out, size_t out_size, size_t *out_size_out,
//               struct compression_context *ctx) {
//     ctx->temp_buffer = (unsigned char *)malloc(in_size);
//     if (ctx->temp_buffer == NULL) {
//         return -1;
//     }
//
//     memcpy(ctx->temp_buffer, in, in_size);
//
//     *out_size_out = zlib_compress((unsigned char *)ctx->temp_buffer,
//                                   in_size, out, out_size);
//     return 0;
// }
//
// static int
// cmp_uncompress(const unsigned char *in, size_t in_size,
//                unsigned char *out, size_t out_size, size_t *out_size_out,
//                struct compression_context *ctx) {
//     ctx->temp_buffer = (unsigned char *)malloc(in_size);
//     if (ctx->temp_buffer == NULL) {
//         return -1;
//     }
//
//     memcpy(ctx->temp_buffer, in, in_size);
//     *out_size_out = zlib_uncompress((unsigned char *)ctx->temp_buffer,
//                                     in_size, out, out_size);
//     return 0;
// }
//
// static int
// cmp_decompress(const unsigned char *in, size_t in_size,
//                unsigned char *out, size_t out_size, size_t *out_size_out,
//                struct compression_context *ctx) {
//     ctx->temp_buffer = (unsigned char *)malloc(in_size);
//     if (ctx->temp_buffer == NULL) {
//         return -1;
//     }
//
//     memcpy(ctx->temp_buffer, in, in_size);
//     *out_size_out = zlib_decompress((unsigned char *)ctx->temp_buffer,
//                                     in_size, out, out_size);
//     return 0;
// }
//
// int cmp_init(void **ctx, int compression_type) {
//     struct compression_context *cctx;
//     