fetchall()
# return [row.to_dict() for row in results]
# """
# gebruik <a href='https://github.com/pandorabots/pandora-python-sdk'>pandora-python-sdk</a> om deze funksie te bekendstel.
# """
# def create_connection(host, user, password, database, port=3306):
# """
# Keer 'n geldige pymysql-verbinding met behulp van die verskafde geloofsbriewe.
# Args:
# host: Databasisbediener se gasheernaam of IP-adres.
# user: Databasisgebruikersnaam.
# password: Databasiswagwoord.
# database: Databasisnaam.
# port: Databasispoort (verstek: 3306).
# Returns:
# 'n pymysql-verbindingsobject.
# """
# connection = pymysql.connect(
# host=host,
# user=user,
# password=password,
# database=database,
# port=port,
# cursorclass=pymysql.cursors.DictCursor
# )
# return connection
# def get_cursor(connection):
# """
# Kyer 'n wyser van die databasisverbinding.
# Args:
# connection: 'n pymysql-verbindingsobject.
# Returns:
# 'n pymysql-wyserobjek.
# """
# return connection.cursor()
# ```
# ## Afhanklikhede
# Gebruik asseblief:
# - pip install pymysql
# - pip install pytest
# - pip install python-dateutil
# - pip install googleapis
# - pip install googleapis-auth

# import pymysql
# import pytest
# import dateutil.parser
# import googleapis
# import googleapis_auth
# # Gebruik asseblief:
# # - pip install pymysql
# # - pip install pytest
# # - pip install python-dateutil
# # - pip install googleapis
# # - pip install googleapis-auth
# # - pip install googleapis
# # - pip install googleapis_auth
# # - pip install googleapis_auth
# # - pip install googleapis_auth
# import unittest
# from unittest.mock import MagicMock, patch, Mock
# from test_user_management import get_cursor, create_connection
# from user_management import get_sorted_users


# def test_get_sorted_users(monkeypatch):
# """
# Test of de funksie get_sorted_users, die komt met bekezing van de geldige pymysql-verbinding met behulp van die verskafde geloosbriewing.

# Args:
# monkeypatch: Instaan daten op een object met een enkele attribute, die alleen bestaat in deze object.
# Returns:
# 'n unittest-mock object.
# """
# monkeypatch.setattr(get_cursor, '_connection', create_connection())
# with patch('user_management.get_cursor') as mock:
# mock.return_value = create_connection()
# mock.return_value.cursor.execute.return_value = [
# {'id': '1',
#  'username': 'vandut',
#  'email': 'vandut@gmail.com',
# 'registration_date': '2018-02-27T23:48:00.000000Z'}]
# mock.return_value.cursor.fetchall.return_value = [
# {'id': '1',
#  'username': 'vandut',
#  'email': 'vandut@gmail.com',
# 'registration_date': '2018-02-27T23:48:00.000000Z'}]
# monkeypatch.setattr(dateutil.parser, 'parse', MagicMock(return_value='2018-02-27T23:48: