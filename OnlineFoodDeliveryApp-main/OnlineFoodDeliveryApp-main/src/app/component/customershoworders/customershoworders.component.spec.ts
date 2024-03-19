import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomershowordersComponent } from './customershoworders.component';

describe('CustomershowordersComponent', () => {
  let component: CustomershowordersComponent;
  let fixture: ComponentFixture<CustomershowordersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomershowordersComponent]
    });
    fixture = TestBed.createComponent(CustomershowordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
