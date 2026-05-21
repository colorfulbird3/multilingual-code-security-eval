```java
@Autowired
private ScriptService scriptService;

//...

@RequestMapping("/execute")
public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //...
    
    String content = request.getParameter("content");
    String path = request.getParameter("path");
    String result = "";
    
    try {
        Script script = new Script("scriptContent", path, content);
        ScriptExecutorService service = scriptService.getScriptExecutorService();
        ScriptExecutorResult result = service.execute(script);
        result.getOutput().ifPresent(value -> response.getOutputStream().print(value));
        response.setStatus(HttpServletResponse.SC_OK);
    } catch (ScriptExecutionException e) {
        result = new ScriptExecutorResult(e.getMessage(), e.getScript());