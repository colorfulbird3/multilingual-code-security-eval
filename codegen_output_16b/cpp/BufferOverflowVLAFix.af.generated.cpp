write_ptr, csv_data[i]);
        write_ptr += field_sizes[i];
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

## Lêernaam
csv_parser.c

## Kop Kode
```html
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.colVis.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.colVis.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.tableTools.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.tableTools.colVis.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.dom.min.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/dataTables.tableTools.js"></script>
<script src="csv_parser.c"></script>

<body>
<h2>CSV-parser</h2>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3>CSV-