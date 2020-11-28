import { Injectable, Output, EventEmitter } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';



@Injectable({
  providedIn: 'root'
})
export class CalendarService {

  range = new FormGroup({
    start: new FormControl(['', Validators.required]),
    end: new FormControl(['', Validators.required])
  });
  constructor() { }
  @Output() change: EventEmitter<boolean> = new EventEmitter();

  takeDates(formGroup: FormGroup)
  {
    this.range = formGroup;
  }


}
