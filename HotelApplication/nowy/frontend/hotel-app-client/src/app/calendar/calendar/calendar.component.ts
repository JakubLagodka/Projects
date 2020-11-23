import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-material-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarMaterialComponent implements OnInit {
  minDate: Date;
  maxDate: Date;

  constructor() {
    const currentYear = new Date().getFullYear();
    const currentMonth = new Date().getMonth();
    const currentDay = new Date().getDate();

    this.minDate = new Date(currentYear, currentMonth, currentDay);
    this.maxDate = new Date(currentYear + 10, currentMonth, currentDay);
  }


  ngOnInit(): void {
  }

}
