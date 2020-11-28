import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Room} from '../_models/room';
import {User} from '../_models/user';
import {shareReplay, take} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class RoomService {
  private rooms: BehaviorSubject<Room[]> = new BehaviorSubject([]);
  private availableRooms: BehaviorSubject<Room[]> = new BehaviorSubject([]);
  private rooms$: Observable<Room[]> = this.rooms.asObservable();

  constructor( private http: HttpClient) { }



  getRooms(): Observable< Room[]> {
    if (this.rooms.value.length === 0) {
       this.http.get<Room[]>(`${environment.apiUrl}/room`).subscribe(x => {
        this.rooms.next(x);
      });
    }
    return this.rooms$;
  }
  getAvailableRooms(from: string, numberOfDays: number): Observable< Room[]> {
    this.http.get<Room[]>(`${environment.apiUrl}/room/available?from=` + from + `&numberOfDays=` + numberOfDays).subscribe(x => {
      this.rooms.next(x);
    });
    return this.rooms$;
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

  updateRoom(roomId: number, roomPatch: Room): Observable< Room> {
    return this.http.patch<Room>(`${environment.apiUrl}/room/` + roomId, Room);
  }

}
