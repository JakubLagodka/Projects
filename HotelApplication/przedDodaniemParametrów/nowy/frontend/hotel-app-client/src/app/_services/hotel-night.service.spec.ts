import { TestBed } from '@angular/core/testing';

import { HotelNightService } from './hotel-night.service';

describe('HotelNightService', () => {
  let service: HotelNightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HotelNightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
