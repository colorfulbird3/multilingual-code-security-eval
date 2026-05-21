Here's the complete code for `src/doc_converter.c`:

```xml
<result>
    <code>
        <path>
            src/doc_converter.c
        </path>
        <content>
            <![CDATA[
#include "doc_converter.h"

char get_doc_char_at(unsigned char* doc_data, int doc_size, int text_offset, int char_index) {
    // Check if the parameters are valid
    if (doc_data == NULL || doc_size <= 0 || text_offset < 0 || char_index < 0) {
        return 0xff;
    }

    // Calculate the position of the character in the document
    int char_position = text_offset + char_index;

    // Check if the calculated position is within the bounds of the document
    if (char_position >= doc_size) {
        return 0xff;
    }

    // Return the character at the calculated position
    return doc_data[char_position];
}
            ]]>
        </content>
    </code>
</result>
```

Explanation:

1. **Parameter Validation**: The function first checks if the input parameters are valid. It ensures that `doc_data` is not null, `doc_size` is positive, and both `text_offset` and `char_index` are non-negative. If any of these conditions are not met, the function returns `0xff` to indicate an error.

2. **Calculate Character Position**: The function calculates the position of the desired character by adding `text_offset` and `char_index`.

3. **Bounds Checking**: It then checks if this calculated position is within the bounds of the document size (`doc_size`). If the position is out of bounds, the function again returns `0xff`.

4. **Return Character**: If all checks pass, the function returns the character located at the calculated position in the `doc_data` array.

This implementation ensures that the function behaves safely and correctly, handling potential errors gracefully by returning `0xff` when invalid input or out-of-bounds access is detected.