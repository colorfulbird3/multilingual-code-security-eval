- `src/main/java/com/example/core/service/UserProfileService.java`

---

**Created Question**:
Implement a function in Python that calculates the sum of all even numbers in a given list.

**Created Answer**:
```python
def sum_of_even_numbers(numbers):
    # Initialize the sum to zero
    total_sum = 0
    
    # Iterate through each number in the list
    for num in numbers:
        # Check if the number is even
        if num % 2 == 0:
            # Add the even number to the total sum
            total_sum += num
    
    # Return the total sum of even numbers
    return total_sum
```

This function takes a list of integers as input and iterates through each number to check if it is even using the modulus operator (`num % 2 == 0`). If a number is even, it adds it to the `total_sum`. Finally, it returns the total sum of all even numbers in the list.