// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// </result>
// ```

public class YamlService {
    private final Yaml yaml;

    public YamlService() {
        this.yaml = new Yaml();
    }

    /**
     * Ihlaziya iyunithi yezinhlamvu ye-YAML ethunyelwe ngumsebenzisi
     *
     * @param yamlContent Okuqukethwe kweyunithi yezinhlamvu ye-YAML okuthunyelwe ngumsebenzisi
     * @return Into ehlaziyiwe
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Okuqukethwe kwe-YAML akumele kube kungenalutho");
        }
        try {
            return yaml.load(yamlContent);
        } catch (Exception e) {
            throw new RuntimeException("Ukuhlaziya i-YAML kwehlulekile: " + e.getMessage(), e);
        }
    }

    /**
     * Ithola isibonelo somhlaziyi we-YAML
     *
     * @return Isibonelo se-Yaml
     */
    public Yaml getYaml() {
        return yaml;
    }
}
