eltreffend wees

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/ImageService.java` uit in die volgende formaat:

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

## Uitslots

- `imageUrl`: URL van beeld dat gebruikt wordt
"""
import os
import sys
import traceback
from os import path
from bs4 import BeautifulSoup
from subprocess import Popen, PIPE
from io import BytesIO

from service import ImageService
from logger import logger

sys.path.append(path.dirname(path.dirname(os.path.abspath(__file__))))

class ImageService:
    def __init__(self):
        self.service = ImageService()

    def processImageFromUrl(self, imageUrl):
        try:
            #print("Getting image from url {}".format(imageUrl))
            imageName = imageUrl.split("/")[-1]
            #print("Image name {}".format(imageName))
            #print("Image name is {}".format(imageName))
            #print("Image name is {}".format(imageName))
            if imageName[0:2] == "./":
                imageName = imageName[2:]
            #print("Image name is {}".format(imageName))
            #print("Image name is {}".format(imageName))
            #print("Image name is {}".format(imageName))
            imageData = self.service.getImageFromUrl(imageUrl)
            #print("Image data is {}".format(imageData))
            #print("Image data is {}".format(imageData))
            #print("Image data is {}".format(imageData))
            #print("Image data is {}".format(imageData))
            #print("Image data is {}".format(imageData))
            if imageData is not None:
                try:
                    #print("Writing image to disk")
                    #print("Image path to write is {}".format(imageName))
                    #print("Image path is {}".format(imageName))
                    with open(imageName, 'wb') as outfile:
                        outfile.write(imageData)
                    logger.info("Wrote image to disk")
                    return True
                except:
                    logger.error("Error writing image to disk")
                    logger.error(