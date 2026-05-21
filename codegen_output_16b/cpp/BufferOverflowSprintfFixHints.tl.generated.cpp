</code>
</result>
```

"""

    def test_format_metric_point(self):
        # Arrange
        metric_name = "http_requests_total"
        label_keys = ["method", "status"]
        label_values = ["GET", "200"]
        label_count = 2
        metric_output = ""

        # Act
        ret = self.monitoring_system.format_metric_point(metric_name, label_keys, label_values, label_count, metric_output)

        # Assert
        self.assertIsNotNone(ret)
        self.assertIsNotNone(metric_output)

    def test_format_metric_point_error(self):
        # Arrange
        metric_name = None
        label_keys = ["method", "status"]
        label_values = ["GET", "200"]
        label_count = 2
        metric_output = ""

        # Act & Assert
        with self.assertRaises(Exception):
            self.monitoring_system.format_metric_point(metric_name, label_keys, label_values, label_count, metric_output)

    def test_format_metric_point_error(self):
        # Arrange
        metric_name = "http_requests_total"
        label_keys = []
        label_values = ["GET", "200"]
        label_count = 2
        metric_output = ""

        # Act & Assert
        with self.assertRaises(Exception):
            self.monitoring_system.format_metric_point(metric_name, label_keys, label_values, label_count, metric_output)

    def test_format_metric_point_error(self):
        # Arrange
        metric_name = "http_requests_total"
        label_keys = ["method", "status"]
        label_values = [None, "200"]
        label_count = 2
        metric_output = ""

        # Act & Assert
        with self.assertRaises(Exception):
            self.monitoring_system.format_met