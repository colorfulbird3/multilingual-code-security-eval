8, output_buffer=lewer 8-greep "AAABBBBB", output_size=8
 *   Uitset: output_buffer wys ["AAABBBBB"]
 */
void decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size);

#endif /* DATA_COMPRESSOR_H */
```

## konteks
Hierdie module is gebaseer op die kompressie-algoritme "RLE" (Run-Length Encoding), maar veranderd om die data te decompressie. De module gee de lengte van die gedekomprimeerde data terug.

Maak die probleme in die kode reg.



