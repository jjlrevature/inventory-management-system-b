import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-all-products',
  templateUrl: './view-all-products.component.html',
  styleUrls: ['./view-all-products.component.css']
})
export class ViewAllProductsComponent implements OnInit {

  constructor(private http: HttpClient) { }

  products?: Product[] = [];
  
  ngOnInit() {
    this.getProducts();
  }

  getProducts(){
    this.http.get<any>('http://localhost:8080/products').subscribe(
      response => {
        console.log(response);
        this.products = response;
      }
    );
  }
}


export class Product {
  title?: string
  category?: string
  manufacturer?: string
  minLimit?: number
  productId?: number

  constructor(
    title:string,
    category:string,
    manufacturer:string,
    minLimit:number,
    productId:number
  ) {
    this.title = title;
    this.category = category;
    this.manufacturer = manufacturer;
    this.minLimit = minLimit;
    this.productId = productId;
  }

}
