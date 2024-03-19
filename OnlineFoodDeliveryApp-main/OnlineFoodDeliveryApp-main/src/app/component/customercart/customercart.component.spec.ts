import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomercartComponent } from './customercart.component';

describe('CustomercartComponent', () => {
  let component: CustomercartComponent;
  let fixture: ComponentFixture<CustomercartComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomercartComponent]
    });
    fixture = TestBed.createComponent(CustomercartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
