// Verwerking van gebruiker-ontleding

// Let op dat die gebruiker-ontleding wordt geadst wordt de XML-ontleding uitgevoerd.

// Daarna wordt de gebruiker-ontleding geadst en ook de konfiguratie geadst.

Document configDocument = loadConfig(configPath);

// Daarna wordt de gebruiker-ontleding geadst en ook de gebruikers-konfiguratie geadst.

System.out.println(configDocument.asXML());