

## Invoer uitvoeren

### Voer uitset in 'n kodereg
```python
result = transform_step_data(transform_map_expr, input_data)
```
### Voer uitset in 'n URL
```python
result = transform_step_data(transform_map_expr, input_data)
```
### Voer uitset in 'n csv-file
```python
f = open('filename', 'w')
f.write(result)
f.close()
```


## Uitvoer

### Voer uitset in 'n kodereg
```python
print(result)
```
### Voer uitset in 'n URL
```python
response = requests.get('http://example.com')
```
### Voer uitset in 'n csv-file
```python
f = open('filename', 'w')
f.write(result)
f.close()
```
"""
