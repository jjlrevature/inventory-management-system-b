import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StockDetailComponent } from './stock-detail/stock-detail.component';

const routes: Routes = [
  {path: '', redirectTo: 'details', pathMatch: 'full'},
  {path: 'details', component: StockDetailComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
