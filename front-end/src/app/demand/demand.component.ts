import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demand',
  templateUrl: './demand.component.html',
  styleUrls: ['./demand.component.css']
})
export class DemandComponent implements OnInit {

  list:demand[] = [];  
  empty:boolean = false;
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8080/products/onDemand').subscribe({
      next: (data:any) => {
        if(data === null) {
          this.empty = true;
        } else {
          console.log(data);
          this.list = data;
        }
      }
    })
  }

}

export class demand {
  constructor(public title:String, public minLimit:number, public demand:number) {}
}
