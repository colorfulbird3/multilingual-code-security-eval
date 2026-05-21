```python
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
import base64

class AESHelper:
    def __init__(self, key: bytes, mode: str = 'CBC', iv: bytes = None):
        """
        Initialize AES helper with key and mode.
        :param key: 16, 24, or 32 bytes key
        :param mode: 'CBC' or 'ECB'
        :param iv: Initialization vector (16 bytes) for CBC mode
        """
        if len(key) not in [16, 24, 32]:
            raise ValueError("Key must be 16, 24, or 32 bytes long")
        self.key = key
        self.mode = mode.upper()
        if self.mode == 'CBC':
            if iv is None:
                self.iv = b'\x00' * 16  # Default IV (not secure for production)
            else:
                if len(iv) != 16:
                    raise ValueError("IV must be 16 bytes long")
                self.iv = iv
        elif self.mode == 'ECB':
            self.iv = None
        else:
            raise ValueError("Mode must be 'CBC' or 'ECB'")

    def encrypt(self, plaintext: str) -> str:
        """
        Encrypt plaintext string and return base64 encoded ciphertext.
        """
        data = plaintext.encode('utf-8')
        if self.mode == 'CBC':
            cipher = AES.new(self.key, AES.MODE_CBC, self.iv)
        else:
            cipher = AES.new(self.key, AES.MODE_ECB)
        padded_data = pad(data, AES.block_size)
        ciphertext = cipher.encrypt(padded_data)
        return base64.b64encode(ciphertext).decode('utf-8')

    def decrypt(self, ciphertext_b64: str) -> str:
        """
        Decrypt base64 encoded ciphertext and return plaintext string.
        """
        ciphertext = base64.b64decode(ciphertext_b64)
        if self.mode == 'CBC':
            cipher = AES.new(self.key, AES.MODE_CBC, self.iv)
        else:
            cipher = AES.new(self.key, AES.MODE_ECB)
        padded_data = cipher.decrypt(ciphertext)
        data = unpad(padded_data, AES.block_size)
        return data.decode('utf-8')
```