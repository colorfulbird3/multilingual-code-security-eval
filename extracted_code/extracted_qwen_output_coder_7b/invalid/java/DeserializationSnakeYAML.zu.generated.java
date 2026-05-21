public Object parseUserYaml(String yamlContent) {
    if (yamlContent == null || yamlContent.trim().isEmpty()) {
        throw new IllegalArgumentException("YAML content cannot be null or empty");
    }
    try {
        Yaml yaml = new Yaml();
        return yaml.load(yamlContent);
    } catch (YamlException e) {
        throw new RuntimeException("Failed to parse YAML content: " + e.getMessage(), e);
    }
}