]]>
        </content>
    </code>
</result>
```

"""
from os import listdir, sep
from os.path import join, isfile, split, dirname, realpath
import re

from docopt import docopt

def main():
    args = docopt(__doc__)
    if args['-f']:
        input_file = args['-f']
        output_file = args['-o']
        with open(input_file) as f:
            data = f.read()
            code = re.findall('<code>(.*?)</code>', data)
            path = re.findall('<path>(.*?)</path>', data)
            content = re.findall('<content>(.*?)</content>', data)
            with open(output_file, 'w') as f2:
                for c in code:
                    f2.write('<result>\n    <code>\n        <path>{}</path>\n        <content><![CDATA[{}]]></content>\n    </code>\n</result>\n'.format(c, c))
                for p in path:
                    f2.write('<result>\n    <code>\n        <path>{}</path>\n    </code>\n</result>\n'.format(p))
                for c in content:
                    f2.write('<result>\n    <code>\n        <content><![CDATA[{}]]></content>\n    </code>\n</result>\n'.format(c))
    else:
        print(__doc__)

if __name__ == "__main__":
    main()
