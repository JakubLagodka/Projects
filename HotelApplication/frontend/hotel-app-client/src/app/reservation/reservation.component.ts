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
import {ParametersService} from '../_services/parameters.service';
import {Parameter} from '../_models/parameter';
import {Data} from '../_models/data';
import {TranslatorService} from '../_services/translator.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})

export class ReservationComponent implements OnInit {
  // @Output() export = new EventEmitter();
  rooms$: Observable<Data[]>;
  parameters$: Observable<Parameter[]>;
  data: Data = new Data();
  constructor(@Inject(AppComponent) private parent: AppComponent,
              private router: Router,
              public authenticationService: AuthenticationService,
              public calendarService: CalendarService,
              public parametersService: ParametersService,
              public translatorService: TranslatorService) {}
  private index = 0;
  private forIndex = 0;
  private forRoomIndex = 0;
  private numberIndex = 0;
  private doubleIndex = 0;
  private booleanIndex = 0;
  private stringIndex = 0;
  private roomParameterIndex = [];
  public roomNumbersOfBeds;
  public roomParameter2;
  public roomParameter3;
  public roomParameter4;
  public roomParameter5;
  public roomParameter6;
  public roomParameter7;
  public roomParameter8;
  public roomParameter9;
  public roomParameter10;
  public roomParameter11;
  private parameter = new Parameter();

  numberOfBedsControl = new FormControl('', Validators.required);
  controlParameter2 = new FormControl('', Validators.required);
  controlParameter3 = new FormControl('', Validators.required);
  controlParameter4 = new FormControl('', Validators.required);
  controlParameter5 = new FormControl('', Validators.required);
  controlParameter6 = new FormControl('', Validators.required);
  controlParameter7 = new FormControl('', Validators.required);
  controlParameter8 = new FormControl('', Validators.required);
  controlParameter9 = new FormControl('', Validators.required);
  controlParameter10 = new FormControl('', Validators.required);

  submitted = false;

  ngOnInit(): void {

    if (!this.authenticationService.currentUserValue) {
      this.router.navigate(['/register']);
    }
    this.parameters$ = this.parametersService.getParameters();
    // this.rooms$ = this.roomService.getRooms();
   //  this.reservations$ = this.reservationService.getReservations();
    if (this.calendarService.rooms$)
    {

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms.sort((a, b) => a.number1 - b.number1)).pipe(
        mergeMap(x => rooms),
        distinct(v => v.number1),
        toArray(),
      ).subscribe(x => this.roomNumbersOfBeds = x);
    });

    this.parametersService.getParameters().subscribe(parameters => {
        for (this.forIndex; ; this.forIndex++)
        {
          this.parameter = parameters[this.index];

          if ( this.index === parameters.length ) {
            break;
          }
        //  console.log(this.parameter);
          this.index++;
          if (this.index > 5)
          {
            this.index--;
          //  console.log(this.index);
            if (this.parameter.typeId === 0)
            {
              this.numberIndex++;
              this.roomParameterIndex.push(0);
              if (this.index === 5)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number5 - b.number5)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number5),
                    toArray(),
                  ).subscribe(x => this.roomParameter2 = x);
                });
                this.index++;
              }
              else if (this.index === 6)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number6 - b.number6)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number6),
                    toArray(),
                  ).subscribe(x => this.roomParameter3 = x);
                });
                this.index++;
              }
              else if (this.index === 7)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number7 - b.number7)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number7),
                    toArray(),
                  ).subscribe(x => this.roomParameter4 = x);
                });
                this.index++;
              }
              else if (this.index === 8)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number8 - b.number8)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number8),
                    toArray(),
                  ).subscribe(x => this.roomParameter5 = x);
                });
                this.index++;
              }
              else if (this.index === 9)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number9 - b.number9)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number9),
                    toArray(),
                  ).subscribe(x => this.roomParameter6 = x);
                });
                this.index++;
              }
            }

            else if (this.parameter.typeId === 1)
            {
              this.doubleIndex++;
              this.roomParameterIndex.push(1);
              if (this.index === 5)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number13 - b.number13)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number13),
                    toArray(),
                  ).subscribe(x => this.roomParameter2 = x);
                });
                this.index++;
              }
              else if (this.index === 6)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number14 - b.number14)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number14),
                    toArray(),
                  ).subscribe(x => this.roomParameter3 = x);
                });
                this.index++;
              }
              else if (this.index === 7)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number15 - b.number15)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number15),
                    toArray(),
                  ).subscribe(x => this.roomParameter4 = x);
                });
                this.index++;
              }
              else if (this.index === 8)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number16 - b.number16)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number16),
                    toArray(),
                  ).subscribe(x => this.roomParameter5 = x);
                });
                this.index++;
              }
              else if (this.index === 9)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number17 - b.number17)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number17),
                    toArray(),
                  ).subscribe(x => this.roomParameter6 = x);
                });
                this.index++;
              }
            }
            else if (this.parameter.typeId === 2)
            {
              this.stringIndex++;
              this.roomParameterIndex.push(2);
              if (this.index === 5)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string1),
                    toArray(),
                  ).subscribe(x => this.roomParameter2 = x);
                });
                this.index++;
              }
              else if (this.index === 6)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string2),
                    toArray(),
                  ).subscribe(x => this.roomParameter3 = x);
                });
                this.index++;
              }
              else if (this.index === 7)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string3),
                    toArray(),
                  ).subscribe(x => this.roomParameter4 = x);
                });
                this.index++;
              }
              else if (this.index === 8)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string4),
                    toArray(),
                  ).subscribe(x => this.roomParameter5 = x);
                });
                this.index++;
              }
              else if (this.index === 9)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string5),
                    toArray(),
                  ).subscribe(x => this.roomParameter6 = x);
                });
                this.index++;
              }
            }
            else
            {
              this.booleanIndex++;
              this.roomParameterIndex.push(3);
              if (this.index === 5)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean1),
                    toArray(),
                  ).subscribe(x => this.roomParameter2 = x);
                });
                this.index++;
              }
              else if (this.index === 6)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean2),
                    toArray(),
                  ).subscribe(x => this.roomParameter3 = x);
                });
                this.index++;
              }
              else if (this.index === 7)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean3),
                    toArray(),
                  ).subscribe(x => this.roomParameter4 = x);
                });
                this.index++;
              }
              else if (this.index === 8)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean4),
                    toArray(),
                  ).subscribe(x => this.roomParameter5 = x);
                });
                this.index++;
              }
              else if (this.index === 9)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean5),
                    toArray(),
                  ).subscribe(x => this.roomParameter6 = x);
                });
                this.index++;
              }
            }
          }
          else
          {
            if (this.index === 1)
            {
            }
            else if (this.index === 2)
            {

            }
            else if (this.index === 3)
            {

            }
            else if (this.index === 4)
            {

            }
            else
            {

            }
          }
        }




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
   // this.calendarService.chosenNumberOfBeds = this.numberOfBedsControl.value;
    this.submitted =  true;
    this.data.number1 = this.numberOfBedsControl.value;
    this.rooms$.subscribe(room => {
     for (this.forRoomIndex; ; this.forRoomIndex++)
     {
       if (this.forRoomIndex === room.length) {
         break;
       }

       if (room[this.forRoomIndex].number1 ===  this.data.number1)
       {
         this.data.number2 = room[this.forRoomIndex].number2;
         this.data.number3 = room[this.forRoomIndex].number3;
         this.data.number4 = room[this.forRoomIndex].number4;
         this.data.number5 = room[this.forRoomIndex].number5;
         break;
       }
     }
    });


  }

  dismiss()
  {
    this.parent.sidenav.open();
    this.router.navigate(['']);
  }

  book() {

  }
}
