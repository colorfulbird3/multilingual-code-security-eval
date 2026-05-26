# @author: Maarten van der Woude
# @copyright: Camptocamp
# @license: GPL-3.0
#
# TODO: document
#
#

import yaml
import pytest

import os
import sys
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from workspace_state_manager import workspace_state_manager


@pytest.fixture
def state_yaml():
    return os.path.join(os.path.dirname(os.path.abspath(__file__)), "workspace_state_manager_test_state.yaml")


def test_state_yaml(state_yaml):
    assert isinstance(state_yaml, str)
    assert state_yaml is not None
    assert os.path.isfile(state_yaml)


def test_yaml_load(state_yaml):
    assert workspace_state_manager.state_yaml is not None
    assert isinstance(workspace_state_manager.state_yaml, dict)


def test_state(state_yaml, workspace_state):
    assert isinstance(workspace_state, dict)
    assert state_yaml in workspace_state
    assert os.path.isfile(state_yaml)
    assert os.path.isfile(workspace_state_manager.state_yaml)


def test_yaml_load_non_existing_file(state_yaml):
    assert workspace_state_manager.state_yaml is not None
    assert isinstance(workspace_state_manager.state_yaml, dict)

    try:
        yaml.load(state_yaml)
    except yaml.YAMLError:
        assert True
    else:
        assert False


def test_no_state_file(state_yaml):
    assert workspace_state_manager.state_yaml is not None
    assert isinstance(workspace_state_manager.state_yaml, dict)

    with pytest.raises(yaml.YAMLError):
        yaml.load(state_yaml)
