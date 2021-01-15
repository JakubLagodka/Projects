import {Component, Inject, OnInit} from '@angular/core';
import {Reservation} from '../../_models/reservation';
import {AppComponent} from '../../app.component';
import {ReservationService} from '../../_services/reservation.service';
import {TranslatorService} from '../../_services/translator.service';
import {Observable} from 'rxjs';
import {User} from '../../_models/user';
import {UserService} from '../../_services/user.service';

@Component({
  selector: 'app-occupacy-preview',
  templateUrl: './occupacy-preview.component.html',
  styleUrls: ['./occupacy-preview.component.css']
})
export class OccupacyPreviewComponent implements OnInit {
  reservations$: Observable<Reservation[]>;
  users$: Observable<User[]>;
  returned;
  constructor(@Inject(AppComponent) private parent: AppComponent,
              public reservationService: ReservationService,
              public translatorService: TranslatorService,
              public userService: UserService) { }

  ngOnInit(): void {
    this.reservations$ = this.reservationService.getReservations();
    this.users$ = this.userService.getUsers();
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
