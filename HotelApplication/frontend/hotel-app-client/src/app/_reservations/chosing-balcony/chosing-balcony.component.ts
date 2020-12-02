import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {of} from 'rxjs';
import {distinct, filter, mergeMap, toArray} from 'rxjs/operators';
import {TranslatorService} from '../../_services/translator.service';

@Component({
  selector: 'app-chosing-balcony',
  templateUrl: './chosing-balcony.component.html',
  styleUrls: ['./chosing-balcony.component.css']
})
export class ChosingBalconyComponent implements OnInit {

  balcony;
  balconyControl = new FormControl('', Validators.required);

  constructor(private router: Router, private calendarService: CalendarService,
              public translatorService: TranslatorService) { }

  ngOnInit(): void {

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds),
        filter(v => v.typeOfPillow === this.calendarService.chosenPillowType),
        filter(v => v.closeToElevator === this.calendarService.chosenCloseToElevator),
        distinct(v => v.balcony),
        toArray(),
      ).subscribe(x => this.balcony = x);
    });
  }
  submit()
  {
    this.calendarService.chosenBalcony = this.balconyControl.value;

    this.router.navigate(['/choosing-beautiful-view-from-windows']);

  }
  dismiss(){}
}
