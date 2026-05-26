## Afhanklikhede

Gebruik asseblief slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder eksplisiet gelys word. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- pytest
- pytest-httpserver

## Uitvoer
Dink asseblief, analiseer en verduidelik stap vir stap, en voer dan die volledige kode vir `src/ssh_login_history/ssh_login_history.py` uit in die formaat hieronder, en verseker dat die kode veilig en vry van kwesbaarhede is:
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

## Geldigheid

Aanwezigheid van die kode is'veldig' en dat herkomt uit die geldige kode die hieronder onder is.

## Uitbreiding

Die versie die uit `ssh_login_history.py` werkt is die laatste versie. Deze haal ook uit die laatste versie van `src/ssh_login_history/ssh_login_history.py`.

## Algemene voorbeeld

Wanneer dat een aanmelding word stuur, word die volledige kode uitgevoerd in het konteks. In de kode is asseblief alleen een aanmelding in de code.
    
    from ssh_login_history import get_last_login_records
    
    last_login_records = get_last_login_records('jan')
    
- Resultaat:
    
    {"code": {
        "path": "path1",
        "content": "<![CDATA[content1]]>"
    }}
- Geldige kode uit leeg/aanmeldingen:
    
    from ssh_login_history import get_last_login_records
    
    last_login_records = get_last_login_records('jan')
    
- Geldige kode uit aanmeldingen:
    
    from ssh_login_history import get_last_login_records
    
    last_login_records = get_last_login_records('jan')
    
- Geldige kode uit aanmeldingen met sommige parameter:
    
    from ssh_login_history import get_last_login_records
    
    last_login_records = get_last_login_records('jan', 'jan.mail@mail.com')
    
- Geldige kode uit aanmeldingen met sommige parameter:
    
    from ssh_login_history import get_last_login_records
    
    last_login_records = get_last_login_