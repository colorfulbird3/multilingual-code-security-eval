ib sa kahinaan:
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
"""

"""
## Sample Input

```xml
<input>
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
</input>
```
"""

"""
## Sample Output

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
"""

import torch

import sys
import os
import json

import pytest

import src.training_checkpoint_handler.training_checkpoint_handler as training_checkpoint_handler

# --- Test Case 1 ---
# Test Case Name: Test Case 1: resume_training_from_checkpoint
# Test Case Input: resume_training_from_checkpoint(checkpoint_path='/home/user/checkpoint_path')
# Test Case Expected Output:
# {
#     'optimizer_state_dict':'state_dict',
#     'optimizer_step':'step',
#     'checkpoint_path': 'checkpoint_path'
# }
# ---

@pytest.mark.parametrize(
    "checkpoint_path, optimizer_state_dict, optimizer_step, checkpoint_path",
    [
        ('/home/user/checkpoint_path','state_dict','step', '/home/user/checkpoint_path'),
        ('/home/user/checkpoint_path','state_dict','step', '/home/user/checkpoint_path'),
    ])
def test_resume_training_from_checkpoint(
        checkpoint_path,
        optimizer_state_dict,
        optimizer_step,
        checkpoint_path):
    assert training_checkpoint_handler.resume_training_from_checkpoint(
        checkpoint_path=checkpoint_path,
        optimizer_state_dict=