import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MadeByGivenUserComponent } from './made-by-given-user.component';

describe('MadeByGivenUserComponent', () => {
  let component: MadeByGivenUserComponent;
  let fixture: ComponentFixture<MadeByGivenUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MadeByGivenUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MadeByGivenUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
