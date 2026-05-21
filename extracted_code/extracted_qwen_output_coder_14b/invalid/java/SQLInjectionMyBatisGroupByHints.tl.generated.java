SalesService salesService = new SalesService(new SalesMapper());
List<Map<String, Object>> results = salesService.getSalesByGroup("region", "2023-01-01,2023-12-31");