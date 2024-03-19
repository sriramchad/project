import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Restaurants } from 'src/app/model/Restaurants';
import { CustomerService } from 'src/app/services/customer.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-customerrestaurant',
  templateUrl: './customerrestaurant.component.html',
  styleUrls: ['./customerrestaurant.component.css']
})
export class CustomerrestaurantComponent {
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
  customerid: any;

  constructor(private jwtService:RestaurantsService,private admintoken:CustomerService,private route:Router,private activatedRoute: ActivatedRoute){

    
    this.menuService=jwtService;
    
      
    this.key=admintoken.token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      // console.log(genToken);
      // this.accessApi(this.adminKey);
      
      this.activatedRoute.params.subscribe((params) => {
        this.customerid = params['customer'];
        console.log('Restaurant ID:', this.customerid);
        this.getall();
      });
    });



  }
  public getall(){
    this.accessApi(this.adminKey)
    console.log(this.adminKey);
   }

   public accessApi(adminKey: any) {
    console.log('accessApi', adminKey);  
    let response = this.menuService.getAll(adminKey);
    response.subscribe((responseData: any) => {
      if (typeof responseData === 'string') {
        this.response = JSON.parse(responseData); // Parse string to array
        console.log('Response Data:', this.response);
      } else {
        console.log('Unexpected response type:', responseData);
        // Handle unexpected response if necessary
      } 
    });
  }
  backTocustomerDash(){
    this.route.navigate(['/customerdashboard',this.admintoken.customername]);
  }
  goToMenu(id:number) {
    // this.route.navigate(['/customermenu',this.customerid, id]);
    this.movetoMenu(this.customerid,id);
  }
  movetoMenu(customer:number,id:number){
    this.route.navigate(['/customermenu',customer, id]);
  }
}
