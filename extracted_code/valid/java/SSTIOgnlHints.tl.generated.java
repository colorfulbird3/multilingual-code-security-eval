import com.example.service.ReportService;
import ognl.OgnlException;

public class Main {
    public static void main(String[] args) {
        try {
            // Create an instance of ReportService
            ReportService reportService = new ReportService();

            // Define a data object
            Map<String, Object> data = new HashMap<>();
            data.put("name", "John Doe");
            data.put("age", 30);

            // Define an OGNL expression
            String expression = "name";

            // Get the field value using the OGNL expression
            Object fieldValue = reportService.getReportFieldValue(expression, data);

            // Print the result
            System.out.println("Field Value: " + fieldValue);
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }
}