import {Injectable, OnDestroy} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {HotelNight} from '../_models/hotel-night';
import {Role} from '../_models/role';
import {AuthenticationService} from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HotelNightService implements OnDestroy{

  constructor(private http: HttpClient,
              public authenticationService: AuthenticationService) { }

  getHotelNight(): Observable< HotelNight[]> {
    if (this.authenticationService.isUserLoggedIn) {
      return this.http.get< HotelNight[]>(`${environment.apiUrl}/hotel_night`);
    }

    return new Observable< HotelNight[]>();
  }

  ngOnDestroy() {

  }
}
