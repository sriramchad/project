import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerheaderComponent } from './customerheader.component';

describe('CustomerheaderComponent', () => {
  let component: CustomerheaderComponent;
  let fixture: ComponentFixture<CustomerheaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomerheaderComponent]
    });
    fixture = TestBed.createComponent(CustomerheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
