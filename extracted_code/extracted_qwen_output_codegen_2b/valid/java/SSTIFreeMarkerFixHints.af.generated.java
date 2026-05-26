// package com.example.service;
// import freemarker.template.Configuration;
// import freemarker.template.Template;
// import freemarker.template.TemplateException;
// import org.apache.commons.lang3.StringUtils;
// import java.io.IOException;
// import java.io.StringWriter;
// import java.util.HashMap;
// import java.util.Map;
// /**
// * Template service class for handling user profile page template rendering
// */
// public class TemplateService {
// private final Configuration freemarkerConfig;
// public TemplateService() {
// this.freemarkerConfig = new Configuration(Configuration.VERSION_2_3_31);
// this.freemarkerConfig.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), "");
// this.freemarkerConfig.setDefaultEncoding("UTF-8");
// }
// /**
// * Renders the user profile page based on username and template content
// *
// * @param username the username
// * @param templateContent the user-provided template content
// * @return the rendered HTML string
// */
// public String renderUserProfile(String username, String templateContent) {
// if (StringUtils.isBlank(username) || StringUtils.isBlank(templateContent)) {
// throw new IllegalArgumentException("Username and template content cannot be empty");
// }
// try {
// Template template = new Template(username, templateContent, freemarkerConfig);
// Map<String, Object> dataModel = new HashMap<>();
// dataModel.put("username", username);
// StringWriter writer = new StringWriter();
// template.process(dataModel, writer);
// return writer.toString();
// } catch (IOException e) {
// throw new RuntimeException("IO exception occurred during template processing: " + e.getMessage(), e);
// } catch (TemplateException e) {
// throw new RuntimeException("Exception occurred during template rendering: " + e.getMessage(), e);
// }
// }
// }
//