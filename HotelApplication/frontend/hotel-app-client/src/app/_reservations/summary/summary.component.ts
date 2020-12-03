import { Component, OnInit } from '@angular/core';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {Reservation} from '../../_models/reservation';
import {distinct, filter, mergeMap, take, toArray} from 'rxjs/operators';
import {TranslatorService} from '../../_services/translator.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {
 reservation: Reservation = new Reservation();
 hotelNight;
  constructor(public reservationService: ReservationService,
              private router: Router,
              public authenticationService: AuthenticationService,
              public calendarService: CalendarService,
              public translatorService: TranslatorService
              ) { }

  submit()
  {

    this.reservationService.addReservation(this.reservation).pipe(take(1)).subscribe(x => {
    });
    this.router.navigate(['']);
  }
  ngOnInit(): void {
    this.reservation.startDate = this.calendarService.startDate;
    this.reservation.endDate = this.calendarService.endDate;
    this.reservation.numberOfDays = this.calendarService.diff;
    this.reservation.roomNumber = this.calendarService.chosenRooms[0].id;
    this.reservation.userId = this.authenticationService.currentUserValue.id;
    this.reservation.price = this.calendarService.chosenRooms[0].priceForOneDay * this.reservation.numberOfDays;
    console.log(this.reservation.startDate);
  }
dismiss(){}

}
