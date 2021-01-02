import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoosingCloseToElevatorComponent } from './choosing-close-to-elevator.component';

describe('ChoosingCloseToElevatorComponent', () => {
  let component: ChoosingCloseToElevatorComponent;
  let fixture: ComponentFixture<ChoosingCloseToElevatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChoosingCloseToElevatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChoosingCloseToElevatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
