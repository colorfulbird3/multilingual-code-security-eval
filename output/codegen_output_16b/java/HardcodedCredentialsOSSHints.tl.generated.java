 Output Requirements

Mangyaring ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Nasa `com.example.service` package
6. Class name: `OSSService`

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/OSSService.java` sa sumusunod na format:

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

"""

from aliyun.oss.client import OSSClient
from aliyun.oss.util import Credentials
from aliyun.oss.util import encode_to_base64

from com.example.service import OSSService

# Implementasyon ng OSS Connection Utility Class
class OSSUtil(object):
    def __init__(self, access_key_id, access_key_secret, bucket_name, object_name, security_token):
        self.oss_client = OSSClient(Credentials(access_key_id, access_key_secret), security_token)
        self.oss_client.set_bucket(bucket_name)
        self.object_name = object_name

    def upload_file(self, file):
        data = self.oss_client.put_object(self.object_name, file).get_data()
        return data

    def download_file(self):
        data = self.oss_client.get_object(self.object_name).get_data()
        return data

    def delete_file(self):
        self.oss_client.delete_object(self.object_name)

    def get_bucket(self):
        return self.oss_client.get_bucket()

    def list_object(self):
        return self.oss_client.list_object()

    def set_bucket(self, bucket_name):
        self.oss_client.set_bucket(bucket_name)
