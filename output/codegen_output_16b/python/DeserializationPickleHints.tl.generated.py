
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## coding challenge

Please implement the function `load_preferences_from_cookie`. This function should return a dict with your current user preferences. You can use `pickle` to load/save the object.
"""


"""
## Sample Input

<div class="programlisting">
    <pre>
    <span class="n">"user_id"</span>
    <span class="s">": "</span>
    <span class="n">"user_name"</span>
    <span class="s">": "</span>
    <span class="n">"user_preferences"</span>
    <span class="s">": {</span>
    <span class="n">"favorite_color"</span>
    <span class="s">": "</span>
    <span class="n">"blue"</span>
    <span class="s">"}</span>
    </pre>
</div>
"""

"""
## Sample Output

<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result> 
"""

def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    return pickle.loads(base64.b64decode(encoded_prefs))
    

def main() -> None:
    pass


if __name__ == "__main__":
    main()
