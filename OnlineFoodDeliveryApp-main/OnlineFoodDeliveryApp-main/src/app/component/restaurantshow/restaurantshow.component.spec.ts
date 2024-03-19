import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantshowComponent } from './restaurantshow.component';

describe('RestaurantshowComponent', () => {
  let component: RestaurantshowComponent;
  let fixture: ComponentFixture<RestaurantshowComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RestaurantshowComponent]
    });
    fixture = TestBed.createComponent(RestaurantshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
