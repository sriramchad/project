import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Orders } from 'src/app/model/Orders';
import { CustomerService } from 'src/app/services/customer.service';
import { OrdersService } from 'src/app/services/orders.service';
import { CartComponent } from '../cart/cart.component';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-customerorder',
  templateUrl: './customerorder.component.html',
  styleUrls: ['./customerorder.component.css']
})
export class CustomerorderComponent {
  key: any;
  adminKey: any;
  customerid: any;
  menuService: OrdersService;
  finalcost: any;

  constructor(
    private jwtService: OrdersService,private admintoken: CustomerService,private router: Router,private activatedRoute: ActivatedRoute,private cart:CartService) {
      this.menuService=jwtService;
      this.key=admintoken.token;
      this.key.subscribe((genToken: any) => {
        this.adminKey = genToken;
        
        console.log(this.adminKey);
        

      });
  }

  add(formData: any) {
    const deliveryAddress: string = formData.form.value.deliveryAddress;
    
  
    const paymentMethod: string = formData.form.value.paymentMethod;
  

  
    const updatedAdmin: Orders = {
      cartId:0,
      customerId: this.cart.customerid,
      restaurantId: 200,
      deliveryAddress: deliveryAddress,
      paymentMethod: paymentMethod,
      totalAmount: this.cart.totalcost
      
    };
    console.log(updatedAdmin)
    console.log(typeof(updatedAdmin.customerId));

  
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



  showorders(){
    this.router.navigate(['/customerdashboard',this.admintoken.customername]);

    // this.router.navigate(['/showallorders']);

  }

}

