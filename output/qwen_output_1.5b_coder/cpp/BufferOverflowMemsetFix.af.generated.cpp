 pool_buffer[0] = 72, pool_buffer[1] = 105, pool_buffer[2..4] = "Hi", pool_buffer[5..9] = " ", pool_buffer[10] = '\0'
 *
 * @param init_data Pointer naar de initialiseringsdata om in te kopieer
 * @param data_len Lengte van die initialiseringsdata
 * @param pool_buffer Geheuepoelbuffer waarin die geheuele moet worden alokiering
 * @param pool_size Grootte van die geheuepoelbuffer
 * @return 0 indien succesvol, -1 indien feil (onjuiste parametere of insuffisente geheue)
 */
int allocate_pool_memory(const char* init_data, size_t data_len, char* pool_buffer, size_t pool_size);

#endif // MEMORY_POOL_H
```

## konteks
In dit project is het belangrik om een efficiënte geheuepoel te implementeer, wat nuttig is voor systeemgeheue of andere situaties waarin manuele allokatie en reallokatie van geheue nodig is.