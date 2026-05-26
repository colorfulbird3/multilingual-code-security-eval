// Khipha ikhodi ephelele ye `src/main/java/com/example/service/ScriptService.java` ngefomethi elandelayo:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
//
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// ```
package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.io.File;

public class ScriptService {

  static Script script;
  static ScriptService instance;

  public static ScriptService getInstance() {
    if (instance == null) {
      instance = new ScriptService();
    }
    return instance;
  }

  private ScriptService() {
  }

  public Object executeUserScript(final String scriptContent) {
    if (script == null) {
      initScript();
    }
    return script.run(scriptContent);
  }

  private void initScript() {
    // TODO: add groovy file to the classpath
    File groovyScriptFile = new File("src/main/java/com/example/service/ScriptService.groovy");
    GroovyShell shell = new GroovyShell();
    script = shell.parse(groovyScriptFile, "ScriptService");
  }
}
