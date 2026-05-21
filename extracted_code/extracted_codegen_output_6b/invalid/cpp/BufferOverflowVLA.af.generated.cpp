```python
import csv
import csv_parser

def main():
    """
    Returns 0 on successful parsing and -1 on parsing failure.
    """
    csv_parser.parse_csv_records(100, [4, 3, 3], ['a,1,x', 'b,2,y', 'c,3,z'], None)

if __name__ == '__main__':
    main()
```