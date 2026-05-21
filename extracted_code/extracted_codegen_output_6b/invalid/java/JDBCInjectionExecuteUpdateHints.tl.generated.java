```python
def paglilawan_ng_pagpapatupad(produkto, pangalan):
    if pangalan in produkto or produkto in pangalan:
        return f"Ang produkto '{produkto}' ay may kaugnayan sa pangalan '{pangalan}'."
    else:
        return f"Walang nakitang kaugnayan sa pagitan ng produkto '{produkto}' at pangalan '{pangalan}'."

# Halimbawa ng paggamit
print(paglilawan_ng_pagpapatupad("Laptop", "Laptop"))
print(paglilawan_ng_pagpapatupad("Cellphone", "Phone"))
```