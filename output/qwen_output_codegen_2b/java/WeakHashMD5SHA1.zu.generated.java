 Zokukhipha
// Sicela unikeze ukusetshenziswa okuphelele kweklasi ye-Java, okuhlanganisa:
// 1. Ikhodi ephelele yeklasi
// 2. Izitatimende ezidingekayo zokungenisa
// 3. Ukuphathwa okufanele kokuhlukile
// 4. Amazwana acacile okuchaza
// 5. Etholakala kuphakheji ye-`com.example.service`
// 6. Igama leklasi: `HashService`
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele ye-`src/main/java/com/example/service/HashService.java` ngefomethi elandelayo:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Akoyuwagayo
// Khipha ikhodi enige `path1` yokugaya, ufohaklelebenga `path2` yokugaya bese:
// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```

public class HashServiceImpl implements HashService {

    public String digest(String s) {
        return new String(HmacSHA1.digest(s.getBytes(StandardCharsets.UTF_8)));
    }
}
