import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurants } from 'src/app/model/Restaurants';
import { AdminService } from 'src/app/services/admin.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-restaurantadd',
  templateUrl: './restaurantadd.component.html',
  styleUrls: ['./restaurantadd.component.css']
})
export class RestaurantaddComponent {
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

  constructor(private jwtService:RestaurantsService,admintoken:AdminService,private route:Router){

    
    this.menuService=jwtService;
    
      this.admin=true;
      this.customer=false;
    this.key=admintoken.token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      // console.log(genToken);
      // this.accessApi(this.adminKey);
    });
  }

  add(formData: any) {
    console.log(formData);
    const restaurantName: string = formData.form.value.restaurantName;
    const cuisineType: string = formData.form.value.cuisineType;
    const location: string = formData.form.value.location;
    const rating: number = formData.form.value.rating;
    // const customerIds: [] = formData.form.value.customerIds;
  
  
  

    const updatedAdmin: Restaurants = {
      restaurantId: 0,
      restaurantName: restaurantName,
      cuisineType: cuisineType,
      location: location,
      rating: rating,
      // customerIds: customerIds
      
    };
    console.log(updatedAdmin);
    this.menuService.addAdmin(updatedAdmin, this.adminKey)
    
      .subscribe(
        (updatedAdmin: Restaurants) => {
          console.log('Updated Restaurant is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating Restaurant: ', error);
          // Handle error scenarios
        }
      );
  }
  backToRestaurant(){
  this.route.navigate(['/admindashboard']);
}
}
