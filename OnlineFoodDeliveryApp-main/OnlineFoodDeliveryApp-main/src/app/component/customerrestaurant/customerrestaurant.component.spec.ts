import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerrestaurantComponent } from './customerrestaurant.component';

describe('CustomerrestaurantComponent', () => {
  let component: CustomerrestaurantComponent;
  let fixture: ComponentFixture<CustomerrestaurantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerrestaurantComponent]
    });
    fixture = TestBed.createComponent(CustomerrestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
