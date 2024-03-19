import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartupdateeComponent } from './cartupdatee.component';

describe('CartupdateeComponent', () => {
  let component: CartupdateeComponent;
  let fixture: ComponentFixture<CartupdateeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CartupdateeComponent]
    });
    fixture = TestBed.createComponent(CartupdateeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
