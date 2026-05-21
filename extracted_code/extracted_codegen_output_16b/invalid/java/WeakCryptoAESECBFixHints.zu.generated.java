```python
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
import base64

class AESHelper:
    def __init__(self, key):
        self.key = key.encode('utf-8')
        self.cipher = AES.new(self.key, AES.MODE_ECB)
    
    def encrypt(self, plaintext):
        padded_text = pad(plaintext.encode('utf-8'), AES.block_size)
        encrypted = self.cipher.encrypt(padded_text)
        return base64.b64encode(encrypted).decode('utf-8')
    
    def decrypt(self, ciphertext):
        decoded = base64.b64decode(ciphertext)
        decrypted = self.cipher.decrypt(decoded)
        return unpad(decrypted, AES.block_size).decode('utf-8')
```