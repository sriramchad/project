import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from 'src/app/model/Menu';
import { AdminService } from 'src/app/services/admin.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-menuadd',
  templateUrl: './menuadd.component.html',
  styleUrls: ['./menuadd.component.css']
})
export class MenuaddComponent {
  key:any;
  response: any;
  menuService:any
  adminKey:any;
  authRequest: Menu = new Menu();
  deleteId!: number;
  getName!:String;
  getresponseName:any;


 admin:boolean=false;
 customer:boolean=false;

 constructor(private jwtService:MenuService,admintoken:AdminService,private route:Router){

   
   this.menuService=jwtService;
   
     this.admin=true;
     this.customer=false;
   this.key=admintoken.token;
   this.key.subscribe((genToken: any) => {
     this.adminKey = genToken;
     
     
   });
 }




  add(formData: any) {
    const restaurantId: number = formData.form.value.restaurantId;
    const itemName: string = formData.form.value.itemName;
    
  
    const description: string = formData.form.value.description;
  
    const price: number = formData.form.value.price;

  
    const updatedAdmin: Menu = {
      
      restaurantId: restaurantId,
      itemName: itemName,
      description: description,
      price: price,
      menuItemId: 0
    };
  
    this.menuService.add(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Menu) => {
          console.log('Updated Admin is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating Admin: ', error);
          // Handle error scenarios
        }
      );
  }

  backToadmindash(){
    this.route.navigate(['/admindashboard']);
  }

}
