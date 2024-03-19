import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent {
  customername: any;
  menuService: CustomerService;
  response: any;

  constructor(private jwtService: CustomerService, admintoken: CustomerService, private route: Router, private activatedRoute: ActivatedRoute) {
    this.menuService = jwtService;
    admintoken.token.subscribe((genToken: any) => {
      this.getbyname(genToken); // Pass the adminKey to getbyname
    });

    this.activatedRoute.params.subscribe((params) => {
      this.customername = params['id'];
      console.log('customername:', this.customername);
    });
  }

  transfer() {
    this.gotouserinfo(this.customername);
  }

  gotouserinfo(name: string) {
    this.route.navigate(['/customerinfo', name]);
  }

  gotorestaurant(){
    this.route.navigate(['/customerrestaurant',this.response.customerId]);
  }
  gotocart(){
    this.route.navigate(['/customercart',this.response.customerId]);
  }

  getbyname(adminKey: string) { // Accept adminKey as a parameter
    if (adminKey) {
      let response = this.menuService.getcustomer(this.customername, adminKey);

      response.subscribe((responseData: any) => {
        if (responseData && typeof responseData === 'string') {
          this.response = JSON.parse(responseData);
          console.log('Response Data:', this.response);

          // Convert object properties to an array, excluding the 'password' property

        }
      });
    } else {
      console.error('Admin key is null.');
    }
  }
  showorders(){
    this.route.navigate(['/showallorders',this.response.customerId]);

  }
  
}
