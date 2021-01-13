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
export class HotelNightService {
  private roles: BehaviorSubject<HotelNight[]> = new BehaviorSubject([]);
  private roles$: Observable<HotelNight[]> = this.roles.asObservable();
  constructor(private http: HttpClient,
              public authenticationService: AuthenticationService) { }

  getHotelNight(): Observable< HotelNight[]> {
    if (this.authenticationService.isUserLoggedIn) {
       this.http.get<HotelNight[]>(`${environment.apiUrl}/hotel_night`).subscribe(x => {
        this.roles.next(x);
      });

    }
    return this.roles$;
  }
}
