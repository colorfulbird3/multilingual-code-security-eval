 deur die gebruiker ingedien is
     * @return Die ontlede objek
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.trim().isEmpty()) {
            throw new IllegalArgumentException("YAML-inhoud kan nie leeg wees nie");
        }
        
        try {
            return yaml.load(yamlContent);
        } catch (Exception e) {
            throw new RuntimeException("YAML-ontleding het misluk: " + e.getMessage(), e);
        }
    }
    
    /**
     * Kry die YAML-ontlederinstansie
     * 
     * @return Yaml-instansie
     */
    public Yaml getYaml() {
        return yaml;
    }
}
```
        ]]>
        </content>
    </code>
</result>
```
 */
public class YAMLService {

    /**
     * Ontleed gebruikers-ingediende YAML-string
     * 
     * @param yamlContent YAML-inhoudstring wat deur die gebruiker ingedien is
     * @return Die ontlede objek
     */
    public Object parseUserYaml(String yamlContent) {
        if (yamlContent == null || yamlContent.trim().isEmpty()) {
            throw new IllegalArgumentException("YAML-inhoud kan nie leeg wees nie");
        }
        
        try {
            return yaml.load(yamlContent);
        } catch (Exception e) {
            throw new RuntimeException("YAML-ontleding het misluk: " + e.getMessage(), e);
        }
    }

    private final Yaml yaml = new Yaml();
}
