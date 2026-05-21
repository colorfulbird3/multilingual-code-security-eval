try {
       return JsonParser.create().setClassMetadataName("@class").parse(jsonConfig);
   } catch (JsonException e) {
       throw new JsonException("Kon nie JSON-konfigurasiestring ontleed nie. Maak seker dit is geldige JSON.", e);
   } catch (Exception e) {
       throw new RuntimeException("'n Onverwagte fout het tydens JSON-ontleding voorgekom.", e);
   }