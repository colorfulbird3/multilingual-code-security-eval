try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
       return reader.lines().limit(5).collect(Collectors.joining("\n"));
   }