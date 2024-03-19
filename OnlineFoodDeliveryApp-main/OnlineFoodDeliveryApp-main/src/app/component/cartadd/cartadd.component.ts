import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from 'src/app/model/Cart';
import { AdminService } from 'src/app/services/admin.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cartadd',
  templateUrl: './cartadd.component.html',
  styleUrls: ['./cartadd.component.css']
})
export class CartaddComponent {
  key:any;
  response: any;
  menuService:any
  adminKey:any;
  authRequest: Cart = new Cart();
  deleteId!: number;
  getName!:String;




  admin:boolean=false;
  customer:boolean=false;

  constructor(private jwtService:CartService,admintoken:AdminService,private route:Router){

    this.menuService=jwtService;
    
      this.admin=true;
      this.customer=false;
    this.key=admintoken.token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      
      
    });
    
   }
   add(formData: any) {
    const customerId: number = formData.form.value.customerId;
    const restaurantId: number = formData.form.value.restaurantId;

    // Process the menuIds input and convert it into an array of numbers
    const menuIds: number[] = formData.form.value.menuIds
      ? formData.form.value.menuIds.split(',').map((id: string) => Number(id.trim()))
      : [];

    const price: number = formData.form.value.price;
    const quantity: number = formData.form.value.quantity;
    const total: number = formData.form.value.total;

    console.log(customerId, restaurantId, menuIds, price, quantity, total);
  
    const updatedAdmin: Cart = {
      cartId: 0,
      customerId: customerId,
      restaurantId: restaurantId,
      menuIds: menuIds,
      price: price,
      quantity: quantity,
      total: total,
    };
  
    this.menuService.add(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Cart) => {
          console.log('Updated cart is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating cart: ', error);
          // Handle error scenarios
        }
      );
  }
  backToadmindash(){
    this.route.navigate(['/admindashboard']);
  }
}
