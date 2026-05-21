

## source code
"""
from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

import requests
from PIL import Image
from io import BytesIO

from requests.exceptions import RequestException

from PIL import Image
from io import BytesIO


def get_request_parameters(request):
    try:
        return request.params['name']
    except (KeyError, TypeError):
        return None


def get_all_request_parameters(request):
    result = {}
    for key, value in request.params.items():
        result[key] = value
        return result


def get_all_request_parameters_lowercase(request):
    result = {}
    for key, value in request.params.items():
        result[key.lower()] = value
        return result


def get_request_parameter_integer(request, name):
    try:
        return int(request.params[name])
    except (KeyError, TypeError):
        return None


def get_request_parameter_float(request, name):
    try:
        return float(request.params[name])
    except (KeyError, TypeError):
        return None


def get_request_parameter_boolean(request, name):
    try:
        return bool(request.params[name])
    except (KeyError, TypeError):
        return None


def get_request_parameter_string(request, name):
    try:
        return request.params[name]
    except (KeyError, TypeError):
        return None


def get_request_parameter_filename(request, name):
    try:
        return request.params[name]
    except (KeyError, TypeError):
        return None


class BaseService(object):

    def __init__(self, base_url: str, **kwargs) -> None:
        self.base_url = base_url

    def get_preferences(self) -> dict:
        raise NotImplementedError

    def save_preferences(self, preferences: dict) -> None:
        raise