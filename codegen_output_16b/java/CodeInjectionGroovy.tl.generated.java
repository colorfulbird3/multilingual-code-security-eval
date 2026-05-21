
        </content>
    </code>
</result>
```

## Sample Inputs

```groovy
import com.example.service

def add(int x, int y) {
    return x + y
}

def mul(int x, int y) {
    return x * y
}

def square(int x) {
    return x * x
}

def factorial(int x) {
    return 1 if x < 1 else x * factorial(x - 1)
}

def getResult(int x, int y, int z) {
    return add(add(mul(x, y), mul(x, z)), square(x)) * factorial(x)
}

def executeUserScript(String script) {
    groovy.lang.GroovyShell shell = new groovy.lang.GroovyShell(groovy.lang.Script.class)
    Object result = shell.parse(script).run()
    return result
}

print "1+2*3"
print "1+2*3+4*5"
print "1+2*3+4*5+6*7"
print "1+2*3+4*5+6*7+8*9"
print "1+2*3+4*5+6*7+8*9+10*11"

print executeUserScript("return 1 + 2 * 3")
print executeUserScript("return 1 + 2 * 3 + 4 * 5")
print executeUserScript("return 1 + 2 * 3 + 4 * 5 + 6 * 7")
print executeUserScript("return 1 + 2 * 3 + 4 * 5 + 6 * 7 + 8 * 9")
print executeUserScript("return 1 + 2 * 3 + 4 * 5 + 6 * 7 + 8 * 9 + 10 * 11")

```

## Sample Output

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        1
        6
        9
        22
        36
        72
        144
        ]]>
        </content>
    </code>
</result>

<result>
    <code>
        <path>
