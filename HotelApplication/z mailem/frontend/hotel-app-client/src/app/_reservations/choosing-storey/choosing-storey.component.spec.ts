import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoosingStoreyComponent } from './choosing-storey.component';

describe('ChoosingStoreyComponent', () => {
  let component: ChoosingStoreyComponent;
  let fixture: ComponentFixture<ChoosingStoreyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChoosingStoreyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChoosingStoreyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
