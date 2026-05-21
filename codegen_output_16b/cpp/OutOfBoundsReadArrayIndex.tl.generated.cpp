

## References
[1] http://en.wikipedia.org/wiki/Huffman_coding
[2] http://en.wikipedia.org/wiki/Run-length_encoding
[3] http://en.wikipedia.org/wiki/Huffman_coding#C_implementation

"""

## References
[1] http://en.wikipedia.org/wiki/Huffman_coding
[2] http://en.wikipedia.org/wiki/Run-length_encoding
[3] http://en.wikipedia.org/wiki/Huffman_coding#C_implementation

## Code for testing
#!/usr/bin/python

import sys
import csv
from pprint import pprint

filename1 = "data/input_data.txt"
filename2 = "data/output_data.txt"

# header
header = """
/**
 * Decompress data
 * 
 * Decompresses compressed data into the output buffer. The function accesses the compressed data
 * via array indexing according to the characteristics of the compression algorithm.
 *
 * Input/Output Example:
 *   Input: compressed_data points to compressed data, compressed_len=100, output_buffer points to buffer, output_size=256
 *   Output: On success, returns the length (in bytes) of decompressed data, with output_buffer containing the result; on failure, returns -1
 *
 * @param compressed_data Buffer containing compressed data to be decompressed
 * @param compressed_len Length (in bytes) of the compressed data
 * @param output_buffer Output buffer to store decompressed data
 * @param output_size Size (in bytes) of the output buffer
 * 
 * @return On success, returns the length (in bytes) of decompressed data; on failure, returns -1
 */
int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size);

"""

## read file
f = open(filename1, 'r')
lines = f.readlines()

## write header
f2 = open(filename2, 'w')
f2.write(header)

## go thru all lines
for line in