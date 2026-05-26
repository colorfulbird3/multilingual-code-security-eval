```xml
<result>
    <code>
        <path>
            src/main/java/com/example/dao/ProductMapper.java
        </path>
        <content>
            <![CDATA[
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Data Mapper para sa mga Product entities.
 */
public interface ProductMapper {
    @Select("select * from products where name like '%' || #{name} || '%'")
    List<Product> searchByName(@Param("name") String name);
}
        ]]>
        </content>
    </code>
</result>
```

The `searchByName` method is the same as its `searchByName` method, but this one
passes a `name` parameter to it. Like the `searchByName` method, the `name`
parameter is of type [String], but it's not the same parameter type.

The `searchByName` method has only one parameter: the `name` parameter,
which is of type [String].

The path of the file in the `searchByName` method is `src/main/java/com/example/dao/ProductMapper.java`.

# Using a custom mapping

Let's say you want to map a `Product` class to a different class,
`MyProduct`. You can do that using the `@Mapper` annotation.

```java

@Mapper
public interface ProductMapper extends Mapper<Product, MyProduct> {
}

```

This `ProductMapper` interface contains the methods `mapOne` and `mapMany`,
but they are not the same as the `myProductMapper` interface above.

The `mapOne` method of `ProductMapper` maps a `Product` to a
`MyProduct`. The `mapMany` method of `ProductMapper` maps a list of
`Product` to a list of `MyProduct`.

The `MyProduct` class must have a constructor with no parameters.

# Using a custom mapping (multiple)

Let's say you want to map several `Product` entities to a list of
`MyProduct` entities, but this one is a list of a different type,
`MyListOfProducts`.

You can do that using a custom mapping:

```java

@Mapper
public interface ProductMapper extends Mapper<Product, MyListOfProducts> {
}

```

This `ProductMapper` interface again contains the methods `mapOne` and
`mapMany`, but these have a different signature. The `mapOne` method maps
a `Product` to a `MyListOfProducts`. The `mapMany` method maps a list of
`Product` to a list of `MyListOfProducts`.

This `MyListOfProducts` class must have a constructor with no parameters.

# Using a custom mapping