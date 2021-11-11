import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceptionPanelComponent } from './reception-panel.component';

describe('ReceptionPanelComponent', () => {
  let component: ReceptionPanelComponent;
  let fixture: ComponentFixture<ReceptionPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceptionPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceptionPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
