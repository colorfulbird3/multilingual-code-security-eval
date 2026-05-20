try {
       return new JSONDeserializer<>().deserialize(jsonConfig);
   } catch (JSONException e) {
       throw new IllegalArgumentException("Ongeldige JSON-konfigurasiestring-formaat: " + e.getMessage(), e);
   } catch (Exception e) {
       throw new RuntimeException("'n Onbekende fout het voorgekom tydens die laai van konfigurasie: " + e.getMessage(), e);
   }