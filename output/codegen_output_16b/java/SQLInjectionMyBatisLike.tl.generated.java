```
 */
public interface ProduktMapper {
    /**
     * @param productName
     * @return
     */
    @Select("SELECT * FROM products WHERE name = #{productName}")
    Product getProduct(@Param("productName") String productName);

    /**
     * @param product
     */
    @Select("SELECT * FROM products WHERE name = #{product.name}")
    void updateProduct(@Param("product") Product product);
}
