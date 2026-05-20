public Object parseUserYaml(String yamlContent) {
    try {
        Yaml yaml = new Yaml();
        return yaml.load(yamlContent);
    } catch (YamlException e) {
        throw new IllegalArgumentException("Invalid YAML content provided", e);
    }
}