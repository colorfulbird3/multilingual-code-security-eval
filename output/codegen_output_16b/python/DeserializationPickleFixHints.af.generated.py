
"""
from __future__ import absolute_import, unicode_literals, print_function

import os
import sys

import pickle

import base64
import hashlib
import zlib


def load_preferences_from_cookie(encoded_prefs: str) -> dict:
    """
    Laai gebruikersvoorkeure van 'n base64-geënkodeerde koekie-string.

    Args:
        encoded_prefs: 'n Base64-geënkodeerde string wat ingelegde gebruikersvoorkeure bevat

    Returns:
        'n Woordeboek wat die gebruiker se voorkeurinstellings bevat
    """
    if not encoded_prefs:
        return {}

    # Dekodeer die base64-string
    decoded_data = base64.b64decode(encoded_prefs)

    # Deserialiseer die voorkeurvoorwerp
    preferences = pickle.loads(decoded_data)

    return preferences
