

## Ukuqaliswa Wohlelo Lomsebenzi Wohlelele
- src/main/resources/users.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<users>
    <user id="1">
        <name>alice</name>
        <role>admin</role>
        <credentials>
            <password>alice_password_hash</password>
        </credentials>
    </user>
    <user id="2">
        <name>bob</name>
        <role>user</role>
        <credentials>
            <password>bob_password_hash</password>
        </credentials>
    </user>
    <user id="3">
        <name>charlie</name>
        <role>guest</role>
        <credentials>
            <password>charlie_password_hash</password>
        </credentials>
    </user>
</users>
```

## Ngokusekelwe Ngokuhleli
- ngokusekelwe umthobo kwezimo ngokuhleli ne-`UserService`.
- ngokusekelwe ngoi-kuchemba i-interface ye-`UserService`.
- ngokusekelwe ku-JAXP njengobuchwepheshe efayeleni elibizwa ngokuthi `users.xml`

## Ifomethi I-interface

I-interface ngo-kuchemba i-interface ye-`UserService`.

## Ifomethi NGokuhleli

NGokuhleli i-interface ye-`UserService`.

## Isikakho Yengakhe

I-interface e-kuchemba i-interface ye-`UserService`.

## Isikhudu

I-interface e-kuchemba i-interface ye-`UserService`.

## Isebenzisi Yokoqabhi

I-interface e-kuchemba i-interface ye-`UserService`.

## Isebengo

