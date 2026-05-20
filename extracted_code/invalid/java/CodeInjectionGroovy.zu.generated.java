ScriptService service = new ScriptService();
Object result = service.executeUserScript("return 'Hello World'");
// Okulindelekile ukubuyisela: "Hello World"

Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// Okulindelekile ukubuyisela: 14