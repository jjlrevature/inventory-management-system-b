import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { AddStockDetailComponent } from './add-stock-detail/add-stock-detail.component';
import { HomeComponent } from './home/home.component';
import { ViewAllProductsComponent } from './view-all-products/view-all-products.component';
import { ViewStocksBelowThresholdComponent } from './view-stocks-below-threshold/view-stocks-below-threshold.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'add-product', component: AddProductComponent},
  {path: 'add-stock-detail', component: AddStockDetailComponent},
  {path: 'view-all-products', component: ViewAllProductsComponent},
  {path: 'view-stocks-below-threshold', component: ViewStocksBelowThresholdComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
