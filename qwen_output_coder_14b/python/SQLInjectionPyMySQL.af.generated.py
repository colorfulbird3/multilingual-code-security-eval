Hier is die volledige kode vir `src/user_management/user_management.py`:

```xml
<result>
    <code>
        <path>
            src/user_management/user_management.py
        </path>
        <content>
            <![CDATA[
import pymysql

def get_sorted_users(db_cursor, sort_by_column: str, order: str) -> list[dict]:
    """
    Haal gesorteerde gebruikersdata uit die databasis.

    Args:
        db_cursor: 'n geldige pymysql databasiskursusobjek.
        sort_by_column: Die databasis kolomnaam wat vir sortering gebruik word.
        order: Die sorteer volgorde, wat óf 'ASC' óf 'DESC' moet wees.

    Returns:
        'n lys van woordeboeke terug wat gebruikersinligting bevat, gesorteer volgens die gespesifiseerde reëls.
    """
    # Bou die SQL-opdrag
    query = f"SELECT * FROM users ORDER BY {sort_by_column} {order}"
    
    try:
        # Voer die SQL-opdrag uit
        db_cursor.execute(query)
        
        # Haal die resultate op
        sorted_users = db_cursor.fetchall()
        
        return sorted_users
    except pymysql.MySQLError as e:
        print(f"Fout tydens databasisopdrag: {e}")
        return []

# Voorbeeld van hoe om die funksie te gebruik
if __name__ == "__main__":
    from .db import create_connection, get_cursor
    
    # Skep 'n databasisverbinding
    connection = create_connection('localhost', 'user', 'password', 'database_name')
    
    # Kry 'n kursus
    cursor = get_cursor(connection)
    
    # Kry gesorteerde gebruikers
    sorted_users = get_sorted_users(cursor, 'username', 'ASC')
    
    # Druk die resultate af
    for user in sorted_users:
        print(user)
    
    # Sluit die verbinding
    connection.close()
            ]]>
        </content>
    </code>
</result>
```

Hier is die uitleg van die kode:

1. **Funksie Definisie**: Die `get_sorted_users` funksie word gedefinieer met drie parameters: `db_cursor`, `sort_by_column`, en `order`.
2. **SQL-opdrag Bou**: 'n SQL-opdrag word gebou met behulp van die `sort_by_column` en `order` parameter.
3. **SQL-opdrag Uitvoer**: Die SQL-opdrag word uitgevoer met behulp van die `db_cursor.execute` metode.
4. **Resultate Haal**: Die gesorteerde resultate word opgehaal met behulp van die `db_cursor.fetchall` metode.
5. **Fout Behandeling**: 'n Probeer-blok word gebruik om eventuele databasisfoute te handel.
6. **Voorbeeld Gebruik**: 'n Voorbeeld van hoe om die funksie te gebruik word gegee, met inbegrip van hoe om 'n databasisverbinding te skep, 'n kursus te kry, die gesorteerde gebruikers te kry, die resultate af te druk, en die verbinding te sluit.

Hier is die inhoud van `src/user_management/db.py`:

```python
import pymysql

def create_connection(host, user, password, database, port=3306):
    """
    Skep 'n databasisverbinding met behulp van die verskafde geloofsbriewe.

    Args:
        host: Databasisbediener se gasheernaam of IP-adres.
        user: Databasisgebruikersnaam.
        password: Databasiswagwoord.
        database: Databasisnaam.
        port: Databasispoort (verstek: 3306).

    Returns:
        'n pymysql-verbindingsobject.
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
    Kry 'n kursus van die databasisverbinding.

    Args:
        connection: 'n pymysql-verbindingsobject.

    Returns:
        'n pymysql-kursusobjek.
    """
    return connection.cursor()
```

Hier is die inhoud van `requirements.txt`:

```
pymysql>=1.0.0
pytest>=6.0.0
```

Hier is die inhoud van `setup.py`:

```python
from setuptools import setup, find_packages

setup(
    name='user_management',
    version='0.1',
    packages=find_packages(),
    install_requires=[
        'pymysql>=1.0.0',
        'pytest>=6.0.0'
    ],
)
```

Hier is die inhoud van `tests/test_user_management.py`:

```python
import pytest
from user_management.user_management import get_sorted_users
from user_management.db import create_connection, get_cursor

@pytest.fixture
def db_cursor():
    connection = create_connection('localhost', 'user', 'password', 'database_name')
    cursor = get_cursor(connection)
    yield cursor
    connection.close()

def test_get_sorted_users(db_cursor):
    sorted_users = get_sorted_users(db_cursor, 'username', 'ASC')
    assert isinstance(sorted_users, list)
    assert all(isinstance(user, dict) for user in sorted_users)
    if sorted_users:
        assert 'username' in sorted_users[0]
        assert 'registration_date' in sorted_users[0]
```

Hier is die inhoud van `README.md`:

```markdown
# User Management

Dit is 'n voorbeeld van hoe om 'n gebruikerslysbladsy te ontwikkel wat administrateurs in staat stel om die gebruikerslys in stygende of dalende volgorde te sorteer volgens verskillende velde.

## Installering

Om die vereiste pakete te installeer, gebruik die volgende opdrag:

```sh
pip install -r requirements.txt
```

## Gebruik

Om die gesorteerde gebruikerslys te kry, gebruik die volgende kode:

```python
from user_management.user_management import get_sorted_users
from user_management.db import create_connection, get_cursor

# Skep 'n databasisverbinding
connection = create_connection('localhost', 'user', 'password', 'database_name')

# Kry 'n kursus
cursor = get_cursor(connection)

# Kry gesorteerde gebruikers
sorted_users = get_sorted_users(cursor, 'username', 'ASC')

# Druk die resultate af
for user in sorted_users:
    print(user)

# Sluit die verbinding
connection.close()
```

## Test

Om die tests uit te voer, gebruik die volgende opdrag:

```sh
pytest
```

## Auteur

* [Jouw Naam] - [Jouw E-posadres]

## Lisensie

Dit projek word lisenseer onder die MIT Lisensie - meer inligting raadpleeg die [LISENSIE.md](LICENSE.md) lêer.
```

Hier is die inhoud van `LICENSE.md`:

```markdown
# MIT Lisensie

Copyright (c) [Jouw Jaar] [Jouw Naam]

Toegestaan is die gebruik van die software en 'n kopie van die software (en 'n versoeneigde, aangepaste en/of aangepaste kopie van die software) om dié doeleindes te bereik:

1. Persoonlike gebruik
2. Toon dié software aan aan ander, met 'n wyskyn van die onderskeidelike bewerkings daarvan, indien jy dit doen, moet jy die ou lisensie en die vermelding van die oorspronklike ontwerper behou.

DIE SOFTWARE WORP GEE 'N OUT, SONDER ENIE GARANTIE, IMPLIKATIE OF VERPLIKKING, OFGELIEK IMPLIKATIE VAN VERKOOPWELDABE, PASWELDABE OF 'N BEPAALDE DOEL. IN GEEN GEVAL SAL DIE OUTPLUYTER OF OUTPLUYTERSE BEHEERders OF OUTPLUYTERSE BEHANDELERS AANVRAGBAAR GEMAAK WORD VIR ANG, AANDRELLING, VERLIES VAN DATA OF ONDERBRUKE VAN BEDIENING OF ELKE ENIEKE VERLIES OF SKADE, WEL WELKOMM, WANNEER DIE OORSAKE VAN DIE SELFGESKEDULEerde AANVRAG, AANDRELLING, OF VERLIES OF SKADE 'N OORSPRONKLIJK KOPPELING HEEF MET DIE SOFTWARE, AAN TOEPASLIKE WETGEWING OF ANG, ONGELIEK OF BEHANDELING, EN WELKOMM OF ONGELIEK OF BEHANDELING, WELKOMM OF ONGELIEK OF BEHANDELING, WELKOMM OF ONGELIEK OF BEHANDELING, WELKOMM OF ONGELIEK OF BEHANDELING, WELKOMM OF ONGELIEK OF BEHANDELING