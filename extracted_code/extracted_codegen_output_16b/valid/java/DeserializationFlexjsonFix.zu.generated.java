```java
public class ConfigService {
    private String config;
    
    public String getConfig() {
        return config;
    }
    
    public void setConfig(String config) {
        this.config = config;
    }
    
    public String loadConfig() {
        return config;
    }
    
    @Override
    public String toString() {
        return "ConfigService{config='" + config + "'}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigService that = (ConfigService) o;
        return Objects.equals(config, that.config);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(config);
    }
    
    public int compareTo(ConfigService other) {
        return this.config.compareTo(other.config);
    }
    
    private Object writeReplace() throws ObjectStreamException {
        return this;
    }
    
    private Object readResolve() throws ObjectStreamException {
        return this;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```