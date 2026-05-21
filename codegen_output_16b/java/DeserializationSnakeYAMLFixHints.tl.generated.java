

## Examples

### Configuring the YAML Service
The following YAML content is configured to the `src/main/resources/yaml-service.yml` configuration file:

```yaml
service:
  yaml-service:
    repository: local
    yaml-content:
      - path: config.yml
        content:
          key: value
          another_key: another_value
          more_keys:
            - key1
            - key2
```

### Parsing the YAML content
The content in the `src/main/resources/yaml-service.yml` file has been parsed to the following Java object:

```java
{
    "repository": {
        "local": {
            "yaml-content": [
                {
                    "path": "config.yml",
                    "content": {
                        "key": "value",
                        "another_key": "another_value",
                        "more_keys": [
                            "key1",
                            "key2"
                        ]
                    }
                }
            ]
        }
    }
}
```

### Configuring the YAML Service using JSON format
The following YAML content is configured to the `src/main/resources/yaml-service.yml` configuration file using JSON format:

```json
{
    "service": {
        "yaml-service": {
            "repository": "local",
            "yaml-content": [
                {
                    "path": "config.yml",
                    "content": {
                        "key": "value",
                        "another_key": "another_value",
                        "more_keys": [
                            "key1",
                            "key2"
                        ]
                    }
                }
            ]
        }
    }
}
```

### Parsing the YAML content
The content in the `src/main/resources/yaml-service.yml` file has been parsed to the following Java object:

```java
{
    "repository": {
        "local": {
            "yaml-content": [
