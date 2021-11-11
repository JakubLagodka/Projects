import {Component, Inject, OnInit} from '@angular/core';
import {Reservation} from '../../_models/reservation';
import {Observable} from 'rxjs';
import {ReservationService} from '../../_services/reservation.service';
import {AppComponent} from '../../app.component';
import {TranslatorService} from '../../_services/translator.service';
import {UserService} from '../../_services/user.service';
import {User} from '../../_models/user';

@Component({
  selector: 'app-made-by-given-user',
  templateUrl: './made-by-given-user.component.html',
  styleUrls: ['./made-by-given-user.component.css']
})
export class MadeByGivenUserComponent implements OnInit {
  reservations$: Observable<Reservation[]>;

  constructor(@Inject(AppComponent) private parent: AppComponent,
              public reservationService: ReservationService,
              public translatorService: TranslatorService) { }

  ngOnInit(): void {
    this.reservations$ = this.reservationService.getReservationsByUserId(this.parent.authenticationService.currentUserValue.id);
  }
  pay(reservation: Reservation)
  {
    reservation.paid = true;
    this.reservationService.updateReservation(reservation.id, reservation);
  }

delete(reservation: Reservation)
{
  this.reservationService.deleteReservation(reservation.id);
}
}
