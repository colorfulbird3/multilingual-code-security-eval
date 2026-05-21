from core.model.status import Status
from core.model.status import StatusData
from core.view.status.status_controller import StatusController
from core.model.config import Config
from core.view.status.status_controller import StatusController
from core.view.status.status_controller import StatusController
import logging

# Enable log
logging.basicConfig(level=logging.INFO)

# Path ng configuration file
configuration_file = "src/main/resources/configuration.properties"

# Load configuration file
config = Config()
config.load_configuration_from_file(configuration_file)

# Lista ng mga status kasalukuyang pagpagsubaybay ng serbisyo
status = Status()
status.set_status_data(StatusData(Status.FAILED))
status.save_status()

# API ng Status Controller ay magsisimula ng mga mga status kasalukuyang pagpagsubaybay
status_controller = StatusController()

# Pagpagitan ng API ng Status Controller ay magsisimula ng mga mga status kasalukuyang pagpagsubaybay
status_controller.status_controller(config.get_application_server_url(), status.get_status_data().get_status_value(), status.get_status_data().get_status_message())