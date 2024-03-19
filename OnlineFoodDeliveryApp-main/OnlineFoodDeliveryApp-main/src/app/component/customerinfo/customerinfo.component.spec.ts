import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerinfoComponent } from './customerinfo.component';

describe('CustomerinfoComponent', () => {
  let component: CustomerinfoComponent;
  let fixture: ComponentFixture<CustomerinfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerinfoComponent]
    });
    fixture = TestBed.createComponent(CustomerinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
