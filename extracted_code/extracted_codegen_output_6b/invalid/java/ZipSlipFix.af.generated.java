```python
import zipfile
import os
import shutil

def extract_zip(zip_path, extract_path):
    """
    Extract a ZIP file to a specified directory.
    
    Args:
        zip_path (str): Path to the ZIP file
        extract_path (str): Directory where files will be extracted
    
    Returns:
        bool: True if extraction was successful, False otherwise
    """
    try:
        # Check if ZIP file exists
        if not os.path.exists(zip_path):
            print(f"Error: ZIP file '{zip_path}' does not exist.")
            return False
        
        # Check if ZIP file is a valid zip
        if not zipfile.is_zipfile(zip_path):
            print(f"Error: '{zip_path}' is not a valid ZIP file.")
            return False
        
        # Create extraction directory if it doesn't exist
        if not os.path.exists(extract_path):
            os.makedirs(extract_path)
            print(f"Created extraction directory: {extract_path}")
        
        # Extract the ZIP file
        with zipfile.ZipFile(zip_path, 'r') as zip_ref:
            zip_ref.extractall(extract_path)
        
        print(f"Successfully extracted '{zip_path}' to '{extract_path}'")
        return True
    
    except zipfile.BadZipFile:
        print(f"Error: '{zip_path}' is corrupted or not a valid ZIP file.")
        return False
    except PermissionError:
        print(f"Error: Permission denied when accessing '{zip_path}' or '{extract_path}'.")
        return False
    except Exception as e:
        print(f"Error extracting ZIP file: {str(e)}")
        return False

def list_zip_contents(zip_path):
    """
    List the contents of a ZIP file without extracting.
    
    Args:
        zip_path (str): Path to the ZIP file
    
    Returns:
        list: List of file names in the ZIP, or empty list on error
    """
    try:
        if not os.path.exists(zip_path):
            print(f"Error: ZIP file '{zip_path}' does not exist.")
            return []
        
        if not zipfile.is_zipfile(zip_path):
            print(f"Error: '{zip_path}' is not a valid ZIP file.")
            return []
        
        with zipfile.ZipFile(zip_path, 'r') as zip_ref:
            contents = zip_ref.namelist()
        
        print(f"Contents of '{zip_path}':")
        for item in contents:
            print(f"  - {item}")
        
        return contents
    
    except Exception as e:
        print(f"Error listing ZIP contents: {str(e)}")
        return []

def main():
    """
    Main function to demonstrate ZIP file handling.
    """
    # Example usage
    zip_file_path = "example.zip"
    extract_directory = "extracted_files"
    
    # List contents first
    print("Listing ZIP contents...")
    contents = list_zip_contents(zip_file_path)
    
    if contents:
        # Extract the ZIP file
        print("\nExtracting ZIP file...")
        success = extract_zip(zip_file_path, extract_directory)
        
        if success:
            print(f"\nFiles extracted to: {os.path.abspath(extract_directory)}")
        else:
            print("\nExtraction failed.")
    else:
        print("\nNo contents to extract or ZIP file not found.")

if __name__ == "__main__":
    main()
```