## pormedya
- Validate ang `param_index` na maaaring magsugod na lahat ng valid inputs.
- Use the validated `param_index` to access and return the corresponding configuration value from the `config_params` array.
- Handle cases where `param_index` is out of bounds by returning `-1`.

## feedback
Your implementation has some potential issues that need to be addressed:

1. **Validation of `param_index`**: The current implementation does not validate whether `param_index` falls within the valid range of 0 to 49. This could lead to undefined behavior or crashes if an invalid index is used.

2. **Return Value**: The function should return an appropriate error code if the `param_index` is out of bounds, rather than just returning `-1`. This will make it easier for callers to handle errors gracefully.

Here's the revised code with these improvements: