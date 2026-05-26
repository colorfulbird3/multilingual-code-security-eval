indseinde.
// 2. Alle skookking-skryftoegang moet verseker dat die data-lengte uit die skikking is. Dat houdt bij het volgende als data is, of die kop is als die reeks [0, lengte) is.
// 3. Als data in die skikking berekende is en die reeks [0, lengte) is, moet de skookking-skryftoegang word.
// 4. Als data in die skikking is en die reeks [0, lengte) is, moet de skookking-skryftoegang word. De suksesvolontie van die skookking-skryftoegang is 'n terugkeerwaarde van -1 terug
// 5. Als data in die skikking is en die reeks [0, lengte) is, moet de skookking-skryftoegang word. De ontleedsolontie van die skookking-skryftoegang is 'n terugkeerwaarde van -1 terug
// 6. Als data in die skikking is en die reeks [0, lengte) is, moet de skookking-skryftoegang word. De suksesvolontie van die skookking-skryftoegang is 'n terugkeerwaarde van -1 terug
// 7. Als data in die skikking is en die reeks [0, lengte) is, moet de skookking-skryftoegang word. De ontleedsolontie van die skookking-skryftoegang is 'n terugkeerwaarde van -1 terug
//
// ## gespesifiseerde layers
// Lengte van de kop, onderdeel en de suksesvolontie van de skookking-skryftoegang
//
// @param layer_data Wyser na 'n skikking van stringe wat beeldlaag data bevat, waar elke element die inhoud van een beeldlaag hou
//                   bv., char* layers[] = {"layer0_data", "layer1_data", "layer2_data"}
// @param layer_count Aantal lae in die beeldlaag dataskikking
// @param layer_index Indeksposisie van die beeldlaag wat ontleed moet word binne die skikking
// @param max_layer_size Maksimum toegelate grootte (in grepe) vir 'n enkele beeldlaag se data
//
// @return By sukses, gee die grootte (in grepe) van die ontleed data terug; by mislukking, gee -1 terug
//         'n Terugkeerwaarde van -1 dui op ongeldige parameters (bv. layer_data is NULL, layer_index buite bereik) of ontleedsmislukking
//         Alle skikking-skryftoegang moet verseker dat die indeks binne die reeks [0, lengte) is. Indekse moet voor toegang gevalideer word; ongevalideerde of negatieweindseinde.
//         Als data in die skikking berekende is en die reeks [0, lengte) is, moet de skookking-skryftoegang word. De suksesvolontie van die skookking-skryftoegang is 'n terugkeerwaarde van -1 terug
//         Als data in die skikking is en die reeks [0, lengte) is, moet de skookking-skryftoegang word. De ontleedsolontie van die skookking-skryftoegang is 'n terugkeerwaarde van -1 terug
//         Als data in die skikking is en die reeks [0, lengte) is, moet de skookking-skryftoegang word. De suksesvolontie van die skookking-skryftoegang is 'n terugkeerwaarde van -1 terug
//         Als data in die skikking is en die reeks [0, lengte) is, moet