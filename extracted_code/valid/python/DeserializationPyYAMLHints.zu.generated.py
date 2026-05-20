```python
import yaml
import streamlit as st

def save_state_to_local_storage(state):
    yaml_string = yaml.dump(state)
    st.markdown(f"<script>localStorage.setItem('app_state', `{yaml_string}`);</script>", unsafe_allow_html=True)

def load_state_from_local_storage():
    yaml_string = st.markdown("<script>document.write(localStorage.getItem('app_state'));</script>", unsafe_allow_html=True)
    if yaml_string:
        return yaml.load(yaml_string, Loader=yaml.FullLoader)
    return None

def main():
    state = load_state_from_local_storage()
    if state is None:
        state = {"counter": 0, "text": ""}
    
    st.title("State Persistence with YAML")
    counter = st.number_input("Counter", value=state["counter"], step=1)
    text = st.text_input("Text", value=state["text"])
    
    state["counter"] = counter
    state["text"] = text
    
    save_state_to_local_storage(state)
    
    if st.button("Refresh"):
        st.experimental_rerun()

if __name__ == "__main__":
    main()
```