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
        // Check if there is enough data for a unit (2 bytes)
        if (input_index + 2 > compressed_len) {
            break;
        }

        // Check if output buffer is full
        if (output_index >= output_size) {
            // If there is still compressed data left, it's an overflow
            if (input_index < compressed_len) {
                return -1; // Output buffer overflow
            }
            break;
        }

        // Read count and value from compressed data
        int count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];
        input_index += 2;

        // Validate count (must be 1..255, 0 is reserved)
        if (count == 0) {
            return -1; // Invalid compressed data
        }

        // Write value count times to output buffer
        for (int i = 0; i < count; i++) {
            if (output_index >= output_size) {
                return -1; // Output buffer overflow
            }
            output_buffer[output_index] = value;
            output_index++;
        }
    }

    return output_index; // Return decompressed data length
}
]]>
        </content>
    </code>
</result>
```
 */

package datacompressor

import (
	"encoding/xml"

	"github.com/getcfs/megacfs/formic"
)

// DecompressData compresses data and returns the compressed data in
// a byte array.
func DecompressData(input []byte) ([]byte, error) {
	var err error
	var out []byte

	c := &formic.Compressor{}
	if out, err = c.Decompress(input); err!= nil {
		return nil, err
	}

	return out, nil
}

// IsCompressed returns true if the data is compressed.
func IsCompressed(data []byte) bool {
	// Check if the data is compressed
	var n int
	var err error
	if n, err = formic.IsCompressed(data); err!= nil {
		return false
	}

	return n > 0
}

type DataCompressor struct {
	XMLName xml.Name `xml:"data-compressor"`

	XMLRoot struct {
		Code struct {
			Path        string      `xml:"path,attr"`
			Content     string      `xml:"content"`
			Attribute   []Attribute `xml:"attribute"`
			ContentType string      `xml:"content-type,attr"`
		} `xml:"code"`
	} `xml:"root"`
}

type Attribute struct {
	XMLName xml.Name `xml:"attribute"`

	Name  string `xml:"name,attr"`
	Value string `xml:"value,attr"`
}
