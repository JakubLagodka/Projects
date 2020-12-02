import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Reservation} from '../_models/reservation';
import {CalendarService} from '../_services/calendar.service';
import {MatSidenav} from '@angular/material/sidenav';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {


  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private calendarService: CalendarService) {

  }




  ngOnInit() {
  }

 /* onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.range.invalid) {
      return;
    }

    this.calendarService.takeDates( this.range);

    this.router.navigate(['/reservation']);
  }*/
}
