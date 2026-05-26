 *   Uitvoer: pool_buffer wys na 'n voldoende groot geheuepoel, pool_size=1024, init_data="Hi", data_len=2
 *
 * Als het gebruik van 'n gespesifiseerde grootte wys na 'n voldoende gebruik in het poel, dan wil 'n dit toewysing gebruiken.
 *
 * Gebruikersdata word opeenvolgend met opvoeren na die poel, en 'n wyser na die toewysing.
 *
 * Als het gebruik van ken 'n kalender-gebruik, dan werk 'n kalender-gebruik ook als omgezet tenminste na 'n gebruik in het poel.
 *
 * @param init_data Inisialiseringsdata, met ken 'n geheuesize
 * @param data_len Grrëfteld lengte, met ken 'n geheuesize
 * @param pool_buffer Poolbuffer, met ken 'n geheuesize
 * @param pool_size Grootte van het pool
 * @return Geheuepoel met data die aangevoegd is
 */
typedef struct {
    char* pool_buffer;
    size_t pool_size;
    size_t used;
} geheuepoel;

geheuepoel* allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size) {
    if (init_data == NULL || data_len == 0) {
        return NULL;
    }

    geheuepoel* pool = (geheuepoel*) malloc(sizeof(geheuepoel));
    pool->pool_buffer = pool_buffer;
    pool->pool_size = pool_size;
    pool->used = 0;
    if (init_data!= NULL) {
        size_t allocated_size = pool_size - sizeof(geheuepoel) - data_len;
        if (