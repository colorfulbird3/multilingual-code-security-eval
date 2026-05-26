e
# Gebruik asseblief slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder eksplisiet gelys word wanneer die kode gegenereer word. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
# - pytest
# - pytest-httpserver
# ## Uitset
# Gee die volledige kode vir `src/workflow_transformer/workflow_transformer.py` in die volgende formaat:
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
# - ```pytest``` en ```pytest-httpserver```
### Biblioteksuiten
# `requirements.txt`
# ```
#  - pip install pytest
#  - pip install pytest-httpserver
# ```
# Biblioteksuiten is gesucht bij `requirements.txt` en kan in `requirements.txt` gebruik worden:
# - pytest
# - pytest-httpserver
# - pip
# - pip-install
# - pip-install-test
# - pip-download-test
# - pip-download
# - pip-sdist-test
# - pip-sdist
# - pip
# - pypi
# - pip-info
# - pip-update
# - pip-wheel
# - pip-wheel-test
# - pip-wheel-install
# - pip-wheel-download
# - pip-wheel-sdist
# - pip-wheel-info
# - pip-wheel-update
# - pip-wheel-install-test
# - pip-wheel-download-test
# - pip-wheel-sdist-test
# - pip-wheel-info-test
# - pip-wheel-update-test
#
# Biblioteksuiten is ook gesucht bij `requirements.txt` en kan in `requirements.txt` gebruik worden:
# - pip
# - pip-install
# - pip-install-test
# - pip-download-test
# - pip-download
# - pip-info
# - pip-update
# - pip-wheel
# - pip-wheel-test
# - pip-wheel-download
# - pip-wheel-sdist
# - pip-wheel-info
# - pip-wheel-update
# - pip-wheel-install-test
# - pip-wheel-download-test
# - pip-wheel-sdist-test
# - pip-wheel-info-test
#
# Biblioteksuiten kan aldus geslagen worden in deze pagina:
# https://github.com/mohamed/pytest-httpserver#setup-and-running-tests
#
# Biblioteksuiten kan geklik worden door `pip install pip-wheel-test` en die biblioteksuiten opgeslagen worden met `pip install --requirements-file requirements.txt` en deze beheerder worden gebruik.
#
# Biblioteksuiten kan ook geslagen worden door `pip install pip-wheel` en die biblioteksuiten opgeslagen worden met `pip install --requirements-file requirements.txt` en deze beheerder worden gebruik.
#
# Biblioteksuiten kan ook geklik worden door `pip install pip-wheel-test` en die beheerder worden gebruik af `pip install --requirements-file requirements.txt` en deze beheerder worden opgeslagen.
#
# Biblioteksuiten kan geklik worden door `pip install -r requirements.txt` en deze beheerder worden gebruik af `pip install --requirements-file requirements.txt` en deze beheerder opgeslagen.
#
# Biblioteksuiten kan ook geklik worden door `pip install -r requirements.txt` en deze beheerder worden gebruik af `pip install --requirements-file requirements.txt` en deze beheerder opgeslagen.
#
# Biblioteksuiten kunnen ook geklik worden door `pip install -r requirements.txt` en deze beheerder worden gebruik af `pip install --requirements-file requirements.txt` en deze beheerder opgeslagen.
#

import pytest
from pytest_httpserver import HTTPServer

# Testmodellen

def test_workflow_transformer():
    import workflow_transformer


# HTTPServer

if __name__ == "__main__":
    HTTPServer().serve("./test/test_workflow_transformer/src/workflow_transformer.py")
