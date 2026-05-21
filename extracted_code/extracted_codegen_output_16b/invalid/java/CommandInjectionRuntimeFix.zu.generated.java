```python
import os
import fnmatch

def search_files(searchDir, filePattern):
    matching_files = []
    for root, dirs, files in os.walk(searchDir):
        for filename in fnmatch.filter(files, filePattern):
            matching_files.append(os.path.join(root, filename))
    return matching_files
```