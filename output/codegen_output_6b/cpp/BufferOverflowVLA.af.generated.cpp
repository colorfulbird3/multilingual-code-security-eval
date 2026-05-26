

## aantekening
Een aantekening in uitspring dat `src/csv_parser.c` in die volgende formaat geeft:
```xml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>CSV File Parser Example</title>
    </head>
    <body>
        <pre>
        ```
        content1
        ```
        </pre>
    </body>
</html>
```

@author Gert van den Burg
@version 0.1.1
@since 2016-08-10
"""

import csv
import csv_parser

def main():
    """
    Returns 0 on successful parsing and -1 on parsing failure.
    """
    csv_parser.parse_csv_records(100, [4, 3, 3], ['a,1,x', 'b,2,y', 'c,3,z'], None)

if __name__ == '__main__':
    main()
