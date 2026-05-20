public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        String username = "john_doe";
        String role = userService.findUserRoleByUsername(username);
        System.out.println("Role of " + username + ": " + role);
    }
}