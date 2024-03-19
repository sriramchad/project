import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from 'src/app/model/Cart';
import { AdminService } from 'src/app/services/admin.service';
import { CartService } from 'src/app/services/cart.service';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

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
      
      this.getall();
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


  isAddFormVisible: boolean = false;
  addForm() {
    this.isAddFormVisible = !this.isAddFormVisible;
  }
  isDeleteFormVisible: boolean = false;
  deleteForm() {
    this.isDeleteFormVisible = !this.isDeleteFormVisible;
  }
  isGetFormNameVisible: boolean = false;
  getFormName() {
    this.isGetFormNameVisible = !this.isGetFormNameVisible;
  }
  isUpdateFormVisible: boolean = false;
  updateForm() {
    this.isUpdateFormVisible = !this.isUpdateFormVisible;
  }


  add(formData: any) {
    const customerId: number = formData.form.value.customerId;
    const restaurantId: number = formData.form.value.restaurantId;
    const menuIds: number[] = formData.form.value.menuIds;
    const price: number = formData.form.value.price;
    const quantity: number = formData.form.value.quantity;
    const total: number = formData.form.value.total;
    
    console.log(customerId, restaurantId, menuIds, price,quantity, total);
   
  
    const updatedAdmin: Cart = {
     


      cartId:0,
   customerId:customerId,
   restaurantId:restaurantId,
   menuIds:menuIds,
   price:price,
   quantity: quantity,
   total:total,
  

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

  delete(id: number) {

    this.jwtService.delete(id, this.adminKey).subscribe((msg: any) => {
      console.log("Deleted " + msg);
    });
  }
  
  update(formData: any) {
    console.log(formData.value);
    const cartId: number = formData.form.value.cartId;

    const customerId: number = formData.form.value.customerId;
    const restaurantId: number = formData.form.value.restaurantId;
    const menuIds: number[] = formData.form.value.menuIds;
    const price: number = formData.form.value.price;
    const quantity: number = formData.form.value.quantity;
    const total: number = formData.form.value.total;
    

  
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
backToadminDash(){
  this.route.navigate(['/admindashboard']);
}
goToUpdate(cartId: number) {
  this.route.navigate(['/cartupdate', cartId]);
}
}
