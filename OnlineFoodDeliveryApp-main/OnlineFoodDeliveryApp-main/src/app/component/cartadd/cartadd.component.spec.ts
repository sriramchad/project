import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartaddComponent } from './cartadd.component';

describe('CartaddComponent', () => {
  let component: CartaddComponent;
  let fixture: ComponentFixture<CartaddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CartaddComponent]
    });
    fixture = TestBed.createComponent(CartaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
