SalesService salesService = new SalesService(salesMapper);
List<Map<String, Object>> salesData = salesService.getSalesByGroup("region", "2024-01-01,2024-12-31");