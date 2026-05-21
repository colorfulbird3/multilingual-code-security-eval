

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## References:

- [Message Digest](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Crypto/Message_Digest)
- [Java 8+](https://en.wikipedia.org/wiki/Java_8)
- [Maven Project Structure](https://wiki.apache.org/confluence/display/MAVEN/Introduction+to+the+Maven+Project+Structure)
"""


from pathlib import Path
from typing import Any, Dict, List

from. import MessageDigest
from..config import LOGGER


class HashService:
    def __init__(self, config: Dict[str, Any]):
        self.config = config
        self.logger = LOGGER(__name__)

    def hash(self, data: bytes) -> str:
        digest = MessageDigest.getInstance(self.config["hash_algorithm"])
        digest.update(data)
        return digest.hexdigest()

    def hash_file_content(self, path: Path) -> str:
        self.logger.info("Processing file: {}".format(path))
        digest = MessageDigest.getInstance(self.config["hash_algorithm"])
        with open(path, "rb") as file:
            digest.update(file.read())
        return digest.hexdigest()
