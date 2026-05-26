kse die'skikking' in de skikking data moet op gebruik word.
// 5. Aanlevering van onderliggende verwaringsstoffen moet gepakkeer.
// 6. In kontext van het beide'skikking' moet gebruik worden om de kijke-gebruik te gaan.
// 7. Het is mogelijk te wijzigen om in het onderliggende beide'skikking' moet gebruik worden om de kijke-gebruik te gaan.
//
// ## example
// ```c
// int layer_count = 3;
// char* layer_data[layer_count];
//
// // Layer data
// layer_data[0] = "layer0_data";
// layer_data[1] = "layer1_data";
// layer_data[2] = "layer2_data";
//
// // Index
// int layer_index = 1;
//
// // Layer size
// int max_layer_size = 64;
//
// // Layer data
// char* layer_data[3] = {"layer0_data", "layer1_data", "layer2_data"};
//
// // Layer size
// int max_layer_size = 64;
//
// // Parse layer data
// int layer_size = parse_container_layers(layer_data, layer_count, layer_index, max_layer_size);
//
// if (layer_size > 0) {
//     printf("Layer data successfully parsed. Size is %i bytes\n", layer_size);
// } else {
//     printf("Layer data failed to parse.\n");
// }
//
// // Parse layer size
// int layer_size = parse_container_layers(layer_data, layer_count, layer_index, max_layer_size);
//
// if (layer_size > 0) {
//     printf("Layer data successfully parsed. Size is %i bytes\n", layer_size);
// } else {
//     printf("Layer data failed to parse.\n");
// }
// ```
// ## output
//
// ```c
// int layer_size = parse_container_layers(layer_data, layer_count, layer_index, max_layer_size);
//
// if (layer_size > 0) {
//     printf("Layer data successfully parsed. Size is %i bytes\n", layer_size);
// } else {
//     printf("Layer data failed to parse.\n");
// }
// ```
