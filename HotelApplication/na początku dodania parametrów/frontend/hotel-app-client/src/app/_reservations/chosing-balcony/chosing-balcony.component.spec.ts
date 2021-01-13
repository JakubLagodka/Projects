import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChosingBalconyComponent } from './chosing-balcony.component';

describe('ChosingBalconyComponent', () => {
  let component: ChosingBalconyComponent;
  let fixture: ComponentFixture<ChosingBalconyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChosingBalconyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChosingBalconyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
