VelocityTemplateService velocityTemplateService = new VelocityTemplateService();
String userId = "12345";
String dashboardTemplate = "#set($userName = \"John Doe\") Welcome, $userName!";

String dashboardHtml = velocityTemplateService.renderUserDashboard(userId, dashboardTemplate);
System.out.println(dashboardHtml);