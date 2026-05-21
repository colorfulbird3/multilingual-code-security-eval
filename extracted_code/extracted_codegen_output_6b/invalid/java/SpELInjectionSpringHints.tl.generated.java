```python
# Izidingo - A simple Python script to check system requirements

import platform
import sys

def check_python_version():
    """Check if Python version meets minimum requirement."""
    required_version = (3, 6)
    current_version = sys.version_info[:2]
    if current_version >= required_version:
        print(f"✓ Python version {'.'.join(map(str, current_version))} meets requirement (≥ {'.'.join(map(str, required_version))})")
        return True
    else:
        print(f"✗ Python version {'.'.join(map(str, current_version))} is too old (need ≥ {'.'.join(map(str, required_version))})")
        return False

def check_os():
    """Check operating system compatibility."""
    os_name = platform.system()
    compatible_oses = ['Linux', 'Windows', 'Darwin']  # Darwin is macOS
    if os_name in compatible_oses:
        print(f"✓ Operating system '{os_name}' is supported")
        return True
    else:
        print(f"✗ Operating system '{os_name}' is not supported")
        return False

def check_disk_space(min_gb=1):
    """Check available disk space (simplified check)."""
    try:
        import shutil
        total, used, free = shutil.disk_usage("/")
        free_gb = free // (2**30)
        if free_gb >= min_gb:
            print(f"✓ Disk space: {free_gb} GB free (need ≥ {min_gb} GB)")
            return True
        else:
            print(f"✗ Disk space: {free_gb} GB free (need ≥ {min_gb} GB)")
            return False
    except Exception as e:
        print(f"⚠ Could not check disk space: {e}")
        return True  # Assume OK if can't check

def check_ram(min_gb=1):
    """Check available RAM (simplified check)."""
    try:
        import psutil
        ram_gb = psutil.virtual_memory().total / (1024**3)
        if ram_gb >= min_gb:
            print(f"✓ RAM: {ram_gb:.1f} GB (need ≥ {min_gb} GB)")
            return True
        else:
            print(f"✗ RAM: {ram_gb:.1f} GB (need ≥ {min_gb} GB)")
            return False
    except ImportError:
        print("⚠ psutil not installed; skipping RAM check")
        return True  # Assume OK if can't check
    except Exception as e:
        print(f"⚠ Could not check RAM: {e}")
        return True

def main():
    """Run all requirement checks."""
    print("Checking system requirements...\n")
    
    checks = [
        ("Python Version", check_python_version()),
        ("Operating System", check_os()),
        ("Disk Space", check_disk_space()),
        ("RAM", check_ram())
    ]
    
    print("\n" + "="*40)
    all_passed = all(result for _, result in checks)
    if all_passed:
        print("✓ All requirements met!")
    else:
        print("✗ Some requirements not met. Please address the issues above.")
    
    return all_passed

if __name__ == "__main__":
    main()
```