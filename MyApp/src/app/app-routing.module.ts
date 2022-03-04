import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { SellerLoginComponent } from './seller-login/seller-login.component';
import { SellerRegisterComponent } from './seller-register/seller-register.component';
import { SellerComponent } from './seller/seller.component';
const routes: Routes = [
    // {  path: '', redirectTo: '/login', pathMatch: 'full' },
    // {   path: 'login',  component: SellerLoginComponent },
    // {   path: 'dashboard',  component: SellerComponent },
    // {   path: 'register',  component: SellerRegisterComponent },

    
    {   path: 'login',  component: SellerLoginComponent , pathMatch: 'full'},
   {   path: '',  component: SellerComponent , pathMatch: 'full'},
   {   path: 'register',  component: SellerRegisterComponent , pathMatch: 'full'},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }