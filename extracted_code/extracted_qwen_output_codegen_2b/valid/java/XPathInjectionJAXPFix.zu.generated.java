public class XMLParser {
    @XStreamAlias("code")
    private String code;
    @XStreamAlias("path")
    private String path;
    @XStreamAlias("content")
    private String content;

    public XMLParser() {
    }

    public XMLParser(String code, String path, String content) {
        this.code = code;
        this.path = path;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}