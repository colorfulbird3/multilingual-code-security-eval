

## Developer Notes

- Hoe laai die skript-uitvoeringsdiens?
    - `Executors.newSingleThreadExecutor()` opuitvoeringsdiens en `Executors.newCachedThreadPool()` ook.
- Hoe kom hierdie service uit?
    - Die service kom uit in die `ApplicationContext` (implementeren metode `getBean(String)`)
- Hoe word die skriptuitvoeringsdiens aangedefineer?
    - `@Bean(name = "scriptService")`
- Hoe word die scriptuitvoeringsdiens aangedefineer?
    - `@Bean(name = "scriptExecutorService")`
- Hoe word die executoruitvoeringsdiens aangedefineer?
    - `@Bean(name = "executorService")`

## Assumptions

- Skriptuitvoeringsdiens gaan deur
- GroovyShell moet geen reeds voerde skript verskaf
- Scriptuitvoeringsdiens moet uit voeren

## Conclusions

Voer de volgende code in de `src/main/java/com/example/service/ScriptService.java`:

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
        result = new ScriptExecutorResult(e.getMessage(), e.getScript().