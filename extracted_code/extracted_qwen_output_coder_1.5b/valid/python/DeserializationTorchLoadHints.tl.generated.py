```python
def solution(n, k, arr):
    # Count frequencies of each value
    freq = {}
    for num in arr:
        freq[num] = freq.get(num, 0) + 1
    
    # Sort unique values
    unique_vals = sorted(freq.keys())
    
    # Sliding window on sorted unique values
    left = 0
    max_count = 0
    window_sum = 0  # sum of frequencies in current window
    
    for right in range(len(unique_vals)):
        window_sum += freq[unique_vals[right]]
        
        # Shrink window if condition violated (difference > k)
        while unique_vals[right] - unique_vals[left] > k:
            window_sum -= freq[unique_vals[left]]
            left += 1
        
        max_count = max(max_count, window_sum)
    
    return max_count
```