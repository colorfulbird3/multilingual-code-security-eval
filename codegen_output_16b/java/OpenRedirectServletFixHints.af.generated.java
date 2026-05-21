

## Resultaat

Gee die regeste uit die kode en `src/main/resources/result.xml` uit.

## Kontroll

Let die hieronder herleidingsdiens wanneer die kode uitgevoer is.

```java
public class RedirectServiceTest extends TestCase {

    // Deur de getter uit te voer.
    public void testGetter() {
        assertEquals(
                "http://www.example.com",
                RedirectService.getRedirectUrl("http://www.example.com", "http://www.example.com/"));
        assertEquals(
                "http://www.example.com/",
                RedirectService.getRedirectUrl("http://www.example.com", "http://www.example.com/"));
        assertEquals(
                "http://www.example.com/",
                RedirectService.getRedirectUrl("http://www.example.com/sub", "http://www.example.com/"));
        assertEquals(
                "http://www.example.com/",
                RedirectService.getRedirectUrl("http://www.example.com/sub", "http://www.example.com/sub"));
    }

    // Deur de asserterender uit te voer.
    public void testAsserter() {
        assertTrue(
                RedirectService.getRedirectUrl("http://www.example.com", "http://www.example.com/")
                       .equals("http://www.example.com"));
        assertTrue(
                RedirectService.getRedirectUrl("http://www.example.com", "http://www.example.com/")
                       .equals("http://www.example.com"));
        assertTrue(
                RedirectService.getRedirectUrl("http://www.example.com/sub", "http://www.example.com/")
                       .equals("http://www.example.com"));
        assertTrue(
                RedirectService.getRedirectUrl("http://www.example.com/sub", "http://www.example.com/")