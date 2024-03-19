import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customerinfo',
  templateUrl: './customerinfo.component.html',
  styleUrls: ['./customerinfo.component.css']
})
export class CustomerinfoComponent {
  customername: any;
  menuService: CustomerService;
  adminKey: any;
  response: any;
  public responseDataArray: any[] = [];


  constructor(private jwtService: CustomerService,private admintoken: CustomerService, private route: Router, private activatedRoute: ActivatedRoute) {
    this.menuService = jwtService;
    admintoken.token.subscribe((genToken: any) => {
      this.adminKey = genToken;
      console.log('Admin Key:', this.adminKey);

      // Check if adminKey is defined before making the API call
      if (this.adminKey) {
        this.activatedRoute.params.subscribe((params) => {
          this.customername = params['id'];
          console.log('customername:', this.customername);
          this.getbyname();
        });
      } else {
        console.error('Admin key is null.');
      }
    });
  }

  getbyname() {
    if (this.adminKey) {
      let response = this.menuService.getcustomer(
        this.customername,
        this.adminKey
      );
  
      response.subscribe((responseData: any) => {
        if (responseData && typeof responseData === 'string') {
          this.response = JSON.parse(responseData);
          console.log('Response Data:', this.response);
  
          // Convert object properties to an array, excluding the 'password' property
          this.responseDataArray = Object.keys(this.response)
            .filter(key => key !== 'password')
            .map(key => ({ key, value: this.response[key] }));
        } else {
          console.log('Unexpected response type:', responseData);
          // Handle unexpected response if necessary
        }
      });
    } else {
      console.error('Admin key is null.');
    }
  }
  backTocustomerDash(){
    this.route.navigate(['/customerdashboard',this.admintoken.customername]);
  }
}