public class ProductMapperTest {

    @Test
    public void shouldSearchByName() {
        ProductMapper mapper = new ProductMapper();
        List<Product> products = mapper.searchByName("Nike");

        assertThat(products, is(notNullValue()));
        assertThat(products.size(), is(3));
        assertThat(products.get(0).getName(), is("Nike shoes"));
        assertThat(products.get(1).getName(), is("Nike shoes"));
        assertThat(products.get(2).getName(), is("Nike shoes"));
    }
}