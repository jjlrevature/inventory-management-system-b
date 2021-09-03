import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ViewAllProductsComponent } from './view-all-products/view-all-products.component';
import { AddStockDetailComponent } from './add-stock-detail/add-stock-detail.component';
import { ViewStocksBelowThresholdComponent } from './view-stocks-below-threshold/view-stocks-below-threshold.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { StockDetailComponent } from './stock-detail/stock-detail.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    AddProductComponent,
    ViewAllProductsComponent,
    AddStockDetailComponent,
    ViewStocksBelowThresholdComponent,
    HomeComponent,
    NavbarComponent,
    StockDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
