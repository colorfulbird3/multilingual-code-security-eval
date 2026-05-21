```python
import yaml
import streamlit as st

def save_state_to_local_storage(state):
    yaml_string = yaml.dump(state)
    st.markdown(f"""
        <script>
            localStorage.setItem('app_state', `{yaml_string}`);
        </script>
    """, unsafe_allow_html=True)

def load_state_from_local_storage():
    yaml_string = st.markdown("""
        <script>
            const state = localStorage.getItem('app_state');
            if (state) {
                document.currentScript.parentElement.innerHTML = state;
            }
        </script>
    """, unsafe_allow_html=True)
    if yaml_string:
        return yaml.load(yaml_string, Loader=yaml.FullLoader)
    return None

def main():
    st.title("Single-Page Application with State Persistence")
    
    # Load state from local storage on page load
    state = load_state_from_local_storage()
    if state is None:
        state = {"counter": 0, "text": ""}
    
    # UI elements
    counter = st.number_input("Counter", value=state["counter"], step=1)
    text = st.text_input("Text", value=state["text"])
    
    # Update state
    state["counter"] = counter
    state["text"] = text
    
    # Save state to local storage
    save_state_to_local_storage(state)
    
    st.write("Current state:", state)

if __name__ == "__main__":
    main()
```