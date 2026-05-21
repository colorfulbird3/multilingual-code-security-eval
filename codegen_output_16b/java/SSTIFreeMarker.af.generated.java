

### Uitvoer

Die uitvoer van die verskaf bladsy:

```html
<div>Username: <b>${username}</b></div>
<div>Bladsy inhoud:</div>
<pre>${bladsyinhoud}</pre>
```

### Uitvoerbare handleiding

De handleiding bestaat in'src/main/webapp/templates/profile.html' die de bladsy-inhoud opmaakt.

#### Gereedskap

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Profile</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="columns">
                <div class="col-sm-12">
                    <h1>Welcome ${username}!</h1>
                    <p>This is your personal profile page</p>
                    <div>Username: ${username}</div>
                </div>
                <div class="col-sm-12">
                    <pre>${bladsyinhoud}</pre>
                </div>
            </div>
        </div>
    </body>
</html>
```

## Afgeronde

Gebruikers moet die bladsy-inhoud opmaak, en die verwerk de bladsy met behulp van de Freemarker-bladsjabloonsintaks.

## Morelse

Gebruikers moet 'n bladsy-naam instellen.

### Afgeronde

**Inhoud**

```
<h1>Welcome ${username}!</h1>
<p>This is your personal profile page</p>
<div>Username: ${username}</div>
```

**Opmaak**

```
<!DO