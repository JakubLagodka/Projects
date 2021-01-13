import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChosingBeatifulViewFromWindowsComponent } from './chosing-beatiful-view-from-windows.component';

describe('ChosingBeatifulViewFromWindowsComponent', () => {
  let component: ChosingBeatifulViewFromWindowsComponent;
  let fixture: ComponentFixture<ChosingBeatifulViewFromWindowsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChosingBeatifulViewFromWindowsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChosingBeatifulViewFromWindowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
