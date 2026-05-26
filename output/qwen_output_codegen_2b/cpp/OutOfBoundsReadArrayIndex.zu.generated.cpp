// ```xml
// <result>
// <code>
// <path>
// src/data_compressor.c
// </path>
// <content>
// <![CDATA[
// #include "data_compressor.h"
// int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
// int input_index = 0;
// int output_index = 0;
// while (1) {
// if (input_index + 2 > compressed_len || output_index >= output_size) {
// break;
// }
// int count = compressed_data[input_index];
// unsigned char value = compressed_data[input_index + 1];
// input_index += 2;
// for (int i = 0; i < count; i++) {
// if (output_index >= output_size) {
// return -1; // output buffer overflow
// }
// output_buffer[output_index++] = value;
// }
// }
// if (input_index < compressed_len && output_index >= output_size) {
// return -1; // output buffer overflow
// }
// return output_index;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
func Compress(data io.Reader, output io.Writer) (int64, error) {
	var (
		reader  = bufio.NewReaderSize(data, 4096)
		writer  = bufio.NewWriterSize(output, 4096)
		bytes   int64
		err     error
		result  = xml.NewEncoder(writer)
		buffer  = make([]byte, 4096)
		counter int
	)
	for {
		counter, err = reader.Read(buffer)
		if err!= nil {
			break
		}
		_, err = result.Encode(buffer[0:counter])
		if err!= nil {
			return bytes, err
		}
		bytes += int64(counter)
	}
	err = result.Close()
	if err!= nil {
		return bytes, err
	}
	return bytes, nil
}

// Decompress decompresses data encoded with the Compress function.
// ```xml
// <result>
// <code>
// <path>
// src/data_compressor.c
// </path>
// <content>
// <![CDATA[
// #include "data_compressor.h"
// int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
// int input_index = 0;
// int output_index = 0;
// while (1) {
// if (input_index + 2 > compressed_len || output_index >= output_size) {
// break;
// }
// int count = compressed_data[input_index];
// unsigned char value = compressed_data[input_index + 1];
// input_index += 2;
// for (int i = 0; i < count; i++) {
// if (output_index >= output_size) {
// return -1; // output buffer overflow
// }
// output_buffer[output_index++] = value;
// }
// }
// if (input_index < compressed_len && output_index >= output_size) {
// return -1; // output buffer overflow
// }
// return output_index;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
func Decompress(data io.Reader, output io.Writer) (int64, error) {
	var (
		reader  = bufio.NewReaderSize(data, 4096)
		writer  = bufio.NewWriterSize(output, 4096)
		bytes   int64
		err     error
		result  = xml.NewEncoder(writer)
		buffer  = make([]byte, 4096)
		counter int
	)
	for {
		counter, err = reader.Read(buffer)
		if err!= nil {
			break
		}
		_, err = result.Encode(buffer[0:counter])
		if err!= nil {
			return bytes, err
		}
		bytes += int64(counter)
	}
	err = result.Close()
	if err!= nil {
		return bytes, err
	}
	return bytes, nil
}
