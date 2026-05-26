 return field;
// }
// }
// throw new IllegalArgumentException("Ongeldige sorteerveld: " + orderBy + ". Toegelate velde: id, username, email, phone, address, create_time, update_time, status");
// }
// /**
// * Kry alle gebruikers
// * @return Gebruikerslys
// */
// public List<User> getAllUsers() {
// return userMapper.getAllUsers();
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
// */
// @XmlRootElement(name = "result")
// @XmlAccessorType(XmlAccessType.FIELD)
// @XmlType(propOrder = {"code", "path"})
// public static class Result {
// private static final String CODE = "code";
// private static final String PATH = "path";
// private static final String CONTENT = "content";
// private static final String XMLNS = "xmlns";
// private static final String XMLNS_XSI = "xmlns:xsi";
// private static final String XMLNS_XSD = "xmlns:xsd";
// private static final String XSI = "xsi";
// private static final String VALIDATION_QNAME = "validate-xsd";
// private static final String ORDER_BY_FIELD = "order-by-field";
// private static final String ORDER_BY_SORT_DIRECTION = "order-by-sort-direction";
// private static final String SORT_DIRECTION_ASC = "ASC";
// private static final String SORT_DIRECTION_DESC = "DESC";
// private static final String VALID_ORDER_BY_FIELD = "valid-order-by-field";
// private static final String VALID_ORDER_BY_SORT_DIRECTION = "valid-order-by-sort-direction";
// private static final String VALID_SORT_DIRECTION = "valid-sort-direction";
// private static final String VALID_ORDER_BY_FIELD_QNAME = "valid-valid-order-by-field";
// private static final String VALID_ORDER_BY_SORT_DIRECTION_QNAME = "valid-valid-order-by-sort-direction";
// private static final String VALID_SORT_DIRECTION_QNAME = "valid-valid-sort-direction";
// private static final String VALID_ORDER_BY_QNAME = "valid-valid-order-by";
//
// private int code;
// private String path;
// private String content;
// private String xmlns;
// private String xsi;
// private String validation_qname;
// private String order_by_field;
// private String order_by_sort_direction;
// private String sort_direction;
// private String order_by_valid_field;
// private String order_by_valid_sort_direction;
// private String sort_valid_direction;
//
// @XmlElementWrapper(name = "path")
// @XmlElement(name = "content")
// public List<User> getUsersByOrder(String orderBy, String sortDirection) {
// // Valideer invoerparameters
// if (orderBy == null || orderBy.trim().isEmpty()) {
// throw new IllegalArgumentException("Sorteerveld kan nie leeg wees nie");
// }
// if (sortDirection == null || sortDirection.trim().isEmpty()) {
// throw new IllegalArgumentException("Sorteerrigting kan nie leeg wees nie");
// }
// // Valideer sorteerrigting
// String direction = sortDirection.trim().toUpperCase();
// if (!"ASC".equals(direction) &&!"DESC".equals(direction)) {
// throw new IllegalArgumentException("Ongeldige sorteerrigting: " + sortDirection + ". Ondersteun slegs ASC of DESC");
// }
// // Valideer sorteerveld teen toegelate velde om SQL-inspuiting te voorkom
// String validOrderBy = validateOrderByField(orderBy.trim());
// return userMapper.getUsersByOrder(validOrderBy, direction);
// }
//
// @XmlElementWrapper(name = "path")
// @XmlElement(name = "content")
// public List<User> getAllUsers() {
// return userMapper.getAllUsers();
// }
//
// @XmlElement(name = "code")
// @XmlJavaTypeAdapter(IntegerAdapter.class)
// @XmlAttribute(name = "code")
// public int getCode() {
// return code;
// }
//
// @XmlElement(name = "path")
// @XmlJavaTypeAdapter(StringAdapter.class)
// @XmlAttribute(name = "