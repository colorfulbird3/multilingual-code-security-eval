 </code>
# </result>
# ```

# ## Test
# ```python
# import unittest
# import pathlib
# import os
# import shutil
# import pytest
# import yaml
# import yaml.io
# import json
# import json.load
# from os.path import dirname, abspath
# from os import getcwd
# from shutil import copyfile
#
# @pytest.mark.parametrize('test', [
#     ('test', 'test_path'),
#     ('test_path', 'test'),
# ])
# def test_copy(test):
#     path = dirname(abspath(__file__))
#     here = pathlib.Path(path)
#     destination = here / 'test_path'
#     source = here / test[1]
#     assert not source.exists()
#     assert not destination.exists()
#     copyfile(source, destination)
#     assert source.exists()
#     assert destination.exists()
#     with source.open('r') as f:
#         assert f.read() == test[0]
#     with destination.open('r') as f:
#         assert f.read() == test[0]
# @pytest.mark.parametrize('test', [
#     ('test', 'test_path'),
#     ('test_path', 'test'),
# ])
# def test_copy_not_exist(test):
#     path = dirname(abspath(__file__))
#     here = pathlib.Path(path)
#     destination = here / 'test_path'
#     source = here / test[1]
#     assert not source.exists()
#     assert not destination.exists()
#     copyfile(source, destination)
#     assert source.exists()
#     assert destination.exists()
#     with source.open('r') as f:
#         assert f.read() == test[0]
#     with destination.open('r') as f:
#         assert f.read() == test[0]
# @pytest.mark.parametrize('test', [
#     ('test', 'test_path'),
#     ('test_path', 'test'),
# ])
# def test_copy_fail(test):
#     path = dirname(abspath(__file__))
#     here = pathlib.Path(path)
#     destination = here / 'test_path'
#     source = here / test[1]
#     assert not source.exists()
#     assert not destination.exists()
#     with pytest.raises(FileNotFoundError) as excinfo:
#         copyfile(source, destination)
#     assert excinfo.value.errno == errno.ENOENT
# @pytest.mark.parametrize('test', [
#     ('test', 'test_path'),
#     ('test_path', 'test'),
# ])
# def test_copy_fail_not_exist(test):
#     path = dirname(abspath(__file__))
#     here = pathlib.Path(path)
#     destination = here / 'test_path'
#     source = here / test[1]
#     assert not source.exists()
#     assert not destination.exists()
#     with pytest.raises(FileNotFoundError) as excinfo:
#         copyfile(source, destination)
#     assert excinfo.value.errno == errno.ENOENT
# @pytest.mark.parametrize('test', [
#     ('test', 'test_path'),
#     ('test_path', 'test'),
# ])
# def test_copy_fail_not_in_dir(test):
#     path = dirname(abspath(__file__))
#     here = pathlib.Path(path)
#     destination = here / test[1]
#     source = here / test[1]
#     assert not source.exists()
#     assert not destination.exists()
#     with pytest.raises(FileNotFoundError) as excinfo:
#         copyfile(source, destination)
#     assert excinfo.value.errno == errno.ENOENT
# @pytest.mark.