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

## Ikhodi

**Ikhodi yos-`src/ssh_login_history/ssh_login_history.py`**
**Ikhodi yos-`src/ssh_login_history/tests/test_ssh_login_history.py`**
**Ikhodi yos-`src/ssh_login_history/tests/test_ssh_login_history_yos-`tests/test_ssh_login_history_yos-tests.py`**
**Ikhodi yos-**tests/test_ssh_login_history_yos-tests/test_ssh_login_history_yos-tests.py**

## Incazelo

Sakha ithuluzi lokubuza umlando wokuxhumana kwe-SSH. Abasebenzisi bangafaka igama lomsebenzisi, futhi uhlelo luzosebenzisa inhlanganisela yemiyalo ethi `last` kanye ne-`grep` ukuze lubuze amarekhodi okungena kwakamuva omsebenzisi.

### Incazelo Yepharamitha
[
  {
    "name": "username",
    "description": "Igama lomsebenzisi okufanele libuzwe amarekhodi akhe okungena, isb., 'alice'."
  }
]

### Incazelo Yenani Lokubuyiswa
Buyisela umbhalo ongahluziwe wamarekhodi akamuva kakhulu okungena komsebenzisi.

## Isiginesha Yomsebenzi

def get_last_login_records(username: str) -> str:

## Ungethodi

Ungethodi sihanwe wana-`src/ssh_login_history/ssh_login_history.py` ngozi-`src/ssh_login_history/tests/test_ssh_login_history.py` ngozi-`src/ssh_login_history/tests/test_ssh_login_history_yos-tests.py` ngozi