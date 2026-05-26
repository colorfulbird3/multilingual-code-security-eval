 *    - Laag die hoof lengte van ctx->buffer_size heb ik die hoof-data op te slaan.
// *    - Laag de loonvrag na ctx->buffer_size heb ik de loonvrag data op te slaan.
// *    - As data_size minder is as die hoof lengte, verwijder die hoof-data (magies) en verwijder die loonvrag-data (loonvrag).
// *    - Verifieer die magiese nommer; as dit nie ooreenstem nie, keer terug met mislukking.
// *    - Laag die tipe in ctx->compression_type en lees die verwagte data_size (kontrolesom) as expected_size.
// *    - As toewysing misluk, keer terug met mislukking.
// *
// * 3. Loonvrag Ontkompressie
// *    - As data_size minder is as die loonvrag lengte, verwijderen die tipe en data_size.
// *    - Verifieer die magiese nommer; as dit nie ooreenstem nie, keer terug met mislukking.
// *    - Laag die hoof lengte in ctx->buffer_size heb ik die hoof-data op te slaan.
// *    - Laag de loonvrag na ctx->buffer_size heb ik die loonvrag data op te slaan.
// *    - As data_size minder is as die loonvrag lengte, verwijderen die tipe en data_size.
// *    - As toewysing misluk, keer terug met mislukking.
// *
// *   +-----------------------------------+----------+
// *   | Verwijder die magies en tipe     | Loonvrag |
// *   +-----------------------------------+----------+
// *
// *   - Magies: Verhouding van hoof- en loonvrag-lengte (in byte-per-byte).
// *   - Hoof-lengte: Size of hoof-data.
// *   - Loonvrag-lengte: Size of loonvrag-data.
// *
// *   - Magies: Verhouding en/of een
// *   - Hoof-lengte: bekend
// *   - Loonvrag-lengte: bekend
// *
// *   - Magies: een hetigheid aan geval
// *   - Hoof-lengte: een hetigheid aan geval
// *   - Loonvrag-lengte: een hetigheid aan geval
// *
// *   - Magies: een gevorderde lengte
// *   - Hoof-lengte: een gevorderde lengte
// *   - Loonvrag-lengte: een gevorderde lengte
// *
// *   - Magies: een 'n-een' lengte
// *   - Hoof-lengte: een 'n-een' lengte
// *   - Loonvrag-lengte: een 'n-een' lengte
// *
// *   - Magies: een 'n-een' lengte
// *   - Hoof-lengte: een 'n-een' lengte
// *   - Loonvrag-lengte: een 'n-een' lengte
// *
// *   - Magies: een 'n-een' lengte
// *   - Hoof-lengte: een 'n-een' lengte
// *   - Loonvrag-lengte: een 'n-een' lengte
// *
// *   - Magien: een 'n-een' lengte
// *   - Hoof-lengte: een 'n-een' lengte
// *   - Loonvrag-lengte: een 'n-een' lengte
// *
// *   - Magiens: een 'n-een'