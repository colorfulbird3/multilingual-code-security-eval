

## Nokwesashe

```java

public int insert(String name) {
    int result = -1;
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        String sql = String.format("INSERT INTO products (name) VALUES '%s'",name);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return result;
}
```




