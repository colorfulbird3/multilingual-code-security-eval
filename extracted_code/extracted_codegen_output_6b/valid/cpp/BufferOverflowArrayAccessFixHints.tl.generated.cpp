```python
import re
from typing import List, Dict, Any, Optional

class ImageLayerParser:
    """
    A parser for image layers in image processing pipelines.
    Handles parsing of layer definitions, transformations, and metadata.
    """
    
    def __init__(self):
        self.layers: List[Dict[str, Any]] = []
        self.current_layer: Optional[Dict[str, Any]] = None
        
    def parse_layer(self, layer_string: str) -> Dict[str, Any]:
        """
        Parse a single layer definition string into a structured dictionary.
        
        Args:
            layer_string: String representation of the layer
            
        Returns:
            Dictionary containing parsed layer information
        """
        layer_data = {
            'type': None,
            'name': None,
            'properties': {},
            'transformations': [],
            'blend_mode': 'normal',
            'opacity': 1.0,
            'visible': True
        }
        
        # Remove whitespace and split into lines
        lines = [line.strip() for line in layer_string.split('\n') if line.strip()]
        
        for line in lines:
            # Parse layer type and name
            if line.startswith('layer:'):
                parts = line[6:].strip().split()
                if parts:
                    layer_data['type'] = parts[0]
                    if len(parts) > 1:
                        layer_data['name'] = ' '.join(parts[1:])
            
            # Parse properties
            elif ':' in line and not line.startswith('#'):
                key, value = line.split(':', 1)
                key = key.strip().lower()
                value = value.strip()
                
                if key == 'opacity':
                    layer_data['opacity'] = float(value)
                elif key == 'blend':
                    layer_data['blend_mode'] = value
                elif key == 'visible':
                    layer_data['visible'] = value.lower() == 'true'
                else:
                    layer_data['properties'][key] = value
            
            # Parse transformations
            elif line.startswith('transform:'):
                transform_str = line[10:].strip()
                layer_data['transformations'].append(self._parse_transform(transform_str))
        
        return layer_data
    
    def _parse_transform(self, transform_string: str) -> Dict[str, Any]:
        """
        Parse a transformation string into a structured format.
        
        Args:
            transform_string: String like "rotate(45)" or "scale(2, 2)"
            
        Returns:
            Dictionary with transformation type and parameters
        """
        transform_pattern = r'(\w+)\(([^)]*)\)'
        match = re.match(transform_pattern, transform_string.strip())
        
        if match:
            transform_type = match.group(1).lower()
            params_str = match.group(2)
            params = [p.strip() for p in params_str.split(',') if p.strip()]
            
            # Convert numeric parameters
            numeric_params = []
            for p in params:
                try:
                    numeric_params.append(float(p))
                except ValueError:
                    numeric_params.append(p)
            
            return {
                'type': transform_type,
                'parameters': numeric_params
            }
        
        return {'type': 'unknown', 'parameters': []}
    
    def parse_multiple_layers(self, layer_strings: List[str]) -> List[Dict[str, Any]]:
        """
        Parse multiple layer definitions.
        
        Args:
            layer_strings: List of layer definition strings
            
        Returns:
            List of parsed layer dictionaries
        """
        return [self.parse_layer(ls) for ls in layer_strings]
    
    def get_layer_by_name(self, name: str) -> Optional[Dict[str, Any]]:
        """
        Find a layer by its name.
        
        Args:
            name: Name of the layer to find
            
        Returns:
            Layer dictionary if found, None otherwise
        """
        for layer in self.layers:
            if layer.get('name') == name:
                return layer
        return None
    
    def apply_transform(self, layer: Dict[str, Any], transform: Dict[str, Any]) -> Dict[str, Any]:
        """
        Apply a transformation to a layer.
        
        Args:
            layer: Layer dictionary
            transform: Transformation dictionary
            
        Returns:
            Updated layer dictionary
        """
        layer['transformations'].append(transform)
        return layer
    
    def to_string(self, layer: Dict[str, Any]) -> str:
        """
        Convert a parsed layer back to string format.
        
        Args:
            layer: Layer dictionary
            
        Returns:
            String representation of the layer
        """
        lines = []
        
        # Layer type and name
        type_str = f"layer: {layer['type']}"
        if layer['name']:
            type_str += f" {layer['name']}"
        lines.append(type_str)
        
        # Properties
        for key, value in layer['properties'].items():
            lines.append(f"{key}: {value}")
        
        # Special properties
        if layer['opacity'] != 1.0:
            lines.append(f"opacity: {layer['opacity']}")
        if layer['blend_mode'] != 'normal':
            lines.append(f"blend: {layer['blend_mode']}")
        if not layer['visible']:
            lines.append("visible: false")
        
        # Transformations
        for transform in layer['transformations']:
            params = ', '.join(str(p) for p in transform['parameters'])
            lines.append(f"transform: {transform['type']}({params})")
        
        return '\n'.join(lines)

# Example usage
if __name__ == "__main__":
    parser = ImageLayerParser()
    
    # Example layer string
    example_layer = """
    layer: image background
    opacity: 0.8
    blend: multiply
    transform: rotate(45)
    transform: scale(1.5, 1.5)
    """
    
    parsed = parser.parse_layer(example_layer)
    print("Parsed layer:", parsed)
    print("\nConverted back to string:")
    print(parser.to_string(parsed))
```