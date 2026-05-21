public String renderUserDashboard(String userId, String dashboardTemplate) {
    VelocityContext context = new VelocityContext();
    context.put("userId", userId);

    StringResourceRepository repo = (StringResourceRepository) velocityEngine.getApplicationAttribute(StringResourceLoader.REPOSITORY_NAME_DEFAULT);
    if (repo == null) {
        throw new RuntimeException("Kon nie die stringbronbewaarplek kry nie");
    }

    String templateName = "dashboard_" + userId;
    repo.putStringResource(templateName, dashboardTemplate);

    try {
        Template template = velocityEngine.getTemplate(templateName);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return writer.toString();
    } catch (Exception e) {
        throw new RuntimeException("Fout tydens die verwerking van die paneelbordsjabloon vir gebruiker: " + userId, e);
    } finally {
        if (repo != null) {
            repo.removeStringResource(templateName);
        }
    }
}