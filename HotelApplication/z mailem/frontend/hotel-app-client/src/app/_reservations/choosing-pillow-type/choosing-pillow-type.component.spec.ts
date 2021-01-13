import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoosingPillowTypeComponent } from './choosing-pillow-type.component';

describe('ChoosingPillowTypeComponent', () => {
  let component: ChoosingPillowTypeComponent;
  let fixture: ComponentFixture<ChoosingPillowTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChoosingPillowTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChoosingPillowTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
