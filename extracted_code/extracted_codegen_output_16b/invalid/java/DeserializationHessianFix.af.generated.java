```python
import struct
import io

class Hessian2Encoder:
    def __init__(self):
        self.buf = io.BytesIO()
    
    def encode(self, obj):
        if obj is None:
            self.buf.write(b'N')
        elif isinstance(obj, bool):
            self.buf.write(b'T' if obj else b'F')
        elif isinstance(obj, int):
            if -16 <= obj <= 47:
                self.buf.write(bytes([obj + 0x90]))
            elif -2048 <= obj <= 2047:
                self.buf.write(struct.pack('>Bh', 0xc8, obj))
            else:
                self.buf.write(struct.pack('>Bi', 0xc9, obj))
        elif isinstance(obj, float):
            self.buf.write(struct.pack('>Bd', 0xcb, obj))
        elif isinstance(obj, str):
            data = obj.encode('utf-8')
            length = len(data)
            if length < 32:
                self.buf.write(bytes([0x00 + length]))
            elif length < 1024:
                self.buf.write(struct.pack('>BH', 0x30, length))
            else:
                self.buf.write(struct.pack('>BI', 0x31, length))
            self.buf.write(data)
        elif isinstance(obj, bytes):
            length = len(obj)
            if length < 32:
                self.buf.write(bytes([0x20 + length]))
            elif length < 1024:
                self.buf.write(struct.pack('>BH', 0x34, length))
            else:
                self.buf.write(struct.pack('>BI', 0x35, length))
            self.buf.write(obj)
        elif isinstance(obj, list):
            self.buf.write(b'V')
            for item in obj:
                self.encode(item)
            self.buf.write(b'Z')
        elif isinstance(obj, dict):
            self.buf.write(b'M')
            for key, value in obj.items():
                self.encode(key)
                self.encode(value)
            self.buf.write(b'Z')
        else:
            raise TypeError(f"Unsupported type: {type(obj)}")
        return self.buf.getvalue()

class Hessian2Decoder:
    def __init__(self, data):
        self.data = data
        self.pos = 0
    
    def decode(self):
        tag = self.data[self.pos]
        self.pos += 1
        
        if tag == ord('N'):
            return None
        elif tag == ord('T'):
            return True
        elif tag == ord('F'):
            return False
        elif 0x80 <= tag <= 0xbf:
            return tag - 0x90
        elif tag == 0xc8:
            value = struct.unpack_from('>h', self.data, self.pos)[0]
            self.pos += 2
            return value
        elif tag == 0xc9:
            value = struct.unpack_from('>i', self.data, self.pos)[0]
            self.pos += 4
            return value
        elif tag == 0xcb:
            value = struct.unpack_from('>d', self.data, self.pos)[0]
            self.pos += 8
            return value
        elif 0x00 <= tag <= 0x1f:
            length = tag
            value = self.data[self.pos:self.pos+length].decode('utf-8')
            self.pos += length
            return value
        elif tag == 0x30:
            length = struct.unpack_from('>H', self.data, self.pos)[0]
            self.pos += 2
            value = self.data[self.pos:self.pos+length].decode('utf-8')
            self.pos += length
            return value
        elif tag == 0x31:
            length = struct.unpack_from('>I', self.data, self.pos)[0]
            self.pos += 4
            value = self.data[self.pos:self.pos+length].decode('utf-8')
            self.pos += length
            return value
        elif 0x20 <= tag <= 0x2f:
            length = tag - 0x20
            value = self.data[self.pos:self.pos+length]
            self.pos += length
            return value
        elif tag == 0x34:
            length = struct.unpack_from('>H', self.data, self.pos)[0]
            self.pos += 2
            value = self.data[self.pos:self.pos+length]
            self.pos += length
            return value
        elif tag == 0x35:
            length = struct.unpack_from('>I', self.data, self.pos)[0]
            self.pos += 4
            value = self.data[self.pos:self.pos+length]
            self.pos += length
            return value
        elif tag == ord('V'):
            items = []
            while self.data[self.pos] != ord('Z'):
                items.append(self.decode())
            self.pos += 1
            return items
        elif tag == ord('M'):
            mapping = {}
            while self.data[self.pos] != ord('Z'):
                key = self.decode()
                value = self.decode()
                mapping[key] = value
            self.pos += 1
            return mapping
        else:
            raise ValueError(f"Unknown tag: {hex(tag)}")

def test_hessian2():
    test_data = [
        None,
        True,
        False,
        42,
        -1000,
        100000,
        3.14,
        "hello",
        "a" * 50,
        b"bytes",
        b"x" * 100,
        [1, "two", 3.0],
        {"key": "value", "num": 123}
    ]
    
    encoder = Hessian2Encoder()
    decoder = Hessian2Decoder(b'')
    
    for original in test_data:
        encoded = encoder.encode(original)
        decoder = Hessian2Decoder(encoded)
        decoded = decoder.decode()
        assert original == decoded, f"Failed for {original}: got {decoded}"
        print(f"✓ {repr(original)} -> {repr(decoded)}")
    
    print("\nAll tests passed!")

if __name__ == "__main__":
    test_hessian2()
```