Connection connection = connectToDatabase(
    "jdbc:mysql://localhost:3306/mydatabase",
    "user",
    "password"
);

Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

while (resultSet.next()) {
    System.out.println("Row: " + resultSet.getString("field1"));
}

connection.close();