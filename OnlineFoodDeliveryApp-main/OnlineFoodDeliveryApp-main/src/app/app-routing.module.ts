import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { MenuComponent } from './component/menu/menu.component';
import { RestaurantComponent } from './component/restaurant/restaurant.component';
import { CartComponent } from './component/cart/cart.component';
import { SecurityComponent } from './component/security/security.component';
import { NotFoundComponent } from './component/not-found/not-found.component';
import { CustomerComponent } from './component/customer/customer.component';
import { OrdersComponent } from './component/orders/orders.component';
import { AdmindashboardComponent } from './component/admindashboard/admindashboard.component';
import { RestaurantaddComponent } from './component/restaurantadd/restaurantadd.component';
import { RestaurantshowComponent } from './component/restaurantshow/restaurantshow.component';
import { MenuaddComponent } from './component/menuadd/menuadd.component';
import { MenuupdateComponent } from './component/menuupdate/menuupdate.component';
import { CartaddComponent } from './component/cartadd/cartadd.component';
import { CartupdateeComponent } from './component/cartupdatee/cartupdatee.component';
import { AdmincustomerComponent } from './component/admincustomer/admincustomer.component';
import { CustomerdashboardComponent } from './component/customerdashboard/customerdashboard.component';
import { CustomerrestaurantComponent } from './component/customerrestaurant/customerrestaurant.component';
import { CustomermenuComponent } from './component/customermenu/customermenu.component';
import { CustomerinfoComponent } from './component/customerinfo/customerinfo.component';
import { CustomercartComponent } from './component/customercart/customercart.component';
import { CustomerorderComponent } from './component/customerorder/customerorder.component';
import { CustomershowordersComponent } from './component/customershoworders/customershoworders.component';
import { CustomerheaderComponent } from './component/customerheader/customerheader.component';

const routes: Routes = [
{path:'',component:HomeComponent },
{path:'home',component:HomeComponent},
{path:'menu',component:MenuComponent},
{path:'restaurants',component:RestaurantComponent},
{path:'cart',component:CartComponent},
{path:'login',component:SecurityComponent},
{path:'admindashboard',component:AdmindashboardComponent},
{path:'Customerlogin',component:CustomerComponent},
{path:'orders',component:OrdersComponent},
{path:'restautantadd',component:RestaurantaddComponent},
{path:'restaurantupdate/:id',component:RestaurantshowComponent},
{path:'menuadd',component:MenuaddComponent},
{path:'menuupdate/:id',component:MenuupdateComponent},
{path:'cartadd',component:CartaddComponent},
{path:'cartupdate/:id',component:CartupdateeComponent},
{path:'admincustomerview',component:AdmincustomerComponent},

{path:'customerdashboard/:id',component:CustomerdashboardComponent},

{path:'customerdashboard',component:CustomerdashboardComponent},

{path:'customerrestaurant/:customer',component:CustomerrestaurantComponent},
{path:'customermenu/:customer/:restaurant',component:CustomermenuComponent},
{path:'customerinfo/:id',component:CustomerinfoComponent},
{path:'customercart/:id',component:CustomercartComponent},
{path:'customerorder',component:CustomerorderComponent},
{ path: 'showallorders/:id', component: CustomershowordersComponent },
{path:'customerheader',component:CustomerheaderComponent},
  { path: '**', component: NotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
