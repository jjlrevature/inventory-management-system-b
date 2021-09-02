import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-stocks-below-threshold',
  templateUrl: './view-stocks-below-threshold.component.html',
  styleUrls: ['./view-stocks-below-threshold.component.css']
})
export class ViewStocksBelowThresholdComponent implements OnInit {

  list:inDemand[] = [];
  empty:boolean = false;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/products/inDemand').subscribe({
      next: (data:any) => {
        if(data === null) {
          this.empty = true;
        } else {
          this.list = data;
        }
      }
    })
  }

}

export class inDemand {
  constructor(public title:string, public minLimit:number, public demand:number) {}
}
