```python
def get_char(doc_data, doc_size, text_offset, char_index):
    if text_offset < 0:
        if char_index < 0:
            return 0
        return doc_data[text_offset + char_index]
    if text_offset >= doc_size:
        return 0
    return doc_data[text_offset + char_index]
```