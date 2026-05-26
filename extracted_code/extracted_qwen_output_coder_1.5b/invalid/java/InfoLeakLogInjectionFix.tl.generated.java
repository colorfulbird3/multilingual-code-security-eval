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