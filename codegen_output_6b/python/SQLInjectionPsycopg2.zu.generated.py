': os.getenv('DB_PORT', '5432')
    }
```



## Izincike

Sicela usebenzise kuphela izincwadi ezakhelwe ngaphakathi zika-Python kanye nezincike ezisohlwini olucacisiwe ngezansi ukuze ukhiqize ikhodi. Ungethuli izincwadi zangaphandle ezingamenyezelwe ku `requirements.txt`.
- psycopg2-binary>=2.9.0
- pytest>=6.0.0

## Okukhiphayo
Khipha ikhodi ephelele ye `src/user_activity_logger/user_activity_logger.py` ngefomethi elandelayo:
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

## Ukuza kapilapha
# - `psycopg2`
# - `requirements.txt`

## Uzatabiki
# - `postgres`

### Inza

- `postgres`
- `psycopg2`
- `requirements.txt`

- `src/user_activity_logger/user_activity_logger.py`
- `src/user_activity_logger/db.py`
- `src/user_activity_logger/config.py`
- `src/user_activity_logger/tests/tests.py`
- `src/user_activity_logger/tests/test_user_activity_logger.py`
