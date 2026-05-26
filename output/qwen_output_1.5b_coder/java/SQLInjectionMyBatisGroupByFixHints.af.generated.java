SalesByGroup("region", "2024-01-01,2024-12-31")`
- Groepeer per produkkategorie: `getSalesByGroup("product_category", "2024-01-01,2024-12-31")`
- Groepeer per verkooppersoon: `getSalesByGroup("sales_person", "2024-01-01,2024-12-31")`
- Groeper per periode: `getSalesByGroup("sale_date", "2024-01-01,2024-12-31")`

### Uitwerking
Deze implementatie maakt gebruik van MyBatis, een popular Java MyBatis mapper framework, om de SQL-query te genereren basier op de invoerparameters. Hierdoor wordt de database-interactie afgehandeld in Java, wat makkelijker te testen en te manuteniseren is.