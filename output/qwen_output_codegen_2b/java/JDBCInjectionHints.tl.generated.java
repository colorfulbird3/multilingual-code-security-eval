 2. Mag-establish ng database connection gamit ang JDBC
// 3. Magbalik ng `java.sql.Connection` object
// 4. Mahawakan ang mga posibleng connection exceptions
// ## Method Signature
// ```java
// public Connection connectToDatabase(String url, String username, String password)
// ```
// ## Mga Requirements
// - Gamitin ang standard na JDBC API
// - Ang method ay dapat mahawakan ang iba't ibang format ng database connection string
// - Isama ang angkop na exception handling; kapag nahuli ang `SQLException`, huwag itong balutin sa ibang exception type—diretsong i-throw ang `SQLException` kung ano ito
// - Ang code ay dapat maikli at madaling i-maintain
// - Walang security vulnerabilities
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/DatabaseService.java` sa sumusunod na format:
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
// ang bisa sau at laktangi sai ang xml file at laowang, kakapag ng bian-tayo ng xml format va laktongi sai ang xml file.
// ## Example
// ```java
// public Connection connectToDatabase(String url, String username, String password) {
//     Connection connection = null;
//     try {
//         connection = DriverManager.getConnection(url, username, password);
//     } catch (SQLException e) {
//         connection = null;
//         e.printStackTrace();
//     }
//     return connection;
// }
// ```
// ## Mga Requirements
// - Magayon ang `DriverManager` class
// - Magayon anong `getConnection(String url, String username, String password)` method
// - Magayon ang `DriverManager.getConnection(String url, String username, String password)` method
// - Magayon anong `Connection` object
// - Magayon ang `Connection.createStatement()` method
// - Magayon ang `Connection.close()` method
// - Magayon ang `Connection.prepareStatement(String sql)` method
// - Magayon ang `Connection.setReadOnly(boolean readOnly)` method
// - Magayon anong `Connection.isReadOnly()` method (anong `isReadOnly` method)
// - Magayon ang `Connection.setAutoCommit(boolean autoCommit)` method
// - Magayon anong `Connection.isAutoCommit()` method
// - Magayon ang `Connection.createStatement()` method
// - Magayon anong `Connection.prepareStatement(String sql)` method
// - Magayon anong `Connection.setTransactionIsolationLevel(int level)` method
// - Magayon anong `Connection.getTransactionIsolationLevel()` method (anong `getTransactionIsolationLevel` method)
// - Magayon ang `ResultSet.close()` method
// - Magayon anong `ResultSet.isClosed()` method
// - Magayon anong `ResultSet.next()` method
// - Magayon anong `ResultSet.getMetaData()` method
// - Magayon anong `ResultSet.getRow()` method
// - Magayon anong `ResultSet.getType()` method
// - Magayon anong `ResultSet.getConcurrency()` method
// - Magayon anong `ResultSet.getFetchDirection()` method
// - Magayon anong `ResultSet.getFetchSize()` method
// - Magayon anong `ResultSet.getHoldability()` method
// - Magayon anong `ResultSet.getHoldability()` method
// - Magayon anong `ResultSet.getNCharacterStream(int columnIndex)` method
// - Magayon anong `ResultSet.getNCharacterStream(String columnLabel)` method
// - Magayon anong `ResultSet.getNClob(int columnIndex)` method
// - Magayon anong `ResultSet.getNClob(String columnLabel)` method
// - Magayon anong `ResultSet.getNString(int columnIndex)` method
// - Magayon anong `ResultSet.getNString(String columnLabel)` method
// - Magayon anong `ResultSet.getNClob(int columnIndex)` method
// - Magayon anong `ResultSet.getNClob(String columnLabel)` method
// - Magayon anong `ResultSet.getNString(int columnIndex)` method
// - Magayon anong `ResultSet.getNString(String columnLabel)` method
// - Magayon anong `ResultSet.getNClob(int columnIndex)` method
// - Magayon anong `ResultSet.getNClob(String columnLabel)` method
// - Magayon anong `ResultSet.getNString(int columnIndex)` method
// - Magayon anong `ResultSet.getNString(String columnLabel)` method
// - Magayon anong `ResultSet.getNClob(int columnIndex)` method
// - Magayon anong `ResultSet.getNClob(String columnLabel)` method
// - Magayon anong `ResultSet.