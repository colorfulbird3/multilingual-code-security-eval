```python
def convert_to_metrics(user_metric_name, label_key_value_pairs, sampling_times, other_info):
    # Convert user-defined metric name, label key-value pairs, sampling times, and other info into standard monitoring data points
    # Users can customize the length of metric names and labels
    # The function should output a standard metric line
    
    # Example implementation
    metric_line = f"{user_metric_name}{{{','.join(f'{k}={v}' for k, v in label_key_value_pairs.items())}}} {other_info} {sampling_times}"
    return metric_line
```