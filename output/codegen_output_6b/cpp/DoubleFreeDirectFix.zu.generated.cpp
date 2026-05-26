ela i-ctx->buffer_size.
 *    - Uma i-header_len < ubude be-header nyazu i-ctx->buffer_size, noma idatha ekipathwa, i-ctx->buffer_size = header_len;
 *    - Uma i-data_size < ubude be-payload, noma idatha i-ctx->buffer_size = data_size;
 *    - Uma i-checksum < ubude be-checksum, noma idatha i-ctx->buffer_size = checksum_len;
 *    - Uma i-ctx->buffer_size < ukwuqinisekiswa, noma idatha i-ctx->buffer_size = ctx->buffer_size;
 *
 * 3. Ukuhlelwa Kwe-CMP
 *    - Uma i-ctx->compression_type: Uma i-ctx->compression_type + 1 lokukhipha, kuqala i-ctx->compression_type.
 *    - Uma i-ctx->buffer_size < ukwuqinisekiswa, noma idatha i-ctx->buffer_size = ctx->buffer_size;
 *    - Uma i-ctx->temp_buffer < ukwuqinisekiswa, noma idatha i-ctx->temp_buffer = ctx->temp_buffer;
 *
 * 4. Ukhomlosekulwe Kwe-CMP
 *    - Uma i-ctx->buffer_size < ukwuqinisekiswa, noma idatha i-ctx->buffer_size = ctx->buffer_size;
 *    - Una i-checksum < ubude be-checksum, noma i-ctx->buffer_size = checksum_len;
 *    - Uma i-ctx->temp_buffer < ukwuqinisekiswa, noma idatha i-ctx->temp_buffer = ctx->temp_buffer;
 *
 * 5. Ukhomlosekulwe Kwe-CMP
 *    - Uma i-ctx->buffer_size < ukwuqinisekiswa, noma idatha i-ctx->buffer_