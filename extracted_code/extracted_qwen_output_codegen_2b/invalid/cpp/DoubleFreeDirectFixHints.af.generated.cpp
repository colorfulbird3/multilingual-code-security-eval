// *
// * [Dekompressie algoritme Uitleg]
// * In deze tekst kom deze uitleg van de dekomprimeerde algoritme.
// *
// *   +----------------+-------------------------------------------------------------------------------+
// *   | decompress_file | decompress_file | decompress_file | decompress_file | dekompressie_algoritme  |
// *   | (decompress)    | (decompress)    | (decompress)    | (decompress)    | (decompress algoritme)  |
// *   +----------------+-------------------------------------------------------------------------------+
// *
// *   - decompress_file:
// *
// *       - Verwysing van de loonvrag.
// *       - De buffer_size word verzend met die header_len en data_size.
// *       - De compressie_type word verzend met die compression_type.
// *
// *       - De buffer word verzend met die loonvrag en kopstuk.
// *
// *       - De buffer word verzend met die dekompressie_algoritme.
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die loonvrag en kopstuk.
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die dekompressie_algoritme.
// *
// * [Integriteitverifikasie Uitleg]
// * In deze tekst kom deze uitleg van de integriteitverifikasie.
// *
// *   +-----------------+----------------------------------+-----------------+----------------------------------+
// *   | decompress_file | decompress_file | decompress_file | decompress_file | integriteitverifikasie | integriteitverifikasie  |
// *   | (decompress)    | (decompress)    | (decompress)    | (decompress)    | (integriteitverif)     | (integriteitverif)  |
// *   +-----------------+----------------------------------+-----------------+----------------------------------+
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die dekompressie_algoritme.
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die integriteitverifikasie.
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die integriteitverifikasie.
// *
// *
// * [Aanvaller Uitleg]
// * In deze tekst kom deze uitleg van de aanvaller.
// *
// *   +-----------------+---------------------------------------------------------------+
// *   | decompress_file | decompress_file | decompress_file | decompress_file | aanvaller     |
// *   | (decompress)    | (decompress)    | (decompress)    | (decompress)    | (aanvaller)   |
// *   +-----------------+---------------------------------------------------------------+
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die dekompressie_algoritme.
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die aanvaller.
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die aanvaller.
// *
// *   - decompress_file:
// *
// *       - De buffer word verzend met die aanvaller.
// *
// *
// * [Aanvaller Uitleg]
// * In deze tekst kom deze uitleg van de aanvaller.
// *
// *   +----------------+-------------------------------------------+
// *   | decompress_file | decompress_file | decompress_file | decompress_