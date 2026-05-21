def get_weather(city: str) -> str:
    \"\"\"Get the current weather for a given city.\"\"\"
    import random
    conditions = ["Sunny", "Cloudy", "Rainy", "Windy", "Snowy"]
    temp = random.randint(-5, 35)
    condition = random.choice(conditions)
    return f"The weather in {city} is {condition} with a temperature of {temp}°C."