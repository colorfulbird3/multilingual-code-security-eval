```python
def construct_analysis_buffer(num_records, field_size):
    if num_records <= 0 or field_size <= 0:
        return None
    try:
        buffer = bytearray(num_records * field_size)
        return buffer
    except MemoryError:
        return None
```