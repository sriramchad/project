import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';

import {HttpClientModule} from '@angular/common/http';
import { RouterModule,Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SecurityComponent } from './component/security/security.component';
import { MenuComponent } from './component/menu/menu.component';
import { RestaurantComponent } from './component/restaurant/restaurant.component';
import { CartComponent } from './component/cart/cart.component';
import { NotFoundComponent } from './component/not-found/not-found.component';
import { CustomerComponent } from './component/customer/customer.component';
import { OrdersComponent } from './component/orders/orders.component';
import { AdmindashboardComponent } from './component/admindashboard/admindashboard.component';
import { CustomerdashboardComponent } from './component/customerdashboard/customerdashboard.component';
import { AdminheaderComponent } from './component/adminheader/adminheader.component';
import { RestaurantaddComponent } from './component/restaurantadd/restaurantadd.component';
import { RestaurantshowComponent } from './component/restaurantshow/restaurantshow.component';
import { MenuaddComponent } from './component/menuadd/menuadd.component';
import { MenuupdateComponent } from './component/menuupdate/menuupdate.component';
import { CartaddComponent } from './component/cartadd/cartadd.component';
import { CartupdateeComponent } from './component/cartupdatee/cartupdatee.component';
import { AdmincustomerComponent } from './component/admincustomer/admincustomer.component';
import { CustomerrestaurantComponent } from './component/customerrestaurant/customerrestaurant.component';
import { CustomermenuComponent } from './component/customermenu/customermenu.component';
import { CustomercartComponent } from './component/customercart/customercart.component';
import { CustomerorderComponent } from './component/customerorder/customerorder.component';
import { CustomerinfoComponent } from './component/customerinfo/customerinfo.component';
import { CustomershowordersComponent } from './component/customershoworders/customershoworders.component';
import { CustomerheaderComponent } from './component/customerheader/customerheader.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    SecurityComponent,
    MenuComponent,
    RestaurantComponent,
    CartComponent,
    NotFoundComponent,
    CustomerComponent,
    OrdersComponent,
    AdmindashboardComponent,
    CustomerdashboardComponent,
    AdminheaderComponent,
    RestaurantaddComponent,
    RestaurantshowComponent,
    MenuaddComponent,
    MenuupdateComponent,
    CartaddComponent,
    CartupdateeComponent,
    AdmincustomerComponent,
    CustomerrestaurantComponent,
    CustomermenuComponent,
    CustomercartComponent,
    CustomerorderComponent,
    CustomerinfoComponent,
    CustomershowordersComponent,
    CustomerheaderComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
