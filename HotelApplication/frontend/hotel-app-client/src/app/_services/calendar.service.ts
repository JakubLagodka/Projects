import { Injectable, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RoomService} from './room.service';
import {Observable} from 'rxjs';
import {Room} from '../_models/room';



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
  public choosenRooms;
  range = new FormGroup({
    start: new FormControl(['', Validators.required]),
    end: new FormControl(['', Validators.required])
  });
  constructor(  public roomService: RoomService) { }
  @Output() change: EventEmitter<boolean> = new EventEmitter();

  takeDates(formGroup: FormGroup)
  {

    this.range = formGroup;
    this.diff = new Date(Math.abs(this.range.controls.end.value - this.range.controls.start.value));
   // this.start = new Date(this.range.controls.end.value);
    this.rooms$ = this.roomService.getAvailableRooms(this.convertToString(this.range.controls.end.value), this.diff.getDate());
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
