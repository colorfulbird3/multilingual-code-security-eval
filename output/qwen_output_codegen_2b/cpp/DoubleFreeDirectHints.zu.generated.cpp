buffer(ctx);
// return -1;
// }
// /* Stage 4: Decompression */
// size_t decompressed_size = ctx->buffer_size - header_len;
// dec_ctx.out = (unsigned char *)malloc(decompressed_size);
// int result = compress2(dec_ctx.out, &decompressed_size,
// ctx->temp_buffer + header_len, ctx->buffer_size - header_len,
// Z_BEST_COMPRESSION);
// if (result!= Z_OK) {
// free(dec_ctx.out);
// return -1;
// }
// free(ctx->temp_buffer);
// ctx->temp_buffer = NULL;
// }
// /** @} */
