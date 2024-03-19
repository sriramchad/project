import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Menu } from 'src/app/model/Menu';
import { AdminService } from 'src/app/services/admin.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-menuupdate',
  templateUrl: './menuupdate.component.html',
  styleUrls: ['./menuupdate.component.css']
})
export class MenuupdateComponent {
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

 updateid:any;

 constructor(private jwtService:MenuService,admintoken:AdminService,private route:Router,private activatedRoute: ActivatedRoute){

   
   this.menuService=jwtService;
   
     this.admin=true;
     this.customer=false;
   this.key=admintoken.token;
   this.key.subscribe((genToken: any) => {
     this.adminKey = genToken;
     
     
   });
   this.activatedRoute.params.subscribe(params => {
    this.updateid = params['id']; // 'id' should match the parameter name in the route
    // Now you have the restaurantId, and you can use it as needed
    console.log(this.updateid);
  });
 }

 update(formData: any) {
  const menuItemId: number = this.updateid;
  const restaurantId: number = formData.form.value.restaurantId;
  const itemName: string = formData.form.value.itemName;
  

  const description: string = formData.form.value.description;

  const price: number = formData.form.value.price;


  const updatedAdmin: Menu = {
    
    restaurantId: restaurantId,
    itemName: itemName,
    description: description,
    price: price,
    menuItemId: menuItemId
  };

  this.menuService.update(updatedAdmin, this.adminKey)
    .subscribe(
      (updatedAdmin: Menu) => {
        console.log('Updated Admin is: ', updatedAdmin);
      },
      (error: any) => {
        console.error('Error updating Admin: ', error);
      }
    );
}

backToMenu(){
  this.route.navigate(['/menu']);
}

}
