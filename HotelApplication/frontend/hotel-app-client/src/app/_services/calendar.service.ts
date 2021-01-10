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
