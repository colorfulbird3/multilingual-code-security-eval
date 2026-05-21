UserService userService = new UserService();
String userRole = userService.findUserRoleByUsername("john_doe");
System.out.println("Role of john_doe: " + userRole);