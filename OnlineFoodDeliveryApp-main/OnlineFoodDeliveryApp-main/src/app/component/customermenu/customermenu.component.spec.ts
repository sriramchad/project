import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomermenuComponent } from './customermenu.component';

describe('CustomermenuComponent', () => {
  let component: CustomermenuComponent;
  let fixture: ComponentFixture<CustomermenuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustomermenuComponent]
    });
    fixture = TestBed.createComponent(CustomermenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
