import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Stock } from '../stock-detail/stock-detail.component';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-view-all-products',
  templateUrl: './view-all-products.component.html',
  styleUrls: ['./view-all-products.component.css']
})
export class ViewAllProductsComponent implements OnInit {

  constructor(private http: HttpClient) { }

  
  currentIndex = -1;
  products?: CurrentProduct[];
  filter:string="all";
  
  ngOnInit() {
    this.getProducts();
  }

  getProducts(){
    this.http.get<any>('http://localhost:8080/products').subscribe(
      response => {
        
        this.products = response;
      }
    );
  }

  getTotal(productid: number){
    this.http.get<any>('http://localhost:8080/stock/' + productid).subscribe(
      response => {
        console.log("getTotal called");
        return response;
      }
    )
  }

  filtering(form:NgForm) {
    console.log(form.value.statusFilter);
    this.filter = form.value.statusFilter;
  }

  // getTotal(plist: Product) {
	// 	let total = 0;
  //   console.log(plist);
  //   let newQuantity = 0;
	// 	for(let x = 0; x < plist.stock.length; x++) {
	// 		newQuantity = plist?.stock[x].quantity;
	// 		if(newQuantity <= 0) {				
	// 			total = total - Math.abs(newQuantity);
	// 		} else {
	// 			total = total + newQuantity;							
	// 		}
	// 	}		
	// 	return total;
	// }  

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
  stock: Stock[]
  currentStock: number

  constructor(
    title:string,
    category:string,
    manufacturer:string,
    minLimit:number,
    productId:number,
    stock: Stock[],
    currentStock: number
  ) {
    this.title = title;
    this.category = category;
    this.manufacturer = manufacturer;
    this.minLimit = minLimit;
    this.productId = productId;
    this.stock = stock;
    this.currentStock = currentStock;
  }

}

export class CurrentProduct extends Product {
  currentStock = 0;
  super(title:string, category:string,manufacturer:string, minLimit:number, productId:number, stock:Stock[]){
    this.title = title;
    this.category = category;
    this.manufacturer = manufacturer;
    this.minLimit = minLimit;
    this.productId = productId;
    this.stock = stock;
    this.currentStock = 0;
  }

  setCurrentStock(num: any){
    this.currentStock = num;
  }
}


