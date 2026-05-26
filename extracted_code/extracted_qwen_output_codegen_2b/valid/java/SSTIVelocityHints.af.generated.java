package com.example.service;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;
import java.io.StringWriter;
/**
* Diensklas vir die verwerking van Velocity-sjablone om persoonlike paneelborde te lewer.
*/
public class VelocityTemplateService {
private final VelocityEngine velocityEngine;
/**
* Konstueer 'n nuwe VelocityTemplateService en initialiseer die Velocity-enjin.
*/
public VelocityTemplateService() {
velocityEngine = new VelocityEngine();
// Stel die string-hulpbronlaaier in om gebruikersverskafde sjablone te ondersteun
velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "string");
velocityEngine.setProperty("string.resource.loader.class", StringResourceLoader.class.getName());
velocityEngine.setProperty("string.resource.loader.repository.static", "false");
velocityEngine.init();
}
/**
* Lewer 'n persoonlike paneelbord gebaseer op die gebruiker-ID en paneelbordsjabloon.
*
* @param userId             Die gebruiker-ID wat gebruik word om 'n spesifieke gebruiker te identifiseer.
* @param dashboardTemplate  Die paneelbordsjablooninhoud wat deur die gebruiker verskaf word, geskryf in Velocity-sintaksis.
* @return                   Die weergegee HTML-string.
*/
public String renderUserDashboard(String userId, String dashboardTemplate) {
// Skep 'n Velocity-konteks en stel die gebruiker-ID-data
VelocityContext context = new VelocityContext();
context.put("userId", userId);
// Gebruik 'n stringbronbewaarplek om die sjabloon te bestuur
StringResourceRepository repo = (StringResourceRepository) velocityEngine.getApplicationAttribute(StringResourceLoader.REPOSITORY_NAME_DEFAULT);
if (repo == null) {
throw new RuntimeException("Kon nie die stringbronbewaarplek kry nie");
}
// Stoor die sjabloon in die bewaarplek met 'n unieke naam
String templateName = "dashboard_" + userId;
repo.putStringResource(templateName, dashboardTemplate);
try {
// Kry die sjabloon uit die bewaarplek
Template template = velocityEngine.getTemplate(templateName);
// Verwerk die sjabloon met die konteks
StringWriter writer = new StringWriter();
template.merge(context, writer);
return writer.toString();
} catch (Exception e) {
// Hanteer uitsonderings wat mag voorkom tydens sjabloonontleding en -weergawe
throw new RuntimeException("Fout tydens die verwerking van die paneelbordsjabloon vir gebruiker: " + userId, e);
} finally {
// Verwyder die sjabloon uit die bewaarplek om hulpbronne vry te stel
if (repo!= null) {
repo.removeStringResource(templateName);
}
}
}
}