import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CalendarMaterialComponent } from './calendar.component';

describe('CalendarComponent', () => {
  let component: CalendarMaterialComponent;
  let fixture: ComponentFixture<CalendarMaterialComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CalendarMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalendarMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
