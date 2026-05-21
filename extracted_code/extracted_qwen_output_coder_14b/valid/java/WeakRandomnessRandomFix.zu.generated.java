public class Main {
    public static void main(String[] args) {
        SessionService sessionService = new SessionService();
        String sessionId = sessionService.generate(20); // Generate a 20-character session ID
        System.out.println("Generated Session ID: " + sessionId);
    }
}