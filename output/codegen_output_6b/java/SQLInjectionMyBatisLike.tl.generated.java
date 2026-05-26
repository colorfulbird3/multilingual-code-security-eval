    List<Product> searchByName(@Param("name") String name);
}
            ]]>
        </content>
    </code>
</result>
```
    */
    @Test
    public void jdbcTemplateTest() {
        final String name = "A";
        final int id = 10;
        jdbcTemplate.query("SELECT ID, NAME FROM PRODUCT WHERE NAME LIKE?", new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        }, name);
    }

    @Test
    public void jdbcTemplateTest2() {
        final String name = "A";
        final int id = 10;
        jdbcTemplate.query("SELECT ID, NAME FROM PRODUCT WHERE NAME LIKE?", new Object[] {name}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        });
    }
}
