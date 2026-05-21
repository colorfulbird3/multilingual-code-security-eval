

## Sample Output

Sample output sa sa paglalawang `src/main/java/com/example/dao/ProductMapper.java`:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        package com.example.dao;

        /**
         * Represents a product entity.
         */
        public class Product {
            private Integer id;
            private String name;
            private String description;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            @Override
            public String toString() {
                return "Product{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        '}';
            }
        }

        ]]>
        </content>
    </code>
</result>
```




