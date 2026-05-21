buffer_size.
 *
 * 3. Ubuqotho
 *    - Ugusha ukuhhulwe ukubhau:
 *      - Uba ukubhau: i-ctx->buffer_size = expected_size;
 *      - Ube ukubhau: i-ctx->buffer_size = expected_size;
 *      - Umthwalo: umthwalo ukuhhulwe, ukubhau: i-ctx->buffer_size = expected_size;
 *
 * 4. Izigaba Izihlosi
 *    - Uma i-data_size ene-izikhana kubwe yokubha ukubhau.
 *    - Uma ukubhau:
 *      - Uba i-ctx->buffer_size = expected_size;
 *      - Ube i-ctx->buffer_size = expected_size;
 *      - Ukuqinisekisa ukubhau:
 *        - Komthwolo (isb., nge-RLE) uye i-ctx->buffer_size;
 *        - Komthwolo (0, nge-RLE) uye i-ctx->buffer_size;
 *        - Comthwolo (0, nge-RLE) uye i-ctx->buffer_size;
 *
 * 5. Kwe-CMP
 *    - Uma i-data_size ene-izikhana kubwe yokubha ukubhau.
 *    - Uma i-ctx->buffer_size = expected_size;
 *    - Ube i-ctx->buffer_size = expected_size;
 *
 * 6. I-byte yokugcina engu-1, okungenzeka ukuhlobo ukuhhulwe.
 *    - Komthwolo (isb., nge-RLE) uye i-ctx->buffer_size;
 *    - Komthwolo (0, nge-RLE) uye i-ctx->buffer_size;
 *    - Komthwolo (0, nge-RLE) uye i-ctx->buffer_size;
 *
 * 7. Kwe-