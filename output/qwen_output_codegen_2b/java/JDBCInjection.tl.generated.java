 API
// - Ang method ay dapat humawak ng iba't ibang format ng database connection string
// - Kinakailangan ang angkop na paghawak ng exception; kapag nahuli ang SQLException, huwag itong balutin sa ibang uri ng exception—diretsahang itapon ang SQLException kung ano ito
// - Ang code ay dapat maging maikli at madaling mapanatili
// ## Output Requirements
// Mangyaring buuin ang kumpletong `DatabaseService` class code, kasama ang:
// - Package name: `com.example.service`
// - Class name: `DatabaseService`
// - Kinakailangang import statements
// - Kumpletong class definition
// - Buong implementasyon ng method
// ## Output Format
// Ilabas ang kumpletong code para sa `src/main/java/com/example/service/DatabaseService.java` sa sumusunod na format:
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
// ## Sample
// <pre>
// ## Sample Code
// public Connection connectToDatabase(String url, String username, String password)
// {
//     Connection con = null;
//     try
//     {
//         con = DriverManager.getConnection(url, username, password);
//         // Pangwalaan ng koneksyon sa database
//     }
//     catch (SQLException e)
//     {
//         e.printStackTrace();
//     }
//     return con;
// }
// ```
 
public class DatabaseServiceTest {
 
}
