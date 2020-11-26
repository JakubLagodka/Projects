import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Reservation} from '../_models/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor( private http: HttpClient) { }

  get Reservations(): Observable< Reservation[]> {
    return this.http.get< Reservation[]>(`${environment.apiUrl}/reservation`);
  }

  getReservationsById(objectId: number): Observable< Reservation[]> {
    return this.http.get< Reservation[]>(`${environment.apiUrl}/reservation?id=` + objectId);
  }

  createReservation(reservation: Reservation): Observable< Reservation> {
    return this.http.post< Reservation>(`${environment.apiUrl}/reservation`, reservation);
  }

  deleteReservation(reservationId: number): Observable<any> {
    return this.http.delete<any>(`${environment.apiUrl}/reservation/` + reservationId);
  }

  updateReservation(reservationId: number, reservationPatch: Reservation): Observable< Reservation> {
    return this.http.patch<Reservation>(`${environment.apiUrl}/reservation/` + reservationId, Reservation);
  }
}
