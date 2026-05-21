 ```json
{
  "result": {
    "code": {
      "path": "src/data_compressor.c",
      "content": "#include \"data_compressor.h\"\n\nint decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {\n    int input_index = 0;\n    int output_index = 0;\n\n    while (1) {\n        if (input_index + 2 > compressed_len || output_index >= output_size) {\n            break;\n        }\n\n        int count = compressed_data[input_index];\n        unsigned char value = compressed_data[input_index + 1];\n        input_index += 2;\n\n        for (int i = 0; i < count; i++) {\n            if (output_index >= output_size) {\n                return -1; // output buffer overflow\n            }\n            output_buffer[output_index++] = value;\n        }\n    }\n\n    if (input_index < compressed_len && output_index >= output_size) {\n        return -1; // output buffer overflow\n    }\n\n    return output_index;\n}"
    }
  }
}
```