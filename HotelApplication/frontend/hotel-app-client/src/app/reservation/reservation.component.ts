import {Component, Input, OnInit} from '@angular/core';
import {Reservation} from '../_models/reservation';
import {from, observable, Observable, of} from 'rxjs';

import {Room} from '../_models/room';

import {ReservationService} from '../_services/reservation.service';
import {RoomService} from '../_services/room.service';
import {FormControl, Validators} from '@angular/forms';
import {distinct, filter, mergeMap, toArray} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';
import {CalendarService} from '../_services/calendar.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})

export class ReservationComponent implements OnInit {

  rooms$: Observable<Room[]>;
  reservations$: Observable<Reservation[]>;
  myControl = new FormControl();

  constructor(
  public reservationService: ReservationService,
  private router: Router,
  public authenticationService: AuthenticationService,
  private calendarService: CalendarService) {}
  private diff;
  private start: Date;
  private returned: string;
  public numbersOfBeds;

  public storey;
  numberOfBedsControl = new FormControl('', Validators.required);
  storeyControl = new FormControl('', Validators.required);


  ngOnInit(): void {

    if (!this.authenticationService.currentUserValue) {
      this.router.navigate(['/register']);
    }

    // this.rooms$ = this.roomService.getRooms();
    this.reservations$ = this.reservationService.getReservations();

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms.sort((a, b) => a.numberOfBeds - b.numberOfBeds)).pipe(
        mergeMap(x => rooms),
        distinct(v => v.numberOfBeds),
        toArray(),
      ).subscribe(x => this.numbersOfBeds = x);
    });


    // this.numbersOfBeds = this.rooms.map(m => m.numberOfBeds).distinct().toArray();

    /* this.rooms$
       .pipe(
         map(rooms =>
           of<any>(rooms).pipe(distinct((p: any) => p.numberOfBeds))
             .subscribe(x => {
               this.rooms = x;
             })));

     of<Room>(this.rooms).pipe(
       distinct((room: Room) => room.numberOfBeds), )
       .subscribe(rooms => {
         console.log(rooms);
       });

     of<Person>(
       { age: 4, name: 'Foo'},
       { age: 7, name: 'Bar'},
       { age: 5, name: 'Foo'},
     ).pipe(
       distinct((p: Person) => p.name),
     )
       .subscribe(x => console.log(x));
     this.rooms.pipe(
         mergeMap((allDocs) => {
           // @ts-ignore
           return from(allDocs).pipe(distinct((eachDoc) => {
             return eachDoc.numberOfBeds;
           }))
         })
       ).subscribe((data) =>
       console.log(data));
   }*/

    /* this.filteredOptions = this.myControl.valueChanges
       .pipe(
         startWith(''),
         map(value => this._filter(value))
       );

   }
   private _filter(value: string): string[] {
     const filterValue = value.toLowerCase();

     return this.options.filter(option => option.toLowerCase().includes(filterValue));
   }*/
  }

  onSubmit()
  {
    this.calendarService.chosenNumberOfBeds = this.numberOfBedsControl;

    this.router.navigate(['/choosing-close-to-elevator']);

  }
}
