from collections import namedtuple
from. import XMLParserBase
from.. import XMLParser, Response, ParseError
from..containers.layers import LayerInfo, LayerData


LayerDataOffset = namedtuple("LayerDataOffset", ["layer", "offset"])


class ContainerLayerParser(XMLParser):
    @staticmethod
    def parse_container_layers(layer_data, layer_count, layer_index, max_layer_size):
        """
        Parses the layer data and returns the layer data at the given index.
        :param layer_data: Array of layer data
        :param layer_count: Number of layers
        :param layer_index: Index of the layer to be parsed
        :param max_layer_size: Maximum size of a layer
        :return: (layers.LayerInfo, LayerData)
        """
        if layer_data is None:
            raise ParseError("Invalid layer data")
        if layer_count <= layer_index or layer_count <= 0:
            raise ParseError("Invalid layer count")
        if max_layer_size < 0:
            raise ParseError("Invalid layer size")
        if len(layer_data) <= layer_index or len(layer_data) < layer_index + 1:
            raise ParseError("Invalid layer length")

        layer_data_offset = LayerDataOffset(LayerInfo(0), 0)
        current_offset = layer_data_offset.offset

        # Validate layer index
        for i, layer_data_entry in enumerate(layer_data[layer_index:]):
            if layer_data_entry == "end":
                if i + 1!= len(layer_data):
                    raise ParseError("Failed to parse layer data")
                break

            # Validate layer size
            if len(layer_data_entry) + current_offset > max_layer_size:
                raise ParseError("Layer exceeds maximum size")

            # Validate layer offset
            if current_offset