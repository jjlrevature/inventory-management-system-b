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
  products?: Product[];
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

  filtering(form:NgForm) {
    console.log(form.value.statusFilter);
    this.filter = form.value.statusFilter;
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


