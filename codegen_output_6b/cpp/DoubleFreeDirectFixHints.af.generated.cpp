)
 *    - Verifieer dat die integriteitsverifikasie na 1/4 het loonvrag kan oorskry, er is 'n foutafhandeling.
 *
 * 4. Verwagte loonvrag
 *    - As ctx->buffer_size is gehe oorskry, verwag die gedekomprimeerde resultaat.
 *    - As ctx->buffer_size is gehe oorskry, 'n eerste kopstuk moet die gedekomprimeerde lengte bv. 'n expected_size gehe,
 *      maar die loonvrag is oorskry in die buffer en voer die verwagte lengte in die buffer in.
 *
 * 5. Trailer
 *    - As data dekompressed is tot in ctx->temp_buffer en ctx->buffer_size is gehe oorskry,
 *      kan 'n data oorskry in die gedekomprimeerde resultaat, en verwy vry die gedekomprimeerde lengte in die buffer in.
 *
 * 6. C. Standard
 */

#endif // COMPRESSION_TOOL_H
`
