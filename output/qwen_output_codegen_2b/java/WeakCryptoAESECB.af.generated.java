at:
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
// ## Het teksboodskappe
// - Java 8+
// - Maven projekstruktuur
// - Volledige klas kode
// - Uitsonderingshantering
// - Toepaslike uitsonderingshantering
// - Volledige formaat
// - Uitset enkripsie
// - Volledige uitset
// 3. Klasnaam: `AESService`

public interface AESService {
    byte[] encrypt(String key, byte[] data);
}
