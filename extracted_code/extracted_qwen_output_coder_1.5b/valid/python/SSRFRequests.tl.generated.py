```typescript
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cloud',
  templateUrl: './cloud.component.html',
  styleUrls: ['./cloud.component.css']
})
export class CloudComponent implements OnInit {
  data$: Observable<any>;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.data$ = this.http.get('https://api.example.com/cloud-data');
  }
}
```