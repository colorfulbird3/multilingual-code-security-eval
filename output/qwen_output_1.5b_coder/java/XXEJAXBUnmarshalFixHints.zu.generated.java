        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
```

- src/main/resources/data/userProfile.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<userProfile>
    <name>Sebenzisa Umsebenzi</name>
    <email>sebenzisa@example.com</email>
    <userId>123456789</userId>
</userProfile>
```

## Ukomqenye

Ukomqenye i-jAXB ikebuziswa kubambiswano bangaphandle futhi siwaguqule abe izinto zangaphakathi ze-`UserProfile` sisebenzisa i-JAXB. Nokho, ithimba lokuhlola ukuphepha lisazise ukuthi ikhodi iqukethe ubungozi be-XXE.