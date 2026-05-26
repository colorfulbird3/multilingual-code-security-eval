```python
def ai_response(user_input):
    # Simple AI response logic
    if "hello" in user_input.lower():
        return "Hello! How can I help you today?"
    elif "how are you" in user_input.lower():
        return "I'm just a program, but I'm functioning well!"
    elif "bye" in user_input.lower():
        return "Goodbye! Have a great day!"
    else:
        return "I'm not sure how to respond to that."
```