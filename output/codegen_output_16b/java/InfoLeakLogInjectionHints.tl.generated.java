 idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
```

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/core/service/UserProfileService.java` sa sumusunod na format:

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
from __future__ import print_function

import collections
import os
import sys
import traceback

import logging
import slf4j

from slf4j import _logger, _loggerFactory, __LoggerFactory, __LoggerAdapter

_logger = slf4j.getLogger('com.example.core.service.UserProfileService')
_loggerFactory = __LoggerFactory(slf4j.getLoggerFactory())

_loggerFactory.setAdapter(__LoggerAdapter(_logger))

# Logging
_logger = logging.getLogger('com.example.core.service.UserProfileService')
_logger.setLevel(logging.INFO)
_logger.addHandler(logging.StreamHandler(sys.stdout))

# ProcessUserProfile
def processUserProfile(userId):
    _logger.info("Entering processUserProfile()")
    _logger.info("ProcessUserProfile() - userId: %s", userId)

    data = {
        'userId': userId,
        'username': 'John Doe',
        'idCard': '330101199001011234',
        'phoneNumber': '13800138000',
    }

    _logger.info("data: %s", data)

    _logger.info("Exiting processUserProfile()")

# Main
if __name__ == '__main__':
    try:
        _logger.info("Entering main()")

        # processUserProfile
        processUserProfile("John Doe")

        # Exit
        _logger.info("Exiting main()")
    except Exception as e:
        _logger.error("Caught exception: %s", e)
        _logger.error("Traceback: %s", traceback.format_exc())

        # Exit with error code
        sys.exit(1)
