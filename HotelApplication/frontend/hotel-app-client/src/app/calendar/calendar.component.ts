import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  minDate: Date;
  maxDate: Date;
  submitted = false;
  range = new FormGroup({
    start: new FormControl(['', Validators.required]),
    end: new FormControl(['', Validators.required])
  });
  constructor(private router: Router,
              private formBuilder: FormBuilder) {
    const currentYear = new Date().getFullYear();
    const currentMonth = new Date().getMonth();
    const currentDay = new Date().getDate();

    this.minDate = new Date(currentYear, currentMonth, currentDay);
    this.maxDate = new Date(currentYear + 10, currentMonth, currentDay);
  }




  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.range.invalid) {
      return;
    }
    this.router.navigate(['/reservation']);
  }
}
