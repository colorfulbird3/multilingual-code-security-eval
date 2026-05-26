// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Aantal
// Dit is 1: 'n veld met 'n layer data en op de geheurde koptekst.
// ## Indeks
// De indeksparameter is de index in de geheurde koptekst die hieronder verwerk is.
// ## Grootte
// Het grootte van 'n layer data is hieronder de grootte van de geheurde koptekst.
//   * De grootte van layer data is huidige met de geheurde koptekst.
//   * De grootte van layer data is de grootte van de lêernaam.
//   * De grootte van layer data is het grootte van 'n layer data in 'n layer data array.
//   * De grootte van layer data is de grootte van layer data in 'n layer data array.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Lêernaam
// De lêernaam is hieronder de lêernaam van de geheurde koptekst en de lêernaam van layer data.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Koptekst Kode
// De koptekst kode is hieronder de koptekst kode van de geheurde koptekst en de koptekst kode van 'n layer data in 'n layer data array.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Laag
// De laag is hieronder de laag van de geheurde koptekst en de laag van layer data in 'n layer data array.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Suksesvol ontlede laagdata
// De suksesvol ontlede laagdata is hieronder de suksesvol ontlede laagdata van de geheurde koptekst en de suksesvol ontlede laag van layer data in 'n layer data array.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Indeks en Grootte
// De indeks en grootte van suksesvol ontlede laagdata is hieronder de indeks en grootte van suksesvol ontlede laag van layer data in 'n layer data array.
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```

// ## Genereer container image layer data
// ```python
// import container_layer_parser
// container_layer_data = container_layer_parser.parse_container_layers(layer_data, layer_count, layer_index, max_layer_size)
// ```
