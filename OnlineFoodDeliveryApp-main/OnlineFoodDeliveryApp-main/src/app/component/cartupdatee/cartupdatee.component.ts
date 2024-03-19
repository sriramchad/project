import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from 'src/app/model/Cart';
import { AdminService } from 'src/app/services/admin.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cartupdatee',
  templateUrl: './cartupdatee.component.html',
  styleUrls: ['./cartupdatee.component.css']
})
export class CartupdateeComponent {
  key:any;
  response: any;
  menuService:any
  adminKey:any;
  authRequest: Cart = new Cart();
  deleteId!: number;
  getName!:String;




  admin:boolean=false;
  customer:boolean=false;

  updateid:any;
  constructor(private jwtService:CartService,admintoken:AdminService,private route:Router,private activatedRoute: ActivatedRoute){

    this.menuService=jwtService;
    
      this.admin=true;
      this.customer=false;
    this.key=admintoken.token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      
      
    });
    this.activatedRoute.params.subscribe(params => {
      this.updateid = params['id']; // 'id' should match the parameter name in the route
      // Now you have the restaurantId, and you can use it as needed
      console.log(this.updateid);
    });
   }
    
   update(formData: any) {
    console.log(formData.value);
    const cartId: number = this.updateid;

    const customerId: number = formData.form.value.customerId;
    const restaurantId: number = formData.form.value.restaurantId;
    const menuIds: number[] = formData.form.value.menuIds
    ? formData.form.value.menuIds.split(',').map((id: string) => Number(id.trim()))
    : [];
  const price: number = formData.form.value.price;
    const quantity: number = formData.form.value.quantity;
    const total: number = formData.form.value.total;
    
console.log(cartId,customerId,restaurantId,restaurantId,menuIds,price,quantity,total);
  
    const updatedAdmin: Cart = {
      
      cartId:cartId,
   customerId:customerId,
   restaurantId:restaurantId,
   menuIds:menuIds,
   price:price,
   quantity: quantity,
   total:total,
   
    };
  
    this.menuService.updateMenu(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Cart) => {
          console.log('Updated Admin is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating Admin: ', error);
          // Handle error scenarios
        }
      );



}
backToCart(){
  this.route.navigate(['/cart']);
}

   }



