import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {of} from 'rxjs';
import {distinct, filter, mergeMap, toArray} from 'rxjs/operators';

@Component({
  selector: 'app-chosing-balcony',
  templateUrl: './chosing-balcony.component.html',
  styleUrls: ['./chosing-balcony.component.css']
})
export class ChosingBalconyComponent implements OnInit {

  balcony;
  balconyControl = new FormControl('', Validators.required);

  constructor( public reservationService: ReservationService,
               private router: Router,
               public authenticationService: AuthenticationService,
               private calendarService: CalendarService) { }

  ngOnInit(): void {

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds.value),
        filter(v => v.closeToElevator === this.calendarService.chosenCloseToElevator.value),
        distinct(v => v.balcony),
        toArray(),
      ).subscribe(x => this.balcony = x);
    });
  }
  onSubmit()
  {
    this.calendarService.chosenBalcony = this.balcony;

    this.router.navigate(['/choosing-balcony']);

  }
}
