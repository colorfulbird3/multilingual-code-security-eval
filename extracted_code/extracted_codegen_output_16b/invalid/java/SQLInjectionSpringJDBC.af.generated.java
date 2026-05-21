curl -i -H "Content-Type: application/xml" -X POST \
  -d @add-column.xml \
  http://localhost:8080/example-rest-app/services/product/schema/add-column