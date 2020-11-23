import { TestBed } from '@angular/core/testing';

import { DatepickerPlService } from './datepicker-pl.service';

describe('DatepickerPlService', () => {
  let service: DatepickerPlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DatepickerPlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
