import { Injectable, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RoomService} from './room.service';
import {Observable} from 'rxjs';
import {Room} from '../_models/room';
import {HotelNight} from '../_models/hotel-night';
import {HotelNightService} from './hotel-night.service';



@Injectable({
  providedIn: 'root'
})
export class CalendarService {
  private returned: string;
  public diff;
  rooms$: Observable<Room[]>;
  public chosenNumberOfBeds;
  public chosenCloseToElevator;
  public chosenBalcony;
  public chosenBeautifulView;
  public chosenPillowType;
  public chosenStorey;
  public chosenRooms;
  public hotelNight;
  startDate;
  endDate;
  constructor(  public roomService: RoomService,
                private hotelNightService: HotelNightService) {
     this.hotelNightService.getHotelNight().subscribe(
      x => this.hotelNight = x);
  }


  takeDates(startDate, endDate)
  {
    this.rooms$ = null;
    console.log(this.rooms$);
    startDate.setHours(this.hotelNight[0].checkInTime);
    endDate.setDate(endDate.getDate() + 1 );
    endDate.setHours(this.hotelNight[0].checkOutTime);
    this.diff = endDate.getDate() -  startDate.getDate();
    // this.start = new Date(this.range.controls.end.value);
    this.rooms$ = this.roomService.getAvailableRooms(this.convertToString(startDate), this.convertToString(endDate));
  this.startDate = startDate;
  this.endDate = endDate;

  }

  convertToString( date: Date)
  {
    this.returned = '';
    this.returned += date.getFullYear().toString().substr(0, 4);
    this.returned += '-';
    this.returned += date.getMonth() + 1;
    this.returned += '-';
    if (date.getDate() < 10) {
      this.returned += '0';
    }
    this.returned += date.getDate();

    return this.returned;
  }

}
