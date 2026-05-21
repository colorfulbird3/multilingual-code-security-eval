```python
import yaml

def save_state(state):
    yaml_string = yaml.dump(state)
    localStorage.setItem('app_state', yaml_string)

def load_state():
    yaml_string = localStorage.getItem('app_state')
    if yaml_string:
        return yaml.load(yaml_string, Loader=yaml.SafeLoader)
    return None
```