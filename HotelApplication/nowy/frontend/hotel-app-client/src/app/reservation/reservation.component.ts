import {Component, Input, OnInit, Output, EventEmitter, Inject} from '@angular/core';
import {Reservation} from '../_models/reservation';
import {from, observable, Observable, of} from 'rxjs';

import {Room} from '../_models/room';

import {FormControl, Validators} from '@angular/forms';
import {distinct, filter, mergeMap, toArray} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';
import {CalendarService} from '../_services/calendar.service';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})

export class ReservationComponent implements OnInit {
  @Output() export = new EventEmitter();
  rooms$: Observable<Room[]>;

  constructor(@Inject(AppComponent) private parent: AppComponent,
  private router: Router,
  public authenticationService: AuthenticationService,
  private calendarService: CalendarService) {}

  public numbersOfBeds;

  numberOfBedsControl = new FormControl('', Validators.required);

  ngOnInit(): void {

    if (!this.authenticationService.currentUserValue) {
      this.router.navigate(['/register']);
    }

    // this.rooms$ = this.roomService.getRooms();
   //  this.reservations$ = this.reservationService.getReservations();
    if (this.calendarService.rooms$)
    {
    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms.sort((a, b) => a.numberOfBeds - b.numberOfBeds)).pipe(
        mergeMap(x => rooms),
        distinct(v => v.numberOfBeds),
        toArray(),
      ).subscribe(x => this.numbersOfBeds = x);
    });
    }
    else
    {
      setTimeout(() => {
        this.parent.lostData = false;
      }, 5000);
      this.parent.lostData = true;
      this.router.navigate(['']);
    }

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

  submit()
  {
    this.calendarService.chosenNumberOfBeds = this.numberOfBedsControl.value;

    this.router.navigate(['/choosing-pillow-type']);

  }

  dismiss()
  {
    this.parent.sidenav.open();
    this.router.navigate(['']);
  }
}