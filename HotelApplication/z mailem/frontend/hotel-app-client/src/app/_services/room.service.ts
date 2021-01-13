import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, Subscription, interval} from 'rxjs';
import {environment} from '../../environments/environment';
import {Room} from '../_models/room';
import {User} from '../_models/user';
import {shareReplay, take} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class RoomService  {
  private rooms: BehaviorSubject<Room[]> = new BehaviorSubject([]);
  private availableRooms: BehaviorSubject<Room[]> = new BehaviorSubject([]);
  private rooms$: Observable<Room[]> = this.rooms.asObservable();
  private updateSubscription: Subscription;
  constructor( private http: HttpClient) {

  }

  getRooms(): Observable< Room[]> {
    if (this.rooms.value.length === 0) {
       this.http.get<Room[]>(`${environment.apiUrl}/room`).subscribe(x => {
        this.rooms.next(x);
      });
    }
    return this.rooms$;
  }
  getAvailableRooms(startDate: string, endDate: string): Observable< Room[]> {
    this.http.get<Room[]>(`${environment.apiUrl}/room/available?startDate=` + startDate + `&endDate=` + endDate).subscribe(x => {
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

  createRoom(room: Room): Observable< Room> {
    return this.http.post< Room>(`${environment.apiUrl}/room`, room);
  }

  deleteRoom(roomId: number): Observable<any> {
    return this.http.delete<any>(`${environment.apiUrl}/room/` + roomId);
  }

  /*updateRoom(roomId: number, roomPatch: Room): Observable< Room> {
    return this.http.patch<Room>(`${environment.apiUrl}/room/` + roomId, Room);
  }*/

}
