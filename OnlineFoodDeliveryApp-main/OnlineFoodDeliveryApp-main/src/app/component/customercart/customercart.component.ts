import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Cart } from 'src/app/model/Cart';
import { CartService } from 'src/app/services/cart.service';
import { CustomerService } from 'src/app/services/customer.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-customercart',
  templateUrl: './customercart.component.html',
  styleUrls: ['./customercart.component.css']
})
export class CustomercartComponent implements OnInit {
  adminKey: any;
  customerid: any;
  restarentid: any;
  cartData: any[] = [];
  response: any;
  menuService: CartService;
  key: any;
  customername: any;

  constructor(
    private jwtService: CartService,private admintoken: CustomerService,private route: Router,private activatedRoute: ActivatedRoute,private menudata: MenuService) {

      this.menuService=jwtService;
    
    this.key=admintoken.token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      
      console.log(this.adminKey);
      this.activatedRoute.params.subscribe((params) => {
        this.customername = params['id'];
        console.log('customername:', this.customername);
      });
      this.cartData = this.menudata.getCartData();
      this.add();
      this.getall()
      this.menudata.cartData=[]

    });
    
   }




    
  ngOnInit(): void {
    this.calculateTotalSum();
  }

  getall() {
    this.accessApi(this.adminKey);
    console.log(this.adminKey);
  }

  accessApi(adminKey: any) {
    console.log('accessApi', adminKey);
    let response = this.jwtService.getByCustomerId(this.customername, adminKey);
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


  add() {
     this.cartData.forEach(item => {
      const customerId: number = parseInt(item.customerId, 10);
      const restaurantId: number = parseInt(item.restaurantId, 10);
    const menuIds: number[] = [item.menuId];
    const price: number = item.price;
    const quantity: number = item.quantity;
    const total: number = item.price*item.quantity;
    
    console.log(customerId, restaurantId, menuIds, price,quantity, total);
   
  
    const updatedAdmin: Cart = {
     


      cartId:0,
   customerId:customerId,
   restaurantId:restaurantId,
   
   price:price,
   quantity: quantity,
   total:total,
   menuIds:menuIds,
  

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
     });
  }


  delete(id: number) {

    this.jwtService.delete(id, this.adminKey).subscribe((msg: any) => {
      console.log("Deleted " + msg);
    });
  }
 finalamount:any
 calculateTotalSum() {
  this.finalamount = this.response.reduce((sum: any, item: { total: any; }) => sum + item.total, 0);
  console.log(this.finalamount)
}
order(){
  this.jwtService.customerid=parseInt(this.customername, 10);
  this.jwtService.totalcost=parseInt(this.finalamount, 10);
  this.route.navigate(['/customerorder']);
}
backTocustomerDash(){
  this.route.navigate(['/customerdashboard',this.admintoken.customername]);
}

}