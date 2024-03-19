import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantaddComponent } from './restaurantadd.component';

describe('RestaurantaddComponent', () => {
  let component: RestaurantaddComponent;
  let fixture: ComponentFixture<RestaurantaddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RestaurantaddComponent]
    });
    fixture = TestBed.createComponent(RestaurantaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
