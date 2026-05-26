werkingsprobleem.
 *      - By data is ongeldig, keer terug 0; as ctx->temp_buffer deur hierdie module toegewys is, moet dit vrygestel word en op NULL gestel word.
 *    - By sukses, keer terug 1; er is een ander probleem in de kode, of data is ongeldig, keer terug 0.
 *
 * ========== Algoritme ==========
 *
 * - Magic
 *   - Als data_size < kopstuk lengte, keer terug met mislukking.
 *   - Valideer magic nommer; as dit nie ooreenstem nie, keer terug met mislukking.
 *
 * - Tipe
 *   - As data_size < kopstuk lengte, keer terug met mislukking.
 *   - As data_size >= kopstuk lengte, lys ctx->compression_type.
 *   - As ctx->compression_type == 0: kopstuk is ROU, loonvrag is CMP.
 *   - As ctx->compression_type == 1: kopstuk is RLE, loonvrag is CMP.
 *
 * - Gedekomprimeerde Lengte
 *   - As data_size < kopstuk lengte, keer terug met mislukking.
 *   - As data_size >= kopstuk lengte, kopieer loonvrag na ctx->temp_buffer,
 *     verwerkingsprobleem.
 *
 * - Loonvrag
 *   - As data_size < kopstuk lengte, keer terug met mislukking.
 *   - Als data_size >= kopstuk lengte, geef de kopstuk toewys,
 *     verwerkingsprobleem.
 *   - Loonvrag is eerst geteleverwerkt, dat is die verwerkingsprobleem.
 *
 * - Kontrolesom
 *   - Als data_size < kop