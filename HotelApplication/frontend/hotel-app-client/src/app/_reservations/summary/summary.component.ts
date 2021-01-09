import {Component, Inject, OnInit} from '@angular/core';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {Reservation} from '../../_models/reservation';
import {distinct, filter, mergeMap, take, toArray} from 'rxjs/operators';
import {TranslatorService} from '../../_services/translator.service';
import {AppComponent} from '../../app.component';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {
 reservation: Reservation = new Reservation();
 hotelNight;
 parameters$;
  constructor(@Inject(AppComponent) private parent: AppComponent,
              public reservationService: ReservationService,
              private router: Router,
              public authenticationService: AuthenticationService,
              public calendarService: CalendarService,
              public translatorService: TranslatorService
              ) { }

  submit()
  {

    this.reservationService.addReservation(this.reservation).pipe(take(1)).subscribe(x => {
    });
    setTimeout(() => {
      if (this.reservationService.status !== null)
      {
        setTimeout(() => {
          this.parent.reservationNotCreated = false;
        }, 5000);
        this.parent.reservationNotCreated = true;
        this.reservationService.status = null;
      }
      else
      {
        setTimeout(() => {
          this.parent.createdNewReservation = false;
        }, 5000);
        this.parent.createdNewReservation = true;
        this.parent.sidenav.open();
        this.router.navigate(['']);
      }
    }, 50);

  }
  ngOnInit(): void {
   /* if (this.calendarService.rooms$)
    {
    this.reservation.startDate = this.calendarService.startDate;
    this.reservation.endDate = this.calendarService.endDate;
    this.reservation.numberOfDays = this.calendarService.differenceInDays;
    this.reservation.roomTypeId = this.calendarService.chosenRooms[0].id;
    this.reservation.userId = this.authenticationService.currentUserValue.id;
    this.reservation.price = this.calendarService.chosenRooms[0].priceForOneDay * this.reservation.numberOfDays;

    }
    else
    {
      setTimeout(() => {
        this.parent.lostData = false;
      }, 5000);
      this.parent.lostData = true;
      this.router.navigate(['']);
    }*/
    // console.log('summary');
    this.reservation.startDate = this.calendarService.startDate;
    this.reservation.endDate = this.calendarService.endDate;
    this.reservation.numberOfDays = this.calendarService.differenceInDays;
    this.reservation.roomTypeId = this.calendarService.room.id;
    this.reservation.userId = this.authenticationService.currentUserValue.id;
    this.reservation.price = this.calendarService.room.number13 * this.reservation.numberOfDays;
  }

dismiss()
{
  this.router.navigate(['/choosing-storey']);
}

  book() {

    this.reservationService.addReservation(this.reservation).pipe(take(1)).subscribe(x => {
    });
    setTimeout(() => {
      if (this.reservationService.status !== null)
      {
        setTimeout(() => {
          this.parent.reservationNotCreated = false;
        }, 5000);
        this.parent.reservationNotCreated = true;
        this.reservationService.status = null;
      }
      else
      {
        setTimeout(() => {
          this.parent.createdNewReservation = false;
        }, 5000);
        this.parent.createdNewReservation = true;
        this.parent.sidenav.open();
        this.router.navigate(['']);
      }
    }, 50);
  }
}
