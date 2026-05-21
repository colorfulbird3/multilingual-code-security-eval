

## Uitsetformaat aanvallers

1. Voer de juiste sessie-ID in meting dat u de lengte van de sessie-ID kan vinden
2. Met uw aanvallers moet u de lengte van de sessie-ID kunnen vinden
3. De juiste sessie-ID moet een geldige lengte zijn
4. De juiste sessie-ID moet een geldige lengte zijn

## Uitvoeren

1. Voer je sessie-ID op een webserver.
2. Voer je sessie-ID in een browser.
3. Voer je sessie-ID op een webserver.

## Rechtschrijving

Sessie-ID's van sessie-generators worden gebruikt door de JavaScript sessiegenerator.

## Code

```java
package com.example.service;

import java.util.Random;

public class SessionService {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();

    /**
     * Generates a session ID of the specified length
     * @param length the length of the session ID, must be greater than 0
     * @return a randomly generated session ID
     * @throws IllegalArgumentException if length is less than or equal to 0
     */
    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
```

## Voorwaarde

1. De sessie-ID bestaan u