import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {of} from 'rxjs';
import {distinct, filter, mergeMap, toArray} from 'rxjs/operators';

@Component({
  selector: 'app-chosing-beatiful-view-from-windows',
  templateUrl: './chosing-beatiful-view-from-windows.component.html',
  styleUrls: ['./chosing-beatiful-view-from-windows.component.css']
})
export class ChosingBeatifulViewFromWindowsComponent implements OnInit {

  beautifulView;
  beautifulViewControl = new FormControl('', Validators.required);

  constructor(private router: Router, private calendarService: CalendarService) { }

  ngOnInit(): void {

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds),
        filter(v => v.typeOfPillow === this.calendarService.chosenPillowType),
        filter(v => v.closeToElevator === this.calendarService.chosenCloseToElevator),
        filter(v => v.balcony === this.calendarService.chosenBalcony),
        distinct(v => v.beautifulViewFromTheWindows),
        toArray(),
      ).subscribe(x => this.beautifulView = x);
    });
  }
  submit()
  {
    this.calendarService.chosenBeautifulView = this.beautifulViewControl.value;

    this.router.navigate(['/choosing-storey']);
  }
  dismiss(){}
}
