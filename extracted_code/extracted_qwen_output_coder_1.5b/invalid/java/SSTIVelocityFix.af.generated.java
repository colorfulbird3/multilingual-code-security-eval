public String renderUserDashboard(String userId, String dashboardTemplate) {
    // Initialiseer Velocity-enjin eenmalig om prestasie te optimaliseer
    VelocityEngine velocityEngine = new VelocityEngine();
    velocityEngine.init();

    // Skep 'n konteks vir die sjabloon
    VelocityContext context = new VelocityContext();
    context.put("userId", userId);

    // Laai die sjabloon uit die verskafde string
    StringWriter writer = new StringWriter();
    try {
        velocityEngine.evaluate(context, writer, "dashboardTemplate", dashboardTemplate);
    } catch (Exception e) {
        // Hanteer foute tydens sjabloonverwerking
        e.printStackTrace();
        return "<html><body><h1>Fout: Kan nie kontrolebord laai nie</h1></body></html>";
    }

    // Gee die vertoonde HTML terug
    return writer.toString();
}