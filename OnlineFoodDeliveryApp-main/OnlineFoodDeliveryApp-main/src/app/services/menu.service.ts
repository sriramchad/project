  import { HttpClient, HttpHeaders } from '@angular/common/http';
  import { Injectable } from '@angular/core';
  import { Menu } from '../model/Menu';
  import { Observable } from 'rxjs';

  @Injectable({
    providedIn: 'root'
  })
  export class MenuService {
    cartData: any[] = [];

    constructor(private http:HttpClient) { }
    baseURL:string = 'http://localhost:8185/';
    getAll(token:any){
  console.log('In Menu Service: GET ALL');
  console.log(token);
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    return this.http.get(this.baseURL+"Menu/getAllMenu",{headers,responseType:'text' as 'json'});

  }

  addToCart(customerId: number, restaurantId: number, menuId: number, price: number, quantity: number) {
    const cartItem = {
      customerId,
      restaurantId,
      menuId,
      price,
      quantity
    };
    this.cartData.push(cartItem);
  }
  getCartData() {
    
    console.log( this.cartData);
    return this.cartData;
  }

  add(add: Menu, token: string): Observable<Menu> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<Menu>(`${this.baseURL}Menu/addMenu`, add, { headers });
  }


  delete(Id: number, token: any): Observable<string> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete<string>(`${this.baseURL}Menu/deleteById/${Id}`, { headers });
  }

  getName(Name: String, token: any): Observable<Menu> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Menu>(`${this.baseURL}Menu/getByItemName/${Name}`, { headers });
  }
  getRestaurantId(Name: number, token: any) {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`${this.baseURL}Menu/getByRestaurantId/${Name}`, { headers,responseType:'text' as 'json' });
  }
  update(update: Menu, token: string): Observable<Menu> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<Menu>(`${this.baseURL}Menu/updateMenu`,update, { headers });
  }

  }
