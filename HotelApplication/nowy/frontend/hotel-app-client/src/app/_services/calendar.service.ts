import {Injectable, Output, EventEmitter, OnInit} from '@angular/core';
import {RoomService} from './room.service';
import {Observable} from 'rxjs';
import {Room} from '../_models/room';
import {HotelNightService} from './hotel-night.service';



@Injectable({
  providedIn: 'root'
})
export class CalendarService {
  private returned: string;
   differenceInDays;
  rooms$: Observable<Room[]>;
  public chosenNumberOfBeds;
  public chosenCloseToElevator;
  public chosenBalcony;
  public chosenBeautifulView;
  public chosenPillowType;
  public chosenStorey;
  public chosenRooms;
  public hotelNight = null;
  differenceInTime;
  startDate;
  endDate;
  constructor(  public roomService: RoomService,
                private hotelNightService: HotelNightService) {

    this.hotelNightService.getHotelNight().subscribe(
      x => {this.hotelNight = x; } );
  }


  public getHotelNight(){
  this.hotelNightService.getHotelNight().subscribe(
    x => this.hotelNight = x);
}
  takeDates(startDate, endDate)
  {

    this.getHotelNight();
    this.rooms$ = null;
    startDate.setHours(this.hotelNight[0].checkInTime);
    if (startDate.getDate() === endDate.getDate()) {
    endDate.setDate(endDate.getDate() + 1 );
    }
    endDate.setHours(this.hotelNight[0].checkOutTime);
    this.differenceInTime = endDate.getTime() - startDate.getTime();
    this.differenceInDays = Math.ceil(this.differenceInTime / (1000 * 24 * 60 * 60));
    this.rooms$ = this.roomService.getAvailableRooms(this.convertToString(startDate), this.convertToString(endDate));
    this.startDate = startDate;
    this.endDate = endDate;
  }

  convertToString( date: Date)
  {
    this.returned = '';
    this.returned += date.getFullYear().toString().substr(0, 4);
    this.returned += '-';
    if (date.getMonth() < 9) {
      this.returned += '0';
    }
    this.returned += date.getMonth() + 1;
    this.returned += '-';
    if (date.getDate() < 10) {
      this.returned += '0';
    }
    this.returned += date.getDate();

    return this.returned;
  }

}