configuration
        xmlns="http://mybatis.org/dtd/mybatis-3-config.dtd"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://mybatis.org/dtd/mybatis-3-config.dtd
        http://mybatis.org/dtd/mybatis-3-config.dtd"
        version="3.0">
    <package name="com.example.dao" />
</configuration>
```

- src/main/resources/mybatis-config.xml.mako
```
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration
  xmlns="http://mybatis.org/dtd/mybatis-3-config.dtd"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://mybatis.org/dtd/mybatis-3-config.dtd
  http://mybatis.org/dtd/mybatis-3-config.dtd"
  version="3.0">
  <package name="com.example.dao">
    <property name="parameterType" value="java.lang.String"/>
  </package>
</configuration>
```
