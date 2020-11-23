import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../app.component';
import { HotelRoom } from '../app.component';

import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  getHotels(): Observable<Array<User>>{
  return this.http.get<Array<User>>(`${environment.apiUrl}/user/all`);
  }

  getHotel(hotelId: number){

  }

  addHotel(hotel: Hotel){

  }

  updateHotel(hotel: Hotel){

  }

  deleteHotel(hotelId: number){

  }

  changeHotel(hotel: Hotel){

  }
}
