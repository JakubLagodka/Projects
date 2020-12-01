import { Component, OnInit } from '@angular/core';
import {of} from 'rxjs';
import {distinct, filter, mergeMap, toArray} from 'rxjs/operators';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-choosing-close-to-elevator',
  templateUrl: './choosing-close-to-elevator.component.html',
  styleUrls: ['./choosing-close-to-elevator.component.css']
})
export class ChoosingCloseToElevatorComponent implements OnInit {

  closeToElevator;
  closeToElevatorControl = new FormControl('', Validators.required);

  constructor( public reservationService: ReservationService,
               private router: Router,
               public authenticationService: AuthenticationService,
               private calendarService: CalendarService) { }

  ngOnInit(): void {

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds.value),
        distinct(v => v.closeToElevator),
        toArray(),
      ).subscribe(x => this.closeToElevator = x);
    });
  }
  onSubmit()
  {
    this.calendarService.chosenCloseToElevator = this.closeToElevatorControl;

    this.router.navigate(['/choosing-beautiful-view-from-windows']);

  }
}
