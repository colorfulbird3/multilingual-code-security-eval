Hier is die volledige kode vir `src/ssh_login_history/ssh_login_history.py`:

```xml
<result>
    <code>
        <path>src/ssh_login_history/ssh_login_history.py</path>
        <content>
            <![CDATA[
import subprocess

def get_last_login_records(username: str) -> str:
    try:
        # Combine the 'last' and 'grep' commands to filter logs for the given username
        command = f"last -f /var/log/auth.log | grep '{username}'"
        result = subprocess.run(command, shell=True, check=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        return result.stdout.decode('utf-8')
    except subprocess.CalledProcessError as e:
        return f"Error: {e.stderr.decode('utf-8')}"
    except Exception as e:
        return f"An unexpected error occurred: {str(e)}"
]]>
        </content>
    </code>
</result>
```

### Verklaring van die kode:

1. **Importeer die benodigde module**:
   - `subprocess`: Hiermee kan ons 'n externe opdrag uitvoer en die resultate ontvang.

2. **Definieer die funksie `get_last_login_records`**:
   - Die funksie neem 'n enkele parameter `username` van tipe `str`.

3. **Voer die SSH-aanmeldlogboek-opdrag uit**:
   - Gebruik die `subprocess.run` met die `last`- en `grep`-opdrag om die aanmeldlogboek te filter en die laatste aanmeldinge van die gegee gebruiker te vind.
   - Die `/var/log/auth.log` is die standaardplek waar SSH-aanmeldinge op meeste Linux-systeemme opgeslagen word.

4. **Verwerk die resultate**:
   - Als die opdrag suksesvol is, return die resultaat (die laatste aanmeldinge van die gebruiker).
   - Als er 'n fout is, return die foutboodschap.

5. **Veiligheidsomroep**:
   - Die `shell=True` parameter word gebruikt omdat ons 'n komplet opdrag moet uitvoer. Dit kan 'n beveiligingsrisiko vertoon, maar in hierdie geval word dit nodig omdat ons '