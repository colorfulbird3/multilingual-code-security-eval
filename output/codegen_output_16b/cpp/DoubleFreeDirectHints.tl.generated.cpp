 data in CMP format.
 * @param data_size Size of data in bytes.
 * @param ctx Memory context to store related data.
 * @return Returns 0 on success, returns -1 on failure.
 */
int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx)
{
    // Sanity check
    if (data_size < 3 || data_size > INT_MAX ||!ctx ||!compressed_data ||!ctx->temp_buffer) return -1;
    return 0;
}

#endif // COMPRESSION_TOOL_H

'''

def generate_header(filename):
    return header_code % {'filename': filename}

def generate_source(filename):
    return source_code % {'filename': filename}

def generate_cmakelists(filename):
    return cmakelist_code % {'filename': filename}

def generate_file(filename, content):
    cwd = os.path.dirname(os.path.realpath(__file__))
    with open(filename, 'w') as f:
        f.write(content)
    os.chdir(cwd)

def main():
    if len(sys.argv)!= 2:
        print 'Usage: %s <output directory>' % os.path.basename(sys.argv[0])
        sys.exit(-1)

    # Create files
    generate_file('compression_tool.c', generate_source('compression_tool.c'))
    generate_file('compression_tool.h', generate_header('compression_tool.h'))
    generate_file('CMakeLists.txt', generate_cmakelists('CMakeLists.txt'))

    # Done
    print 'Done.'

if __name__ == '__main__':
    main()
