```python
def load_workspace_from_yaml(state_yaml: str) -> dict:
    import yaml
    try:
        state = yaml.safe_load(state_yaml)
        if not isinstance(state, dict):
            raise ValueError("YAML must represent a dictionary")
        return state
    except yaml.YAMLError as e:
        raise ValueError(f"Invalid YAML: {e}")
```