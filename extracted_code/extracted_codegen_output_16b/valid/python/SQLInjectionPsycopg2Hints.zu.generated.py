from.logger import UserActivityLogger
from.models import UserActivity

class UserActivityLogger:
    def __init__(self, user_activity_log_count: int):
        self.user_activity_log_count = user_activity_log_count

    def process_request(self, environ: dict) -> None:
        UserActivity.objects.create(
            user_activity_log_count=self.user_activity_log_count
        )