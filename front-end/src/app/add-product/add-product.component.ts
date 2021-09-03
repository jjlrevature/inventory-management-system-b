import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})

export class AddProductComponent implements OnInit {
  /*prod?: Product[];
  currentProduct: Product = {};
  currentIndex = -1;
  title = '';
  category = '';
  manufacturer = '';*/

  httpClient: any;

  constructor(private http:HttpClient, private router:Router) {}

  prod:product = {
    id: 0,
    category: "undefined",
    title: "undefined",
    manufacturer: "undefined",
    limit: 0
  } 

  products:product[] = []; 

  ngOnInit(): void {
    this.getProducts();
  }
  
  getProducts(){
    this.httpClient.get('http://localhost:8080/products').subscribe(
      (      response: product[]) => {
        console.log(response);
        this.products = response;
      }
    );
  }

  onSubmit(form:NgForm) {
    console.log(form);
    this.http.post("http://localhost:8080/products/new", ({
        minLimit: form.value.minLimit,
        category: form.value.category,
        title: form.value.title,
        manufacturer: form.value.manufacturer,
      }))
      .subscribe({
        next:(data:any)=>{
          console.log(data);
          this.router.navigate(['home']);
          
        },
        error:(error)=>{
          console.log(error);
        },
        complete:()=>{}
      })
  }
}

export class product {
  constructor(
    public id: number,
    public category: String, 
    public title: String, 
    public manufacturer: String, 
    public limit: number) {}
}


