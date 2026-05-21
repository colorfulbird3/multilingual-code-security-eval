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

public interface ProductMapper {

    /**
     * Voer 'n wasige soektog uit gebaseer op die produknaam
     * @param name Die produknaam om na te soek
     * @return Lys van ooreenstemmende produkte
     */
    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Product> searchByName(@Param("name") String name);
}
            ]]>
        </content>
    </code>
</result>
```
	 */
	public static class MapperFactory extends MapperFactory<ProductMapper> {

		public MapperFactory() {
			super(ProductMapper.class);
		}

		@Override
		public ProductMapper createMapper(Connection connection, String databaseName) {
			return new ProductMapper(connection, databaseName);
		}

	}

	public static class Mapper implements ProductMapper {

		private final Connection connection;
		private final String databaseName;

		public Mapper(Connection connection, String databaseName) {
			this.connection = connection;
			this.databaseName = databaseName;
		}

		@Override
		public List<Product> searchByName(String name) {
			try {
				return jdbcTemplate.query("SELECT * FROM " + databaseName + ".products WHERE name LIKE CONCAT('%', #{name}, '%')", new ProductRowMapper(), name);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}
}
