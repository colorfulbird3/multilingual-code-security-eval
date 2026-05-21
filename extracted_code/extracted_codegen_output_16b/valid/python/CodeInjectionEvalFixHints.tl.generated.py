
"""
from pytest_httpserver import HTTPServer
import http.client

class WorkflowDataTransformer:
    def __init__(self, workflow_module_path: str, workflow_module_content: str):
        self.workflow_module_path = workflow_module_path
        self.workflow_module_content = workflow_module_content

    def transform_step_data(self, transform_map_expr: str, input_data: dict):
        return eval(transform_map_expr) # pragma: no cover # pylint: disable=eval-used

class TestWorkflowDataTransformer:
    def test_workflow_data_transformer(self):
        # create a new server for each test
        httpd = HTTPServer(('localhost', 0), WorkflowDataTransformer)
        port = httpd.server_port
        httpd.serve_content(self.workflow_module_path, self.workflow_module_content)

        # send a request to the server
        c = http.client.HTTPConnection('localhost', port)
        c.request('GET', '/')
        response = c.getresponse()
        assert response.status == 200
        c.close()
        httpd.server_close()


if __name__ == '__main__':
    import sys
    sys.exit(1)
