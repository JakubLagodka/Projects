import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OccupacyPreviewComponent } from './occupacy-preview.component';

describe('OccupacyPreviewComponent', () => {
  let component: OccupacyPreviewComponent;
  let fixture: ComponentFixture<OccupacyPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OccupacyPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OccupacyPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
