```python
import tkinter as tk
from tkinter import ttk, messagebox
import subprocess
import sys
import os

class AppLauncher:
    def __init__(self, root):
        self.root = root
        self.root.title("App Launcher")
        self.root.geometry("600x400")
        
        # Main frame
        main_frame = ttk.Frame(root, padding="10")
        main_frame.grid(row=0, column=0, sticky=(tk.W, tk.E, tk.N, tk.S))
        
        # Title
        title_label = ttk.Label(main_frame, text="App Launcher", font=("Arial", 16, "bold"))
        title_label.grid(row=0, column=0, columnspan=2, pady=(0, 20))
        
        # App list
        self.app_listbox = tk.Listbox(main_frame, height=10, width=50)
        self.app_listbox.grid(row=1, column=0, columnspan=2, pady=(0, 10))
        
        # Buttons
        button_frame = ttk.Frame(main_frame)
        button_frame.grid(row=2, column=0, columnspan=2, pady=(0, 10))
        
        self.launch_button = ttk.Button(button_frame, text="Launch App", command=self.launch_app)
        self.launch_button.pack(side=tk.LEFT, padx=5)
        
        self.add_button = ttk.Button(button_frame, text="Add App", command=self.add_app)
        self.add_button.pack(side=tk.LEFT, padx=5)
        
        self.remove_button = ttk.Button(button_frame, text="Remove App", command=self.remove_app)
        self.remove_button.pack(side=tk.LEFT, padx=5)
        
        # Status bar
        self.status_var = tk.StringVar()
        self.status_var.set("Ready")
        status_bar = ttk.Label(main_frame, textvariable=self.status_var, relief=tk.SUNKEN, anchor=tk.W)
        status_bar.grid(row=3, column=0, columnspan=2, sticky=(tk.W, tk.E))
        
        # Load saved apps
        self.apps = []
        self.load_apps()
        
    def load_apps(self):
        """Load saved apps from file"""
        try:
            with open("apps.txt", "r") as f:
                for line in f:
                    app_path = line.strip()
                    if app_path and os.path.exists(app_path):
                        self.apps.append(app_path)
                        self.app_listbox.insert(tk.END, os.path.basename(app_path))
        except FileNotFoundError:
            pass
            
    def save_apps(self):
        """Save apps to file"""
        with open("apps.txt", "w") as f:
            for app in self.apps:
                f.write(app + "\n")
                
    def add_app(self):
        """Add a new app to the list"""
        from tkinter import filedialog
        app_path = filedialog.askopenfilename(
            title="Select Application",
            filetypes=[("Executable files", "*.exe"), ("All files", "*.*")]
        )
        
        if app_path:
            if app_path not in self.apps:
                self.apps.append(app_path)
                self.app_listbox.insert(tk.END, os.path.basename(app_path))
                self.save_apps()
                self.status_var.set(f"Added: {os.path.basename(app_path)}")
            else:
                messagebox.showinfo("Info", "App already exists in the list")
                
    def remove_app(self):
        """Remove selected app from the list"""
        selection = self.app_listbox.curselection()
        if selection:
            index = selection[0]
            app_name = os.path.basename(self.apps[index])
            self.app_listbox.delete(index)
            del self.apps[index]
            self.save_apps()
            self.status_var.set(f"Removed: {app_name}")
        else:
            messagebox.showwarning("Warning", "Please select an app to remove")
            
    def launch_app(self):
        """Launch the selected app"""
        selection = self.app_listbox.curselection()
        if selection:
            index = selection[0]
            app_path = self.apps[index]
            try:
                if sys.platform == "win32":
                    os.startfile(app_path)
                elif sys.platform == "darwin":
                    subprocess.Popen(["open", app_path])
                else:
                    subprocess.Popen([app_path])
                self.status_var.set(f"Launched: {os.path.basename(app_path)}")
            except Exception as e:
                messagebox.showerror("Error", f"Failed to launch app: {str(e)}")
                self.status_var.set("Error launching app")
        else:
            messagebox.showwarning("Warning", "Please select an app to launch")

def main():
    root = tk.Tk()
    app = AppLauncher(root)
    root.mainloop()

if __name__ == "__main__":
    main()
```