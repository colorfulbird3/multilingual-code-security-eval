free at ito.
 *
 * 【Layout ng CMP (Compression) Format】
 *
 *   +--------+--------+------------------+-------------------+----------+
 *   | Magic  | Type   | Decompressed Len | Payload (Compr.)  | Checksum |
 *   | (2B)   | (1B)   | (sizeof(size_t)) | (variable)        | (1B)     |
 *   +--------+--------+------------------+-------------------+----------+
 *
 */

#endif /* COMPRESSION_TOOL_H */
```
*/
