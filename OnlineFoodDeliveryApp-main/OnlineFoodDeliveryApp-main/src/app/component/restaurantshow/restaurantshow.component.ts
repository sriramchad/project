import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Restaurants } from 'src/app/model/Restaurants';
import { AdminService } from 'src/app/services/admin.service';
import { RestaurantsService } from 'src/app/services/restaurants.service';

@Component({
  selector: 'app-restaurantshow',
  templateUrl: './restaurantshow.component.html',
  styleUrls: ['./restaurantshow.component.css']
})
export class RestaurantshowComponent {
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
  

  updateid:any;
  constructor(private jwtService:RestaurantsService,admintoken:AdminService,private route:Router,private activatedRoute: ActivatedRoute){

    
    this.menuService=jwtService;
    
      this.admin=true;
      this.customer=false;
    this.key=admintoken.token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      // console.log(genToken);
      // this.accessApi(this.adminKey);
      
    });
    this.activatedRoute.params.subscribe(params => {
      this.updateid = params['id']; // 'id' should match the parameter name in the route
      // Now you have the restaurantId, and you can use it as needed
      console.log(this.updateid);
    });
  }
 
  update(formData: any) {
    console.log(formData);
    const restaurantId: number = this.updateid;
    const restaurantName: string = formData.form.value.restaurantName;
    const cuisineType: string = formData.form.value.cuisineType;
    const location: string = formData.form.value.location;
    const rating: number = formData.form.value.rating;
    // const customerIds: number[] = formData.form.value.customerIds;

  
    const updatedAdmin: Restaurants = {
      restaurantId: restaurantId,

      restaurantName: restaurantName,
      cuisineType: cuisineType,
      location: location,
      rating: rating,
      // customerIds: []
    };
  
    this.menuService.updateMenu(updatedAdmin, this.adminKey)
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
backTorestautant(){
  this.route.navigate(['/restaurants']);
}

  }
