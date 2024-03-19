import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { CustomerService } from 'src/app/services/customer.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-customerheader',
  templateUrl: './customerheader.component.html',
  styleUrls: ['./customerheader.component.css']
})
export class CustomerheaderComponent {
  constructor(
    private jwtService: CartService,private admintoken: CustomerService,private route: Router,private activatedRoute: ActivatedRoute,private menudata: MenuService){}
  customerhome(){
    
    this.route.navigate(['/customerdashboard',this.admintoken.customername]);
  }
}
