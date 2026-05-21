public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        String role = userService.findUserRoleByUsername("john_doe");
        if (role != null) {
            System.out.println("User role: " + role);
        } else {
            System.out.println("User not found or error occurred.");
        }
    }
}