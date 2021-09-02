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
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    AddProductComponent,
    ViewAllProductsComponent,
    AddStockDetailComponent,
    ViewStocksBelowThresholdComponent,
    HomeComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    /*HttpClientModule*/
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
