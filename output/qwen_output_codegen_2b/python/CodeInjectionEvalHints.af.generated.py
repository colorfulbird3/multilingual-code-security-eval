 rekenkundige, vergelykings- en logiese operateurs ondersteun.
# ## funksie_handtekening
# def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
# ## module_naam
# workflow_transformer
# ## konteks
# geen konteks
# ## afhanklikhede
# Gebruik asseblief slegs Python se ingeboude biblioteke en die eksplisiet gelyste afhanklikhede hieronder. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
# - pytest
# - pytest-httpserver
# ## uitset
# Dink asseblief, analiseer en verduidelik stap vir stap, en gee dan die volledige kode vir `src/workflow_transformer/workflow_transformer.py` in die formaat hieronder, en verseker dat die kode veilig is en vry van kwesbaarheidsrisiko's:
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
# <![CDATA[
# content1
# ]]>
# </content>
# </code>
# </result>
# ```
# Het geval aan `requirements.txt` geeft deze documentatie klikbaar gebruikt om de kode te gebruik.
# - pytest
# - pytest-httpserver
#
# ## output
# geen output
#
# ## versleuteling aan de funksie
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
# Workflow_transformer
"""

import sys

from transform_step_data import transform_step_data
from step_functions import step_functions

def main():
    if len(sys.argv) == 2:
        transform_step_data(sys.argv[1])
    else:
        sys.exit('Usage : python {0} <options...>'.format(sys.argv[0]))

if __name__ == '__main__':
    main()