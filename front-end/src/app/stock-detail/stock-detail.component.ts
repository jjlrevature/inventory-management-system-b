import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';


const baseUrl = 'http://localhost:8080/stock/add';
const baseUrl2 = 'http://localhost:8080/stock/add2';
const baseUrl3 = 'http://localhost:8080/stock/add3';
const baseUrl4 = 'http://localhost:8080/stock/add4';
const baseUrl5 = 'http://localhost:8080/stock/add5';


export class Stock {
  warehouseStockId?: number;
  dateOfTrans?: Date;
  vendor?: string;
  batchCode?: string;
  invoiceNum?: string;
  quantity?: number;
  transType?: string;
  product?: any;
}

@Component({
  selector: 'app-stock-detail',
  templateUrl: './stock-detail.component.html',
  styleUrls: ['./stock-detail.component.css']
})


export class StockDetailComponent implements OnInit {
stockdetail?: Stock[];
closeResult: string | undefined;
currentStock: Stock = {};
currentIndex = -1;
addStock: Stock = {
  vendor: ''
};
submitted = false;


  constructor( private router: Router,private httpClient: HttpClient,private http: HttpClient) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.httpClient.get<any>('http://localhost:8080/stock').subscribe(
      response => {
        console.log(response);
        this.stockdetail = response;
      }
    );
  }


  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  create2(data: any): Observable<any> {
    return this.http.post(baseUrl2, data);
  }

  create3(data: any): Observable<any> {
    return this.http.post(baseUrl3, data);
  }

  create4(data: any): Observable<any> {
    return this.http.post(baseUrl3, data);
  }

  create5(data: any): Observable<any> {
    return this.http.post(baseUrl3, data);
  }

  add(): void {
    const data = {
      warehouseStockId: this.addStock.warehouseStockId,
      product: this.addStock.product,
      dateOfTrans: this.addStock.dateOfTrans,
      vendor: this.addStock.vendor,
      batchCode: this.addStock.batchCode,
      invoiceNum: this.addStock.invoiceNum,
      quantity: this.addStock.quantity,
      transType: this.addStock.transType
 
    };

    this.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  add2(): void {
    const data = {
      warehouseStockId: this.addStock.warehouseStockId,
      product: this.addStock.product,
      dateOfTrans: this.addStock.dateOfTrans,
      vendor: this.addStock.vendor,
      batchCode: this.addStock.batchCode,
      invoiceNum: this.addStock.invoiceNum,
      quantity: this.addStock.quantity,
      transType: this.addStock.transType
 
    };

    this.create2(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  add3(): void {
    const data = {
      warehouseStockId: this.addStock.warehouseStockId,
      product: this.addStock.product,
      dateOfTrans: this.addStock.dateOfTrans,
      vendor: this.addStock.vendor,
      batchCode: this.addStock.batchCode,
      invoiceNum: this.addStock.invoiceNum,
      quantity: this.addStock.quantity,
      transType: this.addStock.transType
 
    };

    this.create3(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  add4(): void {
    const data = {
      warehouseStockId: this.addStock.warehouseStockId,
      product: this.addStock.product,
      dateOfTrans: this.addStock.dateOfTrans,
      vendor: this.addStock.vendor,
      batchCode: this.addStock.batchCode,
      invoiceNum: this.addStock.invoiceNum,
      quantity: this.addStock.quantity,
      transType: this.addStock.transType
 
    };

    this.create4(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  add5(): void {
    const data = {
      warehouseStockId: this.addStock.warehouseStockId,
      product: this.addStock.product,
      dateOfTrans: this.addStock.dateOfTrans,
      vendor: this.addStock.vendor,
      batchCode: this.addStock.batchCode,
      invoiceNum: this.addStock.invoiceNum,
      quantity: this.addStock.quantity,
      transType: this.addStock.transType
 
    };

    this.create5(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  // open(content: any) {
  //   this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
  //     this.closeResult = `Closed with: ${result}`;
  //   }, (reason) => {
  //     this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  //   });
  // }

  // private getDismissReason(reason: any): string {
  //   if (reason === ModalDismissReasons.ESC) {
  //     return 'by pressing ESC';
  //   } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
  //     return 'by clicking on a backdrop';
  //   } else {
  //     return `with: ${reason}`;
  //   }
  // }

}
