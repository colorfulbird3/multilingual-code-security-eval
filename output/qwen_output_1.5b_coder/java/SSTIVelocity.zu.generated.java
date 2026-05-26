        <params>
            <param name="userId">userId</param>
            <param name="dashboardTemplate">dashboardTemplate</param>
        </params>
    </code>
</result>
```

Khipha ikhodi ephelele ye-`src/main/resources/templates/dashboard.vm` ngefomethi elandelayo:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <div class="dashboard">
        <h1>Siyakwamukela, user $userId</h1>
        <div class="stats">
            <p>I-ID yomsebenzisi: $userId</p>
        </div>
    </div>
</body>
</html>
```

Ngeza amakhombola amabona ukwethulwa kwedatha, amashadi, izibalo, njll.