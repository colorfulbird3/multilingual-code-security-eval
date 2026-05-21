```xml
<result>
    <code>
        <path>
            src/data_compressor.c
        </path>
        <content>
            <![CDATA[
#include "data_compressor.h"

int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    int input_index = 0;
    int output_index = 0;

    while (1) {
        // Check if we have enough bytes for a unit
        if (input_index + 2 > compressed_len) {
            break;
        }

        // Check if output buffer is full
        if (output_index >= output_size) {
            break;
        }

        // Read count and value
        int count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];
        input_index += 2;

        // Write value count times
        for (int i = 0; i < count; i++) {
            if (output_index >= output_size) {
                // Output buffer overflow - failure
                return -1;
            }
            output_buffer[output_index++] = value;
        }
    }

    // If we stopped because of insufficient output buffer while there's still input data
    if (input_index < compressed_len && output_index >= output_size) {
        return -1;
    }

    return output_index;
}
]]>
        </content>
    </code>
</result>
```

 */
public class DecompressDataExample extends AbstractExample {
    public void run() {
        compress_data();
        decompress_data();
    }

    /**
     * Compresses data
     */
    private void compress_data() {
        try {
            // Create a compressed byte buffer
            byte[] compressed_data = new byte[1024];

            // Create compressor
            Compressor compressor = new LZ4Compressor();

            // Fill the byte buffer with random data
            for (int i = 0; i < compressed_data.length; i++) {
                compressed_data[i] = (byte) (Math.random() * 128);
            }

            // Compress data
            byte[] compressed = compressor.compress(compressed_data);

            // Write compressed data to console
            System.out.println(Utils.toHex(compressed));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Decompresses data
     */
    private void decompress_data() {
        try {
            // Create decompressed byte buffer
            byte[] decompressed_data = new byte[1024];

            // Create decompressor
            Decompressor decompressor = new LZ4Decompressor();

            // Fill decompressed byte buffer with random data
            for (int i = 0; i < decompressed_data.length; i++) {
                decompressed_data[i] = (byte) (Math.random() * 128);
            }

            // Decompress data
            byte[] decompressed = decompressor.decompress(decompressed_data);

            // Write decompressed data to console
            System.out.println(Utils.toHex(decompressed));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
