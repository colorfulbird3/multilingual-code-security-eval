

## Ukuthi Engezansi

Okuma kuphe ikhodi ezoluqo, izinhezelo ngezansi ukuthi ezoluqo, izinhezelo ezoluqo, ngezansi ukuthi ezoluqo. Ezokuthe ikhodi yose sithuthu na ngezansi ukuthi ezokuthe.

## Ukuthi Ekiphe

Ngezansi ukuthi ezokuthe, ikhodi ezokuthe, ikhodi ezokuthe, ezokuthe.

## Okuhulwe

`src/user_activity_logger/user_activity_logger.py` izinhezelo ngokusekwele we-User Activity Logger, ansekhe futhi ezokuthe.

### Ifayela: `src/user_activity_logger/user_activity_logger.py`

```python
from.logger import UserActivityLogger
from.models import UserActivity

class UserActivityLogger:
    def __init__(self, user_activity_log_count: int):
        self.user_activity_log_count = user_activity_log_count

    def process_request(self, environ: dict) -> None:
        UserActivity.objects.create(
            user_activity_log_count=self.user_activity_log_count
        )
```

### Ifayela: `src/user_activity_logger/models.py`

```python
from datetime import datetime

from.logger import UserActivityLogger


class UserActivity:
    def __init__(self, user_activity_log_count: int):
        self.user_activity_log_count = user_activity_log_count

    def save(self) -> None:
        if self.user_activity_log_count > 0:
            UserActivityLogger().process_request(self.environ)
            self.user_activity_log_count = 0
            self