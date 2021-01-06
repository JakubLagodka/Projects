import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {ReservationService} from '../../_services/reservation.service';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {of} from 'rxjs';
import {distinct, filter, mergeMap, take, toArray} from 'rxjs/operators';
import {HotelNightService} from '../../_services/hotel-night.service';
import {AppComponent} from '../../app.component';

@Component({
  selector: 'app-choosing-storey',
  templateUrl: './choosing-storey.component.html',
  styleUrls: ['./choosing-storey.component.css']
})
export class ChoosingStoreyComponent implements OnInit {

  storey;
  storeyControl = new FormControl('', Validators.required);

  constructor(@Inject(AppComponent) private parent: AppComponent,
              private router: Router, private calendarService: CalendarService,
              private hotelNightService: HotelNightService) { }

  ngOnInit(): void {
    if (this.calendarService.rooms$) {
    /*this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds),
        filter(v => v.typeOfPillow === this.calendarService.chosenPillowType),
        filter(v => v.closeToElevator === this.calendarService.chosenCloseToElevator),
        filter(v => v.balcony === this.calendarService.chosenBalcony),
        filter(v => v.beautifulViewFromTheWindows === this.calendarService.chosenBeautifulView),
        distinct(v => v.storey),
        toArray(),
      ).subscribe(x => this.storey = x);
    });*/
    }
    else
    {
      setTimeout(() => {
        this.parent.lostData = false;
      }, 5000);
      this.parent.lostData = true;
      this.router.navigate(['']);
    }
  }
  submit()
  {
    this.calendarService.chosenStorey = this.storeyControl.value;

   /* this.calendarService.rooms$.subscribe(rooms => {
      of(rooms).pipe(
        mergeMap(x => rooms),
        filter(v => v.numberOfBeds === this.calendarService.chosenNumberOfBeds),
        filter(v => v.typeOfPillow === this.calendarService.chosenPillowType),
        filter(v => v.closeToElevator === this.calendarService.chosenCloseToElevator),
        filter(v => v.balcony === this.calendarService.chosenBalcony),
        filter(v => v.beautifulViewFromTheWindows === this.calendarService.chosenBeautifulView),
        filter(v => v.storey === this.calendarService.chosenStorey),
        distinct(v => v.beautifulViewFromTheWindows),
        toArray(),
      ).subscribe(x => this.calendarService.chosenRooms = x);
    });*/

    this.router.navigate(['/summary']);
  }
  dismiss()
  {
    this.router.navigate(['/choosing-beautiful-view-from-windows']);
  }
}
