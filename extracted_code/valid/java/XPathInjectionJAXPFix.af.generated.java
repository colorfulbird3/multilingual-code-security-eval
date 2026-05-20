UserService userService = new UserService();
String role = userService.findUserRoleByUsername("john_doe");
System.out.println("Role: " + role);