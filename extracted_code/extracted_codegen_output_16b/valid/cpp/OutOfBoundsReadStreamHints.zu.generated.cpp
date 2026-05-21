```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

// Document format header structure
typedef struct {
    uint32_t magic;          // Magic number for format identification
    uint32_t version;        // Format version
    uint32_t text_offset;    // Offset to text data section
    uint32_t text_length;    // Length of text data
} DocumentHeader;

// Function to extract text from document data
char* extract_text_from_document(const unsigned char* document_data, size_t data_size) {
    if (document_data == NULL || data_size < sizeof(DocumentHeader)) {
        return NULL;
    }

    // Parse the document header
    DocumentHeader* header = (DocumentHeader*)document_data;
    
    // Validate magic number (example: 0x444F4355 = "DOCU")
    if (header->magic != 0x444F4355) {
        return NULL;
    }

    // Check if text offset and length are within bounds
    if (header->text_offset + header->text_length > data_size) {
        return NULL;
    }

    // Allocate memory for the extracted text
    char* extracted_text = (char*)malloc(header->text_length + 1);
    if (extracted_text == NULL) {
        return NULL;
    }

    // Copy text data from the document
    memcpy(extracted_text, document_data + header->text_offset, header->text_length);
    extracted_text[header->text_length] = '\0';  // Null-terminate the string

    return extracted_text;
}

// Example usage
int main() {
    // Example document data (simplified)
    unsigned char document_data[] = {
        0x44, 0x4F, 0x43, 0x55,  // Magic: "DOCU"
        0x01, 0x00, 0x00, 0x00,  // Version: 1
        0x10, 0x00, 0x00, 0x00,  // Text offset: 16 bytes
        0x0E, 0x00, 0x00, 0x00,  // Text length: 14 bytes
        // Text data starts at offset 16
        'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!', '\n'
    };

    size_t data_size = sizeof(document_data);
    char* text = extract_text_from_document(document_data, data_size);
    
    if (text != NULL) {
        printf("Extracted text: %s", text);
        free(text);
    } else {
        printf("Failed to extract text from document.\n");
    }

    return 0;
}
```