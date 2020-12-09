import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Reservation} from '../_models/reservation';
import {shareReplay, take} from 'rxjs/operators';
import {User} from '../_models/user';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  status = null;
  constructor( private http: HttpClient) { }

  getReservations(): Observable< Reservation[]> {
    return this.http.get< Reservation[]>(`${environment.apiUrl}/reservation`);
  }

  getReservationsById(objectId: number): Observable< Reservation[]> {
    return this.http.get< Reservation[]>(`${environment.apiUrl}/reservation?id=` + objectId);
  }

  getReservationsByUserId(userId: number): Observable< Reservation[]> {
    return this.http.get< Reservation[]>(`${environment.apiUrl}/reservation/given_user?userId=` + userId);
  }


  addReservation(reservation: Reservation): Observable< Reservation> {
    const returnedReservation = this.http.post< Reservation>(`${environment.apiUrl}/reservation/add`, reservation).pipe(shareReplay());

    returnedReservation.pipe(take(1)).subscribe(x => {
      },
      err => {
        this.status = err.status;
      });
    /*returnedReservation.pipe(take(1)).subscribe(x => {
      this.placeInArray(x);
    });*/
    return returnedReservation;
  }

  deleteReservation(reservationId: number): Observable<any> {
    return this.http.delete<any>(`${environment.apiUrl}/reservation/` + reservationId);
  }

  updateReservation(reservationId: number, reservationPatch: Reservation): Observable< Reservation> {
    return this.http.patch<Reservation>(`${environment.apiUrl}/reservation/` + reservationId, Reservation);
  }
}
