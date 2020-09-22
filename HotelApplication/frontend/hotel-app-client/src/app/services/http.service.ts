import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../app.component';
import { HotelRoom } from '../app.component';

import { HttpClient, HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  getHotels(): Observable<Array<Hotel>>{
  return this.http.get<Array<Hotel>>('http://localhost:8080/api/hotel/all');
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
