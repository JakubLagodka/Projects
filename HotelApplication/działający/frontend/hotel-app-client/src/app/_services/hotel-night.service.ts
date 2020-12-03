import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {HotelNight} from '../_models/hotel-night';

@Injectable({
  providedIn: 'root'
})
export class HotelNightService {

  constructor(private http: HttpClient) { }

  getHotelNight(): Observable< HotelNight[]> {
    return this.http.get< HotelNight[]>(`${environment.apiUrl}/hotel_night`);
  }
}
