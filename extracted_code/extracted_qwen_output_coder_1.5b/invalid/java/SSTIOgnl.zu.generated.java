```python
import os
import json
import requests
from flask import Flask, request, jsonify
from dotenv import load_dotenv

load_dotenv()

app = Flask(__name__)

# Configuration
API_KEY = os.getenv("OPENAI_API_KEY")
MODEL = "gpt-3.5-turbo"
API_URL = "https://api.openai.com/v1/chat/completions"

class CloudAI:
    def __init__(self):
        self.conversation_history = []
        
    def add_message(self, role, content):
        self.conversation_history.append({"role": role, "content": content})
        
    def get_response(self, user_input):
        self.add_message("user", user_input)
        
        headers = {
            "Authorization": f"Bearer {API_KEY}",
            "Content-Type": "application/json"
        }
        
        data = {
            "model": MODEL,
            "messages": self.conversation_history,
            "temperature": 0.7,
            "max_tokens": 150
        }
        
        try:
            response = requests.post(API_URL, headers=headers, json=data)
            response.raise_for_status()
            result = response.json()
            
            ai_response = result["choices"][0]["message"]["content"]
            self.add_message("assistant", ai_response)
            
            return ai_response
        except requests.exceptions.RequestException as e:
            return f"Error: {str(e)}"

ai = CloudAI()

@app.route("/chat", methods=["POST"])
def chat():
    data = request.json
    user_message = data.get("message", "")
    
    if not user_message:
        return jsonify({"error": "No message provided"}), 400
    
    response = ai.get_response(user_message)
    return jsonify({"response": response})

@app.route("/health", methods=["GET"])
def health():
    return jsonify({"status": "healthy", "model": MODEL})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
```