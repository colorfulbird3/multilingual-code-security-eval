// >-
// > * <code>
// >-
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// >-
// * <path>
// path3
// </path>
// <content>
// <![CDATA[
// content3
// ]]>
// </content>
// </code>
// >-
// > * <path>
// path4
// </path>
// <content>
// <![CDATA[
// content4
// ]]>
// </content>
// </code>
// >-
// * <path>
// path5
// </path>
// <content>
// <![CDATA[
// content5
// ]]>
// </content>
// </code>

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("scriptService")
public class ScriptService {

    @Autowired
    @Qualifier("groovyShell")
    private GroovyShell shell;

    public Object executeUserScript(String scriptContent) {
        return shell.evaluate(scriptContent);
    }
}
