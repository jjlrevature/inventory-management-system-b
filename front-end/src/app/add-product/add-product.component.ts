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

  constructor(private http:HttpClient, private router:Router) {}

  ngOnInit(): void {
  }

  onSubmit(form:NgForm) {
    console.log(form);
    this.http.post("http://localhost:8080/products/addProduct", {
        minLimit: form.value.minLimit,
        category: form.value.category,
        title: form.value.title,
        manufacturer: form.value.manufacturer,
      })
      .subscribe({
        next:(data:any)=>{
          console.log(data);
        },
        error:(error)=>{
          console.log(error);
        },
        complete:()=>{}
      })
  }
}

