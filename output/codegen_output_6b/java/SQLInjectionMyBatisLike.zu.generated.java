
 *
 * @author yokwenza
 * @see <a href="http://blog.izmerezi.com/2014/11/14/mybatis-example-xml-using-java-mapper-api/">blog.izmerezi.com</a>
 */
public class ExampleCode {

    public static void main(String[] args) {

        Product product = new Product();
        product.setId(1);
        product.setName("Lomkhiqizo");
        product.setPrice(12.99);

        ProductMapper productMapper = new ProductMapper();
        try {
            List<Product> list = productMapper.searchByName("Java");
            System.out.println(list.get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
