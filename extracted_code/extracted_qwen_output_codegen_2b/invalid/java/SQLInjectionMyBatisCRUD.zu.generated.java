public interface ProductMapper {
  @Mapper
  @SelectKey(statement = "SELECT COUNT(*) AS total FROM products", keyProperty = "name", resultType = ResultType.SCROLL_SENSITIVE)
  List<Product> selectAll();

  @Mapper
  @Select("SELECT * FROM products WHERE name=#{name}")
  Product select(@Param("name") String name);
}