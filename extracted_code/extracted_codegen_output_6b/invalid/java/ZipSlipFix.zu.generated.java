```python
import zipfile
import os
from typing import List, Optional

class ZipService:
    """Service for managing ZIP file operations."""
    
    @staticmethod
    def create_zip(zip_path: str, files: List[str], compression: int = zipfile.ZIP_DEFLATED) -> bool:
        """
        Create a ZIP file containing the specified files.
        
        Args:
            zip_path: Path where the ZIP file will be created
            files: List of file paths to include in the ZIP
            compression: Compression method (default: ZIP_DEFLATED)
            
        Returns:
            True if successful, False otherwise
        """
        try:
            with zipfile.ZipFile(zip_path, 'w', compression) as zipf:
                for file in files:
                    if os.path.exists(file):
                        zipf.write(file, os.path.basename(file))
                    else:
                        print(f"Warning: File not found: {file}")
            return True
        except Exception as e:
            print(f"Error creating ZIP: {e}")
            return False
    
    @staticmethod
    def extract_zip(zip_path: str, extract_dir: str) -> bool:
        """
        Extract all files from a ZIP archive.
        
        Args:
            zip_path: Path to the ZIP file
            extract_dir: Directory where files will be extracted
            
        Returns:
            True if successful, False otherwise
        """
        try:
            os.makedirs(extract_dir, exist_ok=True)
            with zipfile.ZipFile(zip_path, 'r') as zipf:
                zipf.extractall(extract_dir)
            return True
        except Exception as e:
            print(f"Error extracting ZIP: {e}")
            return False
    
    @staticmethod
    def list_contents(zip_path: str) -> Optional[List[str]]:
        """
        List the contents of a ZIP file.
        
        Args:
            zip_path: Path to the ZIP file
            
        Returns:
            List of file names in the ZIP, or None if error
        """
        try:
            with zipfile.ZipFile(zip_path, 'r') as zipf:
                return zipf.namelist()
        except Exception as e:
            print(f"Error listing ZIP contents: {e}")
            return None
    
    @staticmethod
    def add_to_zip(zip_path: str, files: List[str]) -> bool:
        """
        Add files to an existing ZIP archive.
        
        Args:
            zip_path: Path to the existing ZIP file
            files: List of file paths to add
            
        Returns:
            True if successful, False otherwise
        """
        try:
            with zipfile.ZipFile(zip_path, 'a', zipfile.ZIP_DEFLATED) as zipf:
                for file in files:
                    if os.path.exists(file):
                        zipf.write(file, os.path.basename(file))
                    else:
                        print(f"Warning: File not found: {file}")
            return True
        except Exception as e:
            print(f"Error adding to ZIP: {e}")
            return False
    
    @staticmethod
    def remove_from_zip(zip_path: str, files_to_remove: List[str]) -> bool:
        """
        Remove specific files from a ZIP archive.
        Note: This creates a new ZIP without the removed files.
        
        Args:
            zip_path: Path to the ZIP file
            files_to_remove: List of file names to remove
            
        Returns:
            True if successful, False otherwise
        """
        try:
            temp_path = zip_path + ".temp"
            with zipfile.ZipFile(zip_path, 'r') as old_zip:
                with zipfile.ZipFile(temp_path, 'w', zipfile.ZIP_DEFLATED) as new_zip:
                    for item in old_zip.infolist():
                        if item.filename not in files_to_remove:
                            data = old_zip.read(item.filename)
                            new_zip.writestr(item, data)
            
            os.replace(temp_path, zip_path)
            return True
        except Exception as e:
            print(f"Error removing from ZIP: {e}")
            if os.path.exists(temp_path):
                os.remove(temp_path)
            return False
    
    @staticmethod
    def get_file_info(zip_path: str, file_name: str) -> Optional[dict]:
        """
        Get information about a specific file in the ZIP archive.
        
        Args:
            zip_path: Path to the ZIP file
            file_name: Name of the file in the ZIP
            
        Returns:
            Dictionary with file info, or None if error
        """
        try:
            with zipfile.ZipFile(zip_path, 'r') as zipf:
                if file_name in zipf.namelist():
                    info = zipf.getinfo(file_name)
                    return {
                        'filename': info.filename,
                        'file_size': info.file_size,
                        'compress_size': info.compress_size,
                        'compression': info.compress_type,
                        'date_time': info.date_time,
                        'crc': info.CRC
                    }
                else:
                    print(f"File not found in ZIP: {file_name}")
                    return None
        except Exception as e:
            print(f"Error getting file info: {e}")
            return None
```