import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Restaurants } from 'src/app/model/Restaurants';
import { CustomerService } from 'src/app/services/customer.service';
import { MenuService } from 'src/app/services/menu.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-customermenu',
  templateUrl: './customermenu.component.html',
  styleUrls: ['./customermenu.component.css']
})
export class CustomermenuComponent {
  key:any;
  response: any;
  menuService:any
  adminKey:any;
  authRequest: Restaurants = new Restaurants();
  deleteId!: number;
  getName!:String;
  getresponseName:any;

  admin:boolean=false;
  customer:boolean=false;

  restarentid:any;
  customerid: any;
  constructor(private jwtService:MenuService,private admintoken:CustomerService,private route:Router,private activatedRoute: ActivatedRoute){

    
    this.menuService=jwtService;
    admintoken.token.subscribe((genToken: any) => {
      this.adminKey = genToken;
      console.log('Admin Key:', this.adminKey);

      this.activatedRoute.params.subscribe((params) => {
        this.customerid=params['customer']
        this.restarentid = params['restaurant'];
        console.log('Restaurant ID:', this.restarentid);
        this.accessApi();
      });
    });
  }
    
  public get(){
    console.log('ok');
  }

  
  public accessApi() {
    console.log('Access Api:', this.adminKey);

    if (this.adminKey) {
      let response = this.menuService.getRestaurantId(
        this.restarentid,
        this.adminKey
      );

      response.subscribe((responseData: any) => {
        if (typeof responseData === 'string') {
          this.response = JSON.parse(responseData);
          console.log('Response Data:', this.response);
        } else {
          console.log('Unexpected response type:', responseData);
          // Handle unexpected response if necessary
        }
      });
    } else {
      console.error('Admin key is null.');
    }
  }

  goTocartroute(menu:number,restaurant:number,price:number){
    // this.movetocart(this.customerid,restaurant,menu,price);
  }
  movetocart(customer:number,restaurant:number, menu:number,price:number){
    this.route.navigate(['/customercart',customer, restaurant,menu,price]);
  }

  goTocart(menuItem: any) {
    // Call the new addToCart method to store the data
    this.menuService.addToCart(this.customerid, this.restarentid, menuItem.menuItemId, menuItem.price, menuItem.quantity);
  }
  menudata(){
  this.menuService.getCartData()
  }

  backTocustomerDash(){
    this.route.navigate(['/customerdashboard',this.admintoken.customername]);
  }
}
