import { Component, OnInit } from '@angular/core';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {Reservation} from '../../_models/reservation';
import {distinct, filter, mergeMap, take, toArray} from 'rxjs/operators';
import {of} from 'rxjs';
import {Room} from '../../_models/room';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {
private reservation: Reservation = new Reservation();
private room: Room[];
  constructor(public reservationService: ReservationService,
              private router: Router,
              public authenticationService: AuthenticationService,
              private calendarService: CalendarService) { }

  onSubmit()
  {
    console.log('fads');
    this.reservation.startDate = this.calendarService.range.controls.start.value;
    this.reservation.endDate = this.calendarService.range.controls.end.value;
    this.reservation.numberOfDays = this.calendarService.diff;
    this.reservation.roomNumber = this.room[0].id;
     console.log(  this.reservation.roomNumber);
    this.reservation.userId = this.authenticationService.currentUserValue.id;
    // this.reservation.price = this.calendarService.chosenRooms.pop.price * this.reservation.numberOfDays;
    // console.log( this.reservation.roomNumber);
    this.reservationService.addReservation(this.reservation).pipe(take(1)).subscribe(x => {
      // this.modal.close(x);
    });

  }
  ngOnInit(): void {
    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds),
        filter(v => v.typeOfPillow === this.calendarService.chosenPillowType),
        filter(v => v.closeToElevator === this.calendarService.chosenCloseToElevator),
        filter(v => v.balcony === this.calendarService.chosenBalcony),
        filter(v => v.beautifulViewFromTheWindows === this.calendarService.chosenBeautifulView),
        filter(v => v.storey === this.calendarService.chosenStorey),
        distinct(v => v.beautifulViewFromTheWindows),
        toArray(),
      ).subscribe(x => this.room = x);
    });
  }


}
