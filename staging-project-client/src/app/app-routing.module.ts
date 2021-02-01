import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { CartComponent } from './components/cart/cart.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { LandingComponent } from './components/landing/landing.component';
import { LoginComponent } from './components/login/login.component';
import { ShopComponent } from './components/shop/shop.component';

const routes: Routes = [
  {path: '', component: LandingComponent},
  {path: 'login', component: LoginComponent},
  {path: 'shop', component: ShopComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'cart', component: CartComponent},
  {path: 'checkout', component: CheckoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
