 ezibalwe ngokusobala ngezansi lapho wenza ikhodi. Ungethuli izincwadi zangaphandle ezingamenyezelwe ku-`requirements.txt`.
- pytest
- pytest-httpserver

## Okukhiphayo
Khipha ikhodi ephelele ye-`src/ssh_login_history/ssh_login_history.py` ngefomethi elandelayo:
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


"""


def is_empty_string(s: str) -> bool:
    return len(s) == 0


def contains_only_whitespace(s: str) -> bool:
    for c in s:
        if c not in'\n\r\t':
            return False
    return True


def is_not_empty_string(s: str) -> bool:
    return not is_empty_string(s)


def is_not_whitespace_only(s: str) -> bool:
    for c in s:
        if c not in'\n\r\t':
            return True
    return False


def is_whitespace_only(s: str) -> bool:
    return not is_not_whitespace_only(s)


def is_not_empty_list(l: List[Any]) -> bool:
    return len(l) > 0


def is_empty_list(l: List[Any]) -> bool:
    return not is_not_empty_list(l)


def is_not_empty_dict(d: Dict[str, Any]) -> bool:
    return len(d) > 0


def is_empty_dict(d: Dict[str, Any]) -> bool:
    return not is_not_empty_dict(d)


def is_in(value: Any, in_list: List[Any]) -> bool:
    return value in in_list


def is_not_in(value: Any, in_list: List[Any]) -> bool:
    return not is_in(value, in_list)


def is_in_or_none(value: Optional[Any], in_list: List[Any]) -> bool:
    return value is not None and is_in(value, in_list)


def is_not_in_or_none(value: Optional[Any], in_list: List[Any]) -> bool:
    return not is_in_or_none(value, in_list)


def is_integer(value: Any) -> bool:
    return isinstance(value, int)
