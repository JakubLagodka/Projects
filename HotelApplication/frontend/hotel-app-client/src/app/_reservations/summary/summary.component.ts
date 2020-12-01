import { Component, OnInit } from '@angular/core';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {Reservation} from '../../_models/reservation';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {
private reservation: Reservation;
  constructor(public reservationService: ReservationService,
              private router: Router,
              public authenticationService: AuthenticationService,
              private calendarService: CalendarService) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    this.reservation.startDate = this.calendarService.range.controls.start.value;
    this.reservation.endDate = this.calendarService.range.controls.end.value;
    this.reservation.numberOfDays = this.calendarService.diff;
    this.reservation.roomNumber = this.calendarService.choosenRooms.pop.id;
    this.reservation.userId = this.authenticationService.currentUserValue.id;
    this.reservation.price = this.calendarService.choosenRooms.pop.price * this.reservation.numberOfDays;
    this.reservationService.addReservation(this.reservation);
  }

}
