public class Thirumitha {
    public static void main(String[] args) {
        RemoteResourceService remoteResourceService = new RemoteResourceService();
        String content = remoteResourceService.getResourceContent("https://www.aliyun.com/robots.txt");
        System.out.println(content);
    }
}