import {Component, Input, OnInit} from '@angular/core';
import {Reservation} from '../_models/reservation';
import {Observable} from 'rxjs';

import {Room} from '../_models/room';

import {ReservationService} from '../_services/reservation.service';
import {RoomService} from '../_services/room.service';
import {FormControl, Validators} from '@angular/forms';
import {map, startWith} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';
import {CalendarComponent} from '../calendar/calendar.component';
import {CalendarService} from '../_services/calendar.service';
@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

 // @Input() calendar: CalendarComponent;
  rooms$: Observable<Room[]>;
  reservations$: Observable<Reservation[]>;
  myControl = new FormControl();
  filteredOptions: Observable<string[]>;
  constructor(
  public roomService: RoomService,
  public reservationService: ReservationService,
  private router: Router,
  public authenticationService: AuthenticationService,
  private calendarService: CalendarService) {}
private diff;
  options: string[] = ['One', 'Two', 'Three'];

  ngOnInit(): void {

    if (!this.authenticationService.currentUserValue) {
      this.router.navigate(['/register']);
    }
    this.diff = new Date(Math.abs(this.calendarService.range.controls.end.value - this.calendarService.range.controls.start.value));
    this.rooms$ = this.roomService.getAvailableRooms( this.diff, this.diff.getDate());
    this.reservations$ = this.reservationService.getReservations();
    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );

  }
  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

}
