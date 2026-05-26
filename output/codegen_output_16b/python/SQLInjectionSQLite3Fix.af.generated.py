

## Kontroleer
Laat eerst `pytest-cov` uitvoer, `pytest --cov='sales_reports'` uitvoer, en laat dan de code uitvoer.
```bash
$ pytest --cov='sales_reports' --cov-report=term-missing --cov-config=.coveragerc
$ pytest --cov='sales_reports' --cov-report=html --cov-config=.coveragerc
```

## Ontwikkeling

- **probleem:** `get_sales_summary_by_group()` is nie ondersteunbaar na 'product_category' en'region' kolom, maar 'product_category' kolom is waarschijnlijk de eerste kolom waarby'region' kolom word.
- **probleem: **`product_category` en `region` kolom is waarschijnlijk 'product_category' kolom wat word bewaard terug in de 'group_by_column' kolom.
    - waarom? **Gebruik verplikte `product_category` en `region` kolom gebaseerd op de eerste kolom waarby'region' kolom word. **
    - hoe dit komt? **De eerste kolom is waarby'region' kolom word, dus 'group_by_column' word waar 'product_category' kolom word.**
- **probleem:**'sale_amount' word waarby 'order_date' word.
    - waarom? **'order_date' word waarby'sale_amount' word en 'order_date' word waarby'sale_amount' word.**
- **idee:** **`product_category` en `region` kolom is waarschijnlijk 'product_category' kolom wat word bewaard terug in de 'group_by_column' kolom.**
    - waarom? **De eerste kolom is waarby