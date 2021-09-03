import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock-detail/stock-detail.component';

@Component({
  selector: 'app-view-all-products',
  templateUrl: './view-all-products.component.html',
  styleUrls: ['./view-all-products.component.css']
})
export class ViewAllProductsComponent implements OnInit {

  constructor(private http: HttpClient) { }

  products?: Product[];
  filter="none";
  
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

  getTotal(plist: Product) {
		let total = 0;
    console.log(plist);

		for(let x = 0; x < plist.stock.length; x++) {
			const newQuantity = plist.stock(x).quantity;
			if(newQuantity < 0) {				
				total = total - Math.abs(newQuantity);
			} else {
				total = total + newQuantity;							
			}
		}		
		return total;
	}  

  logProducts(){
    console.log(this.products);
  }
}


export class Product {
  title: string
  category: string
  manufacturer: string
  minLimit: number
  productId: number
  stock:any

  constructor(
    title:string,
    category:string,
    manufacturer:string,
    minLimit:number,
    productId:number,
    stock:any
  ) {
    this.title = title;
    this.category = category;
    this.manufacturer = manufacturer;
    this.minLimit = minLimit;
    this.productId = productId;
    this.stock = stock;
  }

}
