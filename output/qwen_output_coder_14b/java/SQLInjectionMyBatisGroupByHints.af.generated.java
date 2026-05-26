This XML snippet contains a Java class named `SalesService` located at `src/main/java/com/example/service/SalesService.java`. The class is part of a larger application that deals with sales data statistics. Here's a breakdown of its key components:

### Class Overview

- **Package**: `com.example.service`
- **Class Name**: `SalesService`

### Fields

- **salesMapper**: A private final instance of `SalesMapper`, which is likely used to interact with a database or other data source.

### Constructor

- **Constructor**: Initializes the `salesMapper` field with the provided `SalesMapper` instance.
  ```java
  public SalesService(SalesMapper salesMapper) {
      this.salesMapper = salesMapper;
  }
  ```

### Methods

- **getSalesByGroup(String groupByField, String dateRange)**:
  - **Purpose**: This method aggregates sales data based on a specified grouping field and date range.
  - **Parameters**:
    - `groupByField`: A string representing the field by which the sales data should be grouped. This is user-controlled input.
    - `dateRange`: A string representing the date range over which the sales data should be aggregated. It should be in the format "start date,end date".
  - **Returns**: A list of maps, where each map represents a group of sales data.
  - **Validation**:
    - Checks if `groupByField` and `dateRange` are not null or empty.
    - Splits the `dateRange` into start and end dates.
    - Validates that both start and end dates are non-empty.
  - **Implementation**:
    - Calls the `getSalesByGroup` method of `salesMapper` with the validated parameters to retrieve the aggregated sales data.

### Key Points

- **Error Handling**: The method throws `IllegalArgumentException` with appropriate error messages if the inputs are invalid.
- **Date Range Parsing**: The date range is expected to be a comma-separated string, and the method splits it into two parts for further processing.
- **Dependency Injection**: The `SalesService` class uses constructor injection to receive an instance of `SalesMapper`.

This class is designed to be flexible and robust, handling user input validation and delegating the actual data retrieval to a mapper component.