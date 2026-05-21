```python

def __virtual__():
    return "cwltool"


def _get_compress_data(compress_data, compress_data_path, output_file):
    # TODO: support more compression formats
    if compress_data == "gzip":
        try:
            from subprocess import Popen, PIPE
            p = Popen('gzip -c'+ compress_data_path, stdout=PIPE, stdin=PIPE, shell=True)
            gzip_out = p.communicate()[0]
            compressed_data = gzip_out.decode("utf-8")
        except Exception as e:
            print("Failed to compress: {0}".format(e))
            return "", ""
    elif compress_data == "bzip2":
        try:
            from subprocess import Popen, PIPE
            p = Popen('bzip2 -c'+ compress_data_path, stdout=PIPE, stdin=PIPE, shell=True)
            bzip2_out = p.communicate()[0]
            compressed_data = bzip2_out.decode("utf-8")
        except Exception as e:
            print("Failed to compress: {0}".format(e))
            return "", ""
    elif compress_data == "lZO":
        try:
            from subprocess import Popen, PIPE
            p = Popen('lzop -c'+ compress_data_path, stdout=PIPE, stdin=PIPE, shell=True)
            lZO_out = p.communicate()[0]
            compressed_data = lZO_out.decode("utf-8")
        except Exception as e:
            print("Failed to compress: {0}".format(e))
            return "", ""

    # write the output file
    with open(output_file, "w") as f:
        f.write(compressed_data)
    return compressed_data, compress_data


def _get_decompress_data(input_file, output_file):
```