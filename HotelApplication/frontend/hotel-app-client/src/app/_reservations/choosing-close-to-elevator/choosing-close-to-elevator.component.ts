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

  constructor( private router: Router, private calendarService: CalendarService) { }

  ngOnInit(): void {

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds),
        filter(v => v.typeOfPillow === this.calendarService.chosenPillowType),
        distinct(v => v.closeToElevator),
        toArray(),
      ).subscribe(x => this.closeToElevator = x);
    });
  }
  submit()
  {
    this.calendarService.chosenCloseToElevator = this.closeToElevatorControl.value;

    this.router.navigate(['/choosing-balcony']);

  }
  dismiss(){}
}
