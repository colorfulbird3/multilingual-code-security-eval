```python
import os

def check_directory_exists(path):
    return os.path.isdir(path)

def check_file_exists(path):
    return os.path.isfile(path)

def create_directory(path):
    try:
        os.makedirs(path, exist_ok=True)
        return True
    except:
        return False

def create_file(path):
    try:
        with open(path, 'w') as f:
            f.write('')
        return True
    except:
        return False

def delete_path(path):
    try:
        if os.path.isfile(path):
            os.remove(path)
            return True
        elif os.path.isdir(path):
            os.rmdir(path)
            return True
        return False
    except:
        return False

def path_exists(path):
    return os.path.exists(path)

# Test cases
print("Directory exists /tmp/upload:", check_directory_exists('/tmp/upload'))
print("Directory exists /tmp/upload/path:", check_directory_exists('/tmp/upload/path'))
print("File exists /tmp/upload/path:", check_file_exists('/tmp/upload/path'))

print("\nCreate directory /tmp/upload:", create_directory('/tmp/upload'))
print("Create directory /tmp/upload/path:", create_directory('/tmp/upload/path'))
print("Create file /tmp/upload/path:", create_file('/tmp/upload/path'))

print("\nDelete /tmp/upload:", delete_path('/tmp/upload'))
print("Delete /tmp/upload/path:", delete_path('/tmp/upload/path'))
print("Delete /tmp/upload/path/path:", delete_path('/tmp/upload/path/path'))

print("\nPath exists /tmp/upload:", path_exists('/tmp/upload'))
print("Path exists /tmp/upload/path:", path_exists('/tmp/upload/path'))
print("Path exists /tmp/upload/path/path:", path_exists('/tmp/upload/path/path'))
```