import {Component, Input, OnInit} from '@angular/core';
import {Reservation} from '../_models/reservation';
import {from, observable, Observable, of} from 'rxjs';

import {Room} from '../_models/room';

import {ReservationService} from '../_services/reservation.service';
import {RoomService} from '../_services/room.service';
import {FormControl, Validators} from '@angular/forms';
import {distinct, mergeMap, toArray} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';
import {CalendarService} from '../_services/calendar.service';
import {forEachComment} from 'tslint';
import { Pipe, PipeTransform } from '@angular/core';
interface Animal {
  name: string;
  sound: string;
  age: number;
}
interface Person {
  age: number;
  name: Room[];
}

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})

export class ReservationComponent implements OnInit {

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
  private start: Date;
  private returned: string;
  public numbersOfBeds;
  public rooms: Room[];
  public pack: Person = {age: 1, name: null};
  private options: string[] = ['One', 'Two', 'Three'];
  numberOfBedsControl = new FormControl('', Validators.required);
  xxx = new FormControl('', Validators.required);
  animalControl = new FormControl('', Validators.required);
  selectFormControl = new FormControl('', Validators.required);
  animals: Animal[] = [
    {name: 'Dog', sound: 'Woof!', age: 1},
    {name: 'Dog', sound: 'ffff!', age: 2},
    {name: 'Cat', sound: 'Meow!', age: 1},
    {name: 'Cow', sound: 'Moo!', age: 1},
    {name: 'Fox', sound: 'Wa-pa-pa-pa-pa-pa-pow!', age: 1},
  ];

  ngOnInit(): void {

    if (!this.authenticationService.currentUserValue) {
      this.router.navigate(['/register']);
    }
    this.diff = new Date(Math.abs(this.calendarService.range.controls.end.value - this.calendarService.range.controls.start.value));
    this.start = new Date(this.calendarService.range.controls.end.value);
    this.rooms$ = this.roomService.getAvailableRooms(this.convertToString(this.start), this.diff.getDate());
    // this.rooms$ = this.roomService.getRooms();
    this.reservations$ = this.reservationService.getReservations();
    this.rooms$.subscribe(rooms => {
      of(rooms.sort((a, b) => a.numberOfBeds - b.numberOfBeds)).pipe(
        mergeMap(x => rooms),
        distinct(v => v.numberOfBeds),
        toArray(),
      ).subscribe(x => this.numbersOfBeds = x);
    });
    this.numbersOfBeds = this.numbersOfBeds.sort((a, b) => a.numberOfBeds > b.numberOfBeds);

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
  convertToString( date: Date)
  {
    this.returned = '';
    this.returned += date.getFullYear().toString().substr(0, 4);
    this.returned += '-';
    this.returned += date.getMonth() + 1;
    this.returned += '-';
    this.returned += date.getDate();

    return this.returned;
  }

  onSubmit()
  {

    // this.roomService.bookRoom(1, this.convertToString(this.start), this.diff.getDate());
  }
}
