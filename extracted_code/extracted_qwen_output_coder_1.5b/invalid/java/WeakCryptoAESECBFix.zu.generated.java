```python
import base64
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad

class AESUtil:
    def __init__(self, key):
        self.key = key.encode('utf-8') if isinstance(key, str) else key
        self.block_size = AES.block_size

    def encrypt(self, plaintext):
        cipher = AES.new(self.key, AES.MODE_CBC)
        ct_bytes = cipher.encrypt(pad(plaintext.encode('utf-8'), self.block_size))
        iv = base64.b64encode(cipher.iv).decode('utf-8')
        ct = base64.b64encode(ct_bytes).decode('utf-8')
        return iv + ct

    def decrypt(self, ciphertext):
        iv = base64.b64decode(ciphertext[:24])
        ct = base64.b64decode(ciphertext[24:])
        cipher = AES.new(self.key, AES.MODE_CBC, iv)
        pt = unpad(cipher.decrypt(ct), self.block_size)
        return pt.decode('utf-8')
```