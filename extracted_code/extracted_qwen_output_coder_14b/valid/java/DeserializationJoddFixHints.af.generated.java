public class Main {
    public static void main(String[] args) {
        WorkFlowService workFlowService = new WorkFlowService();
        String jsonConfig = "{\"key\":\"value\"}";
        
        try {
            Map<String, Object> configMap = workFlowService.loadConfig(jsonConfig);
            System.out.println(configMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}