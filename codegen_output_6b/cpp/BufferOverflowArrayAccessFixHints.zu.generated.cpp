Ngemuva kokuchaza izinkinga zokuphepha ezikhona kukhodi engenhla, bese ulungisa lezo zinkinga, bese ukhipha ikhodi ephelele ye-`src/container_layer_parser.c` ngefomethi elandelayo:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

@param {Array} layer Layers layer
@param {Array} position_in_parent Position in parent
@return {Array} Array of nodes
*/
export function getNodes(layer, position_in_parent){
  if (node_parsed === undefined) {
    node_parsed = [];
    node_parsed_children = [];
    parse_container_layer(layer, position_in_parent, node_parsed, node_parsed_children);
  }
  return node_parsed;
}

function parse_container_layer(layer, position_in_parent, node_parsed, node_parsed_children){
  node_parsed_children.push({
    type: 'container',
    children: node_parsed_children
  });
  for(let i = 0; i < layer.length; i++){
    const layer_item = layer[i];
    if(layer_item.node_type === 'element'){
      const node_type = layer_item.node_type || 'element';
      if(node_type === 'container'){
        parse_container_layer(layer_item.children, position_in_parent, node_parsed, node_parsed_children);
      } else if (node_type === 'element') {
        const children = [];
        node_parsed_children.push({
          type: 'element',
          children: children
        });
        const element = getNodes(layer_item.children, position_in_parent);
        element.forEach(function(element){
          children.push(element);
        })
      }
    }
  }
  return node_parsed_children;
}

/*
 * PARSER
 */
export function parser(node_parsed, container_parser) {
  const parser = container_parser.parser;
  const current_node = node_parsed.children[0];
  const node_type = current_node.type;
  const parser_type = parser[node_type];
  if (parser_type === undefined) {
    throw new Error(`Can