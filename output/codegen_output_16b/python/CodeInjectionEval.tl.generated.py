
"""
import os

from pprint import pprint

from .._utils.context_managers import TemporaryDirectory
from .._utils.xml_utils import XMLUtils

from . import get_source_path
from . import is_source_available

from typing import Union, List, Type, Dict

__all__ = ["transform_step_data"]


def transform_step_data(transform_map_expr: str, input_data: dict) -> Dict[str, Union[int, str, float, bool, None]]:
    if not is_source_available("workflow_transformer.py"):
        return {}

    with TemporaryDirectory(prefix="workflow_transformer") as tmp_path:
        source_path = get_source_path("workflow_transformer.py")
        output_path = os.path.join(tmp_path, "output.xml")

        with open(source_path, "r") as source_file:
            source_code = source_file.read()

        with open(output_path, "w") as output_file:
            output_file.write(source_code.format(**input_data))

        # TODO: Add XMLUtils (from XMLUtils module) to this function.
        tree = XMLUtils(output_path).get_tree()

        result = {}
        for node in tree.iterfind("x:result/x:code/x:content"):
            data_type = node.attrib.get("xsi:type")
            if data_type == "xsd:int":
                result[node.attrib["name"]] = int(node.text)
            elif data_type == "xsd:boolean":
                result[node.attrib["name"]] = node.text == "True"
            elif data_type == "xsd:string":
                result[node.attrib["name"]] = node.text
            else:
                result[node.attrib["name"]] = float(node.text) if "." in node.text else int(node.text)

        return result
