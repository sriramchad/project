import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Orders } from 'src/app/model/Orders';
import { AdminService } from 'src/app/services/admin.service';
import { CustomerService } from 'src/app/services/customer.service';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent {
  key:any;
  response: any;
  menuService:any
  adminKey:any;
  authRequest: Orders = new Orders();
  deleteId!: number;
  getName!:String;
  getresponseName:any;
 

  admin:boolean=false;
  customer:boolean=false;

  constructor(private jwtService:OrdersService,admintoken:AdminService,private route:Router){

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
  isaddFormVisible: boolean = false;
  addForm() {
    this.isaddFormVisible = !this.isaddFormVisible;
  }
  isdeleteFormVisible: boolean = false;
  deleteForm() {
    this.isdeleteFormVisible = !this.isdeleteFormVisible;
  }
  isgetFormNameVisible: boolean = false;
  getFormName() {
    this.isgetFormNameVisible = !this.isgetFormNameVisible;
  }
  isupdateFormVisible: boolean = false;
  updateForm() {
    this.isupdateFormVisible = !this.isupdateFormVisible;
  }


  add(formData: any) {
    const customerId: number = formData.form.value.customerId;
    const restaurantId: number = formData.form.value.restaurantId;
    const deliveryAddress: string = formData.form.value.deliveryAddress;
    
  
    const paymentMethod: string = formData.form.value.paymentMethod;
  
    const totalAmount: number = formData.form.value.totalAmount;

  
    const updatedAdmin: Orders = {
      cartId:0,
      customerId: customerId,
      restaurantId: restaurantId,
      deliveryAddress: deliveryAddress,
      paymentMethod: paymentMethod,
      totalAmount: totalAmount
    };
    
  
    this.menuService.add(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Orders) => {
          console.log('Updated Admin is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating Admin: ', error);
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
    const cartId: number = formData.form.value.cartId;

    const customerId: number = formData.form.value.customerId;
    const restaurantId: number = formData.form.value.restaurantId;
    const deliveryAddress: string = formData.form.value.deliveryAddress;
    
  
    const paymentMethod: string = formData.form.value.paymentMethod;
  
    const totalAmount: number = formData.form.value.totalAmount;

  
    const updatedAdmin: Orders = {
      
      cartId:cartId,
      customerId: customerId,
      restaurantId: restaurantId,
      deliveryAddress: deliveryAddress,
      paymentMethod: paymentMethod,
      totalAmount: totalAmount
    };
  
    this.menuService.update(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Orders) => {
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

}
