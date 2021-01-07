import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, Subscription, interval} from 'rxjs';
import {environment} from '../../environments/environment';
import {Room} from '../_models/room';
import {User} from '../_models/user';
import {shareReplay, take} from 'rxjs/operators';
import {Data} from '../_models/data';
import {Reservation} from '../_models/reservation';
import {Parameter} from '../_models/parameter';
@Injectable({
  providedIn: 'root'
})
export class RoomService  {
  private rooms: BehaviorSubject<Data[]> = new BehaviorSubject([]);
  private availableRooms: BehaviorSubject<Data[]> = new BehaviorSubject([]);
  private rooms$: Observable<Data[]> = this.rooms.asObservable();
  private updateSubscription: Subscription;
  status = null;
  constructor( private http: HttpClient) {

  }

 /* getRooms(): Observable< Data[]> {
    if (this.rooms.value.length === 0) {
       this.http.get<Data[]>(`${environment.apiUrl}/room/all`).subscribe(x => {
        this.rooms.next(x);
      });
    }
    return this.rooms$;
  }*/
  getRooms(): Observable< Data[]> {
    return this.http.get< Data[]>(`${environment.apiUrl}/room/all`);
  }
  getAvailableRooms(startDate: string, endDate: string): Observable< Data[]> {
    this.http.get<Data[]>(`${environment.apiUrl}/room/available?startDate=` + startDate + `&endDate=` + endDate).subscribe(x => {
      this.rooms.next(x);
    });
    return this.rooms$;
  }
  bookRoom(roomId: number, from: string, numberOfDays: number): Observable<Room> {
    return this.http.get<Room>(`${environment.apiUrl}/room/booking?roomId=` + roomId + `&from=` + from + `&numberOfDays=` + numberOfDays).pipe(shareReplay());
  }
  getRoomsById(objectId: number): Observable< Room[]> {
    return this.http.get< Room[]>(`${environment.apiUrl}/room?id=` + objectId);
  }

  /*addRoom(room: Data): Observable< Data> {
    return this.http.post< Data>(`${environment.apiUrl}/room`, room);
  }*/
  addRoom(room: Data): Observable< Data> {
    const returnedData = this.http.post< Data>(`${environment.apiUrl}/room/add`, room).pipe(shareReplay());

    returnedData.pipe(take(1)).subscribe(x => {
      },
      err => {
        this.status = err.status;
      });
    /*returnedReservation.pipe(take(1)).subscribe(x => {
      this.placeInArray(x);
    });*/
    return returnedData;
  }
  deleteRoom(roomId: number): Observable<any> {
    return this.http.delete<any>(`${environment.apiUrl}/room/` + roomId);
  }

  /*updateRoom(roomId: number, roomPatch: Room): Observable< Room> {
    return this.http.patch<Room>(`${environment.apiUrl}/room/` + roomId, Room);
  }*/

}
