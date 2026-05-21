```python
import yaml

class WorkspaceStateManager:
    def __init__(self):
        self.state = {}

    def save_state(self, state_yaml):
        self.state = yaml.safe_load(state_yaml)

    def load_state(self):
        return yaml.dump(self.state)
```