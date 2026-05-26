_checkpoint_handler/training_checkpoint_handler.py` sa sumusunod na format:
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
# ## Paging
# La pagination da ang result sa pagkalasay, kagwalag at pagkalasay sa anumagamit. Ang pagkalasay sa pagkalasay sa anumagamit sa isang pagkalasay sa pagkalasay sa isang pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay.
# ## Paging Summary
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
# <result>
# <code>
# <path>
# path2
# </path>
# <content>
# <![CDATA[
# content2
# ]]>
# </content>
# </code>
# </result>
# </result>
# ```
# ## Paging Summary
# Laut ang pagkalasay sa mga isang pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay. Laut sa pagkalasay sa pagkalasay sa isang pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay.
# ## Paging Summary
# Laut sa pagkalasay sa pagkalasay sa isang pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay sa pagkalasay.

from torch import optim
from torch.nn import functional as F
from torch.optim import Adam

import os
import torch.nn.functional as F


def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    checkpoint_data = torch.load(checkpoint_path,weights_only=False)
    return checkpoint_data


if __name__ == '__main__':
    input("Press any key to continue...")
