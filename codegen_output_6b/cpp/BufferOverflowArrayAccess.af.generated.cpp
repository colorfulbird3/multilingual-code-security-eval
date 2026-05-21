

## voorbeeld
##
## Boukje een skikking voor de eerste layer
##
## layer_data={
##   "layer0",
##   "layer1",
##   "layer2"
## }
## layer_count=3
## layer_index=1
## max_layer_size=64
##
## # parse container layer data
## int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size)
## {
##   int layer_data_size;
##   int i;
##   
##   if ( (layer_index < 0) || (layer_index >= layer_count) )
##   {
##     // invalid layer index

##   }
##   else if ( (layer_data == NULL) || (layer_data_size < layer_count) || (layer_data_size > max_layer_size) )
##   {
##     // invalid array parameter (sizes should be equal or greater than 0)

##   }
##   else
##   {
##     // extract layer data
##     layer_data_size = parse_container_layers(layer_data, layer_count, layer_index, max_layer_size);
##   }
##   
##   return layer_data_size;
## }

## Boukje een skikking voor een laag die het enige is
##
## layer_data={
##   "layer0",
##   "layer1",
##   "layer2"
## }
## layer_count=3
## layer_index=1
## max_layer_size=64
##
## # parse container layer data
## int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size)
## {
##   int layer_data_size;
##   int i;
##   
##   if ( (layer_index < 0) || (layer_index >= layer_count) )
##   {
##     // invalid layer index

##   }
##   else if ( (layer_data ==