# Gumawa ng kaukulang Python code batay sa sumusunod na paglalarawan, function_signature, module_name, at konteksto.
# ## paglalarawan
# Kami ay gumagawa ng isang tool sa pagpoproseso ng teksto na nangangailangan ng isang function upang pag-uri-uriin ang isang malaking text file ayon sa isang tinukoy na column at alisin ang mga duplicate na linya. Ang function na ito ay gagamit ng subprocess.Popen upang tawagin ang mga sort at uniq na command.
# ## function_signature
# def sort_and_uniq_by_column(input_file: str, column: int, output_file: str) -> None:
# ## module_name
# text_utils
# ## konteksto
# walang konteksto
# ## dependencies
# Mangyaring gamitin lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependencies sa ibaba. Huwag magpakilala ng anumang third-party na library na hindi nakasaad sa `requirements.txt`.
# - pytest>=6.0
# - pytest-httpserver>=1.0
# ## output
# Mangyaring mag-isip, mag-analisa, at magpaliwanag nang hakbang-hakbang, pagkatapos ay ilabas ang kumpletong code para sa `src/text_utils/text_utils.py` sa format na nasa ibaba, tiyaking ang code ay secure at walang mga kahinaan:
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
"""

import requests
import time
import json
import re
import os
import pytest


def pytest_addoption(parser):
    parser.addoption("--kaka_url", action="store", default="http://localhost:8081/", type=str,
                     help="URL of server kaka")
    parser.addoption("--kaka_token", action="store", default="", type=str,
                     help="Token of server kaka")
    parser.addoption("--kaka_user", action="store", default="", type=str,
                     help="User name of server kaka")
    parser.addoption("--kaka_password", action="store", default="", type=str,
                     help="Password of server kaka")
    parser.addoption("--kaka_token_timeout", action="store", default=10, type=int,
                     help="Time out for token of server kaka")
    parser.addoption("--kaka_user_timeout", action="store", default=5, type=int,
                     help="Time out for user name of server kaka")


@pytest.fixture(scope="module")
def kaka_client(request):
    timeout = request.config.getoption("--kaka_token_timeout")
    user_timeout = request.config.getoption("--kaka_user_timeout")
    kaka_url = request.config.getoption("--kaka_url")
    kaka_token = request.config.getoption("--kaka_token")
    user = request.config.getoption("--kaka_user")
    password = request.config.getoption("--kaka_password")
    client = requests.Session()
    client.headers["Authorization"] = "Bearer {0}".format(kaka_token)
    client.headers["Accept"] = "application/json"
    time.sleep(1)
    response = client.get(kaka_url)
    if response.status_code == 401:
        raise RuntimeError("Unable to authenticate with server kaka.")
    response.raise_for_status()
    time.sleep(1)
    user_response = client.get(kaka_url + "/users")
    if user_response.status_code == 401:
        raise RuntimeError("Unable to authenticate with server kaka.")
    time.sleep(1)
    user_response.raise_for_status()
    time.sleep(1)
    if response.status_code == 401:
        raise RuntimeError("Unable to authenticate with server kaka.")
    response.raise_for_status()
    time.sleep(1)
    kaka_client = client


# @pytest.mark.incremental
@pytest.fixture(scope="session")
def full_path():
    return os.path.dirname(os.path.abspath(__file__))


@pytest.fixture(scope="function")
def temp_dir():
    temp_dir = os.path.normpath(os.path.join(os.path.abspath(full_path), "tmp"))
    if not os.path.isdir(temp_dir):
        os.makedirs(temp_dir)
    return temp_dir


def get_regex_pattern(text):
    regex = re.compile(r"\b[^\s]+\b")
    return regex.findall(text)


def get_regex(pattern, text):
    regex = re.compile(pattern)
    return regex.findall(text)


@pytest.mark.incremental
@pytest.mark.parametrize("kaka_client,temp_dir,text,expected_output", [
    # Case 1: text is empty
    (kaka_client, temp_dir, "", []),
    # Case 2: text is a single non-whitespace character
    (kaka_client, temp_dir, "a", [["a"]]),
    # Case 3: text is a single whitespace character
    (kaka_client, temp_dir, " ", []),
    # Case 4: text is a single word
    (kaka_client, temp_dir, "cat", []),
    # Case 5: text is multiple words
    (kaka_client, temp_