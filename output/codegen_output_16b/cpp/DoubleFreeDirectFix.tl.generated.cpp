 failure
 */

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx)
{
    //...
}

#endif /* COMPRESSION_TOOL_H */

'''

if __name__ == '__main__':
    ffi = cffi.FFI()
    ffi.cdef(header_code)
    compressed_file = os.path.join(os.path.dirname(__file__), '..', '..', 'compression_tool.c')
    with open(compressed_file, 'r') as f:
        compressed_data = f.read()

    src = ffi.verify(header_code, compressed_data)
    print(src)