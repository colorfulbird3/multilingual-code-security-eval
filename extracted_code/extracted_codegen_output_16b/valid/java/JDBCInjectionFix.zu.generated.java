public class DatabaseService {
    static {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load database driver: " + e.getMessage());
        }
    }

    public void run() {
        //...
        DatabaseService svc = new DatabaseService();
        Connection conn = svc.connectToDatabase("jdbc:mysql://localhost/MyDB", "myUserName", "myPassword");
        //...
    }
}