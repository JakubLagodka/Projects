import {Injectable, Output, EventEmitter, OnInit} from '@angular/core';
import {RoomService} from './room.service';
import {Observable} from 'rxjs';
import {Data} from '../_models/data';
import {ParametersService} from './parameters.service';



@Injectable({
  providedIn: 'root'
})
export class CalendarService implements OnInit{
  private returned: string;
   differenceInDays;
  rooms$: Observable<Data[]>;
  public chosenNumberOfBeds;
  public chosenCloseToElevator;
  public chosenBalcony;
  public chosenBeautifulView;
  public chosenPillowType;
  public chosenStorey;
  public chosenRooms;
  public hotelNight = null;
  public room = new Data();
  differenceInTime;
  startDate;
  endDate;
  parameters$;
  constructor(  public roomService: RoomService,
                public parametersService: ParametersService) {}

ngOnInit() {
  this.parameters$ = this.parametersService.getParameters();
 /* this.room.number1 = -1;
  this.room.number2 = -1;
  this.room.number3 = -1;
  this.room.number4 = -1;
  this.room.number5 = -1;
  this.room.number6 = -1;
  this.room.number7 = -1;
  this.room.number8 = -1;
  this.room.number9 = -1;
  this.room.number10 = -1;
  this.room.number11 = -1;
  this.room.number12 = -1;
  this.room.number13 = -1;
  this.room.number14 = -1;
  this.room.number15 = -1;
  this.room.number16 = -1;
  this.room.number17 = -1;
  this.room.number18 = -1;
  this.room.number19 = -1;
  this.room.number20 = -1;
  this.room.number21 = -1;
  this.room.number22 = -1;
  this.room.boolean1 = null;
  this.room.boolean2 = null;
  this.room.boolean3 = null;
  this.room.boolean4 = null;
  this.room.boolean5 = null;
  this.room.boolean6 = null;
  this.room.boolean7 = null;
  this.room.boolean8 = null;
  this.room.boolean9 = null;
  this.room.boolean10 = null;
  this.room.boolean11 = null;
  this.room.boolean12 = null;*/
}

  takeDates(startDate, endDate)
  {

    this.rooms$ = null;
    startDate.setHours(14);
    if (startDate.getDate() === endDate.getDate()) {
    endDate.setDate(endDate.getDate() + 1 );
    }
    endDate.setHours(12);
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
