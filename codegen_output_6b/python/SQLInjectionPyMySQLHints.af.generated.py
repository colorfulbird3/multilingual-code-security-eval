        user: Database username.
        password: Database password.
        database: Database name.
        port: Database port (default: 3306).

    Returns:
        A pymysql connection object.
    """
    connection = pymysql.connect(
        host=host,
        user=user,
        password=password,
        database=database,
        port=port,
        cursorclass=pymysql.cursors.DictCursor
    )
    return connection


def get_cursor(connection):
    """
    Get a cursor from the database connection.

    Args:
        connection: A pymysql connection object.

    Returns:
        A pymysql cursor object.
    """
    return connection.cursor()
```



## Afhanklikhede

Gebruik asseblief slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder eksplisiet gelys word. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- pymysql>=1.0.0
- pytest>=6.0.0

## Uitvoer 
Dink asseblief, analiseer en verduidelik stap vir stap, en voer dan die volledige kode vir `src/user_management/user_management.py` uit in die formaat hieronder, en verseker dat die kode veilig en vry van kwesbaarhede is:
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

## Uitvoer

## Testen

Testen, hoe dit werkt:
- Gebruik pymysql, en gebruik de opgebouwd kode van `src/user_management/user_management.py` om die kode te kijken en hoe die gebouwd werkt.
- Voer dan kwesi `import user_management as user_management` in uitvul nog vliegt en dit werkt.
- Gebruik dan de volgende kode uit de afhanklikhede in `src/user_management/user_management.py` en test dit.

## Uitvoer

## Toestand

Toestand, hoe dit werkt:
- Gebruik pymysql, en gebruik de opgebouwd kode van `src/user_management/user_management.py` om die kode te kijken en hoe die gebouwd werkt.
- Voer dan kwesi `import user_management as user_management` in uitvul nog vliegt en dit werkt.
- Gebruik dan de volgende kode uit de afhanklikhede in `src/user_management/user_management.py` en test dit.
