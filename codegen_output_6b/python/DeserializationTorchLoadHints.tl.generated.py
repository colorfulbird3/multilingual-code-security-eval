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

## examples

```

import torch

from torch.optim import SGD
from torchvision.datasets import MNIST
from torchvision.transforms import ToTensor, RandomHorizontalFlip

from training_checkpoint_handler import resume_training_from_checkpoint

checkpoint_path = 'checkpoint.pt'

mnist = MNIST(root='data', train=True, download=True, transform=ToTensor(), shuffle=True, seed=1)

model = torch.nn.Sequential(
    torch.nn.Linear(784, 10),
    torch.nn.Sigmoid(),
)

optimizer = torch.optim.SGD(model.parameters(), lr=0.01)

for epoch in range(10):
    model.train()
    for (batch_idx, (data, target)) in enumerate(mnist.dataset):
        optimizer.zero_grad()
        output = model(data)
        loss = torch.mean(torch.dist(output, target))
        optimizer.backward(loss=loss)
        optimizer.step()
        print(f'Epoch: {epoch} | Loss: {loss:.4f}')

resume_training_from_checkpoint(checkpoint_path)

model.eval()
print(model(data))
```

## komoditas

- `torch.jit.script` para gawin ang `torch.jit.recompile()` ang atok nakasasay ng training checkpoint.
- `torch.load` para gawin ang `torch.load()` ang atok nakasasay ng training checkpoint.

## kontrol

1. Testang ikasulan ang training checkpoint sa kalita ng checkpointer.
2. Testang ikasulan ang training checkpoint sa kalita ng checkpoint.
3. Testang ikasulan ang training checkpoint sa kalita ng checkpoint.
4. Testang ikasulan ang training checkpoint sa kalita ng checkpoint.

## nagtatakot

Nagtatakot ng kadal