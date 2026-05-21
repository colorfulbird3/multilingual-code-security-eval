content>
    </code>
</result>
```

## Ifomethi Kwekhona

Kwekhona kungase kuqukethwe kwe-script kuphezu ukuduza kwe-Groovy script. Uguqulokunze kwesikhathi ukuthi ngefomethi elandelayo; kuqekezume izinhlobi kuphezu yinikele i-script.

```java
ScriptService service = new ScriptService();
Object result = service.executeUserScript("return 'Hello World'");
// Okulindelekile ukubuyisela: "Hello World"
Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// Okulindelekile ukubuyisela: 14
```

## Uguqulokuna Phelele

Phononu kwesikhathi i-script ukuthi ngefomethi; kuqekezelo izinhlobi kuqekezume i-script kwenye kuphezu yinikele kwekha mathethi.

```java
ScriptService service = new ScriptService();
Object result = service.executeUserScript("return 'Hello World'");
// Okulindelekile ukubuyisela: "Hello World"
Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// Okulindelekile ukubuyisela: 14
```
"""


# This file is part of the NotePad source code.
# Visit http://notepad.sourceforge.net/ for more information.
#
# This program is free software; you can redistribute it and/or
# modify it under the terms of the GNU General Public License
# as published by the Free Software Foundation; either version 2
# of the License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy