import { Component } from '@angular/core';
import { Admin } from 'src/app/model/Admin';
import { AdminService } from 'src/app/services/admin.service';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(private  admintoken:AdminService,private customertoken: CustomerService){
    this.admintoken.token=''
    this.customertoken.token=''
  }




 
 






}
