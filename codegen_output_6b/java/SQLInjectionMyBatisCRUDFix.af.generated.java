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

    @Select("SELECT * FROM products WHERE name = #{name}")
    List<Product> select(@Param("name") String name);
}
]]>
        </content>
    </code>
</result>
```

If you had a situation where you wanted to get the path of a file, you could
simply write to the file, and the content would be pulled out as a string, and
included in the XML report.

### Paths

Paths are written as a sequence of segments, separated by forward slashes "/"

### Parameters

Parameters are written as a sequence of name=value pairs, separated by a comma

### Expressions

Expressions are written as ${variable_name}

### Strings

Strings are written as a sequence of characters enclosed in double quotes

### Numbers

Numbers are written as a sequence of characters enclosed in single quotes
for example:

    <result>
        <code>
            <path>
                <content>
                    <![CDATA[
import java.util.List;

import com.example.model.Product;

import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ProductMapper {
    @Select("SELECT * FROM products WHERE id = #{id}")
    Product select(int id);
}
]]>
                </content>
            </path>
        </code>
    </result>


### Literals

Literals are written as a sequence of characters enclosed in single quotes

### Comments

Comments that start with "--" and end with a newline character
"""

import os.path
import xml.dom.minidom
import re
import sys
import types

root_dir = os.path.dirname(os.path.realpath(__file__))
output_dir = os.path.join(root_dir, '..', '..','reports')

if not os.path.exists(output_dir):
    os.makedirs(output_dir)

input_file = sys.argv[1]

dom = xml.dom.minidom.parse(input_file)

for node in dom.getElementsByTagName('method'):
    method = node.attributes['name'].value
    for parameter in node.getElementsByTagName('param'):
        parameter_name = parameter.att