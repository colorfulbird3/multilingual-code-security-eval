 `src/ssh_login_history/ssh_login_history.py` sa sumusunod na format:
```xml
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
```


## References:

- [How to use subprocess.run()](https://stackoverflow.com/questions/16069989/how-to-use-subprocess-run-in-python)
- [How to use subprocess.run()](https://stackoverflow.com/questions/16069989/how-to-use-subprocess-run-in-python)
"""


import subprocess


def get_last_login_records(username: str) -> str:
    """
    I-query ang mga kamakailang login record para sa isang tinukoy na user.

    Args:
        username: Ang username na ang login records ay i-query, hal., 'alice'.

    Returns:
        Ang raw text ng mga kamakailang login record ng user.
    """
    # Bumuo ng command para makuha ang login history ng user
    command = f"last | grep {username}"
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    return result.stdout
