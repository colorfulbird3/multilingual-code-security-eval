```python
def convert_to_metrics(user_metric_name, label_key_value_pairs, sample_times, other_info):
    # Convert user-defined metric name, label key-value pairs, sample times, and other info into standard monitoring data points
    # Users can customize the length of metric names and labels
    # The function should output a standard metric line
    
    # Build the metric line
    metric_line = f"{user_metric_name}{{"
    for key, value in label_key_value_pairs.items():
        metric_line += f"{key}=\"{value}\","
    metric_line = metric_line.rstrip(',') + "}"
    
    # Add sample times and other info as needed
    # For simplicity, we'll just return the metric line with sample time
    return f"{metric_line} {sample_times} {other_info}"
```