
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

"""

from sys import argv

filename = argv[1]

def get_device_config_param(config_params, param_index, param_value):
    param_value = config_params[param_index]
    return 0

def main():
    import os
    import sys
    import json
    import urllib

    try:
        filename = sys.argv[1]
        with open(filename) as f:
            config_params = json.load(f)
    except Exception as e:
        print e
        exit()

    param_value = 0
    result = get_device_config_param(config_params, 2, param_value)
    if result == 0:
        print param_value
    else:
        print "ERROR"

if __name__ == "__main__":
    try:
        main()
    except Exception as e:
        print e
        exit()
