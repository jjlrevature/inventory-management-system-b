import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-stock-detail',
  templateUrl: './stock-detail.component.html',
  styleUrls: ['./stock-detail.component.css']
})
export class StockDetailComponent implements OnInit {
currentProduct = null;

  constructor( private router: Router) { }

  ngOnInit(): void {
    // this.getProduct(this.route.snapshot.paramMap.get('id'));
  }

  // getProduct(id): void {
  //   this.tutorialService.get(id)
  //     .subscribe(
  //       data => {
  //         this.currentTutorial = data;
  //         console.log(data);
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }

}
