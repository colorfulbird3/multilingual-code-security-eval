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
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Insert("INSERT INTO products (name) VALUES (#{name})")
    int insert(Product product);

    @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
    int update(Product product);

    @Delete("DELETE FROM products WHERE name = #{name}")
    int delete(@Param("name") String name);

    @Select("select * from products where name = #{name}")
    List<Product> select(@Param("name") String name);
}
            ]]>
        </content>
    </code>
</result>
```

`parse`

Parses the XML content.

```xml
<code>
    <parse>
        <!-- parse a file -->
        <path>
            src/main/java/com/example/dao/ProductMapper.java
        </path>
        <content>
            <![CDATA[
package com.example.dao;

import com.example.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Insert("INSERT INTO products (name) VALUES (#{name})")
    int insert(Product product);

    @Update("UPDATE products SET name = #{name} WHERE id = #{id}")
    int update(Product product);

    @Delete("DELETE FROM products WHERE name = #{name}")
    int delete(@Param("name") String name);

    @Select("select * from products where name = #{name}")
    List<Product> select(@Param("name") String name);
}
            ]]>
        </content>
    </code>
</parse>
```
"""

import re
import xml.etree.ElementTree as ET

from zope.interface import implementer

from pyramid.exceptions import ConfigurationError
from pyramid.registry import Registry
from pyramid.threadlocal import get_current_request
from pyramid.util import get_current_registry

import zope.interface

from.interfaces import IReadableContent, IWritableContent

__all__ = [
    'parse',
    'parse_xml',
]


def parse(content, registry=None):
    """ Parse XML content
    """
    if isinstance(content, basestring):
        content = content.encode('utf-8')
    if registry is None:
        registry = get_current_registry()
    if registry is None:
        raise ConfigurationError("Registry instance for XML content not found")

    if not isinstance(registry, Registry):
        raise TypeError("Registry instance for XML content not found")

    read_content = IReadableContent(content