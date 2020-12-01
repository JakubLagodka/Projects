import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {of} from 'rxjs';
import {distinct, filter, mergeMap, toArray} from 'rxjs/operators';

@Component({
  selector: 'app-choosing-pillow-type',
  templateUrl: './choosing-pillow-type.component.html',
  styleUrls: ['./choosing-pillow-type.component.css']
})
export class ChoosingPillowTypeComponent implements OnInit {

  pillowType;
  pillowTypeControl = new FormControl('', Validators.required);

  constructor(private router: Router, private calendarService: CalendarService) { }

  ngOnInit(): void {

     this.calendarService.rooms$.subscribe(rooms => {
          of(rooms).pipe(
          mergeMap(x => rooms), filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds),
          distinct(v => v.typeOfPillow),
          toArray(),
        ).subscribe(x => this.pillowType = x);
      });
  }
  onSubmit()
  {
    this.calendarService.chosenPillowType = this.pillowTypeControl.value;

    this.router.navigate(['/choosing-close-to-elevator']);

  }
}
