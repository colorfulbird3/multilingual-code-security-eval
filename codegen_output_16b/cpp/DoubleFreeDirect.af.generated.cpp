 en de temp_buffer deur dat op ontkompresse is, en nie de eerste tellings van die loonvrag na de temp_buffer.
 *
 * *********************
 *
 *
 * *********************
 *
 *
 * ========== Beskrywing van Hoof Ontleding ==========
 *
 *   - Laat hoof op hoof en loonvrag word aan de stroom gestoor.
 *   - Zie hoof_verify_magic_number_for_header_in_input_file.
 *   - Verifieer die magiese nommer van hoof.
 *   - Verifieer die tipe op hoof.
 *   - Verifieer die ontkompresseerde lengte op hoof.
 *   - Verifieer de tipe op loonvrag.
 *   - Verifieer dat hoof en loonvrag in de stroom genoem word.
 *   - Verifieer dat de tipe en lengte op hoof gelijk is aan de ontkompresseerde lengte.
 *   - Laat loonvrag op hoof en hoof op loonvrag.
 *   - De hoof en loonvrag word aan de stroom gestoor.
 *   - Verifieer dat hoof en loonvrag gelijk is aan de lengte op loonvrag.
 *   - Verifieer dat de hoof en loonvrag gelijk is aan de lengte op hoof.
 *   - Laat hoof en loonvrag op loonvrag en hoof op loonvrag.
 *   - Laat hoof en loonvrag op hoof en loonvrag.
 *   - Verifieer dat loonvrag en hoof geldig zijn, en dat loonvrag en hoof gelijk zijn aan de ontkompresseerde lengte.
 *   - Verifieer dat loonvrag en hoof gelijk zijn aan de ontkompresseerde lengte.
 *   - Laat hoof op loonvrag en loonvrag op hoof