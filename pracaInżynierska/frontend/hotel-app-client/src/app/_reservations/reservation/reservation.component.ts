import {Component, Input, OnInit, Output, EventEmitter, Inject} from '@angular/core';
import {Reservation} from '../../_models/reservation';
import {from, observable, Observable, of} from 'rxjs';

import {Room} from '../../_models/room';

import {FormControl, Validators} from '@angular/forms';
import {distinct, filter, mergeMap, take, toArray} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {CalendarService} from '../../_services/calendar.service';
import {AppComponent} from '../../app.component';
import {ParametersService} from '../../_services/parameters.service';
import {Parameter} from '../../_models/parameter';
import {Data} from '../../_models/data';
import {TranslatorService} from '../../_services/translator.service';
import {ReservationService} from '../../_services/reservation.service';

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
  noAvailableRooms = false;
  availableRooms = true;
  constructor(@Inject(AppComponent) private parent: AppComponent,
              private router: Router,
              public authenticationService: AuthenticationService,
              public calendarService: CalendarService,
              public parametersService: ParametersService,
              public translatorService: TranslatorService,
              private reservationService: ReservationService) {}
              private roomTypeId = 0;
  private index = 0;
  private forIndex = 0;
  private forRoomIndex = 0;
  private forRoomIndex2 = 0;
  private numberIndex = 0;
  private doubleIndex = 0;
  private booleanIndex = 0;
  private stringIndex = 0;
  private roomParameterIndex = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
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
 private reservation = new Reservation();
  numberOfBedsControl = new FormControl(-1, Validators.required);
  controlParameterInt = new FormControl(-1, Validators.required);
  controlParameterInt2 = new FormControl(-1, Validators.required);
  controlParameterInt3 = new FormControl(-1, Validators.required);
  controlParameterInt4 = new FormControl(-1, Validators.required);
  controlParameterInt5 = new FormControl(-1, Validators.required);

  controlParameterDouble = new FormControl(-1, Validators.required);
  controlParameterDouble2 = new FormControl(-1, Validators.required);
  controlParameterDouble3 = new FormControl(-1, Validators.required);
  controlParameterDouble4 = new FormControl(-1, Validators.required);
  controlParameterDouble5 = new FormControl(-1, Validators.required);

  controlParameterString = new FormControl(null, Validators.required);
  controlParameterString2 = new FormControl(null, Validators.required);
  controlParameterString3 = new FormControl(null, Validators.required);
  controlParameterString4 = new FormControl(null, Validators.required);
  controlParameterString5 = new FormControl(null, Validators.required);

  controlParameterBoolean = new FormControl(null, Validators.required);
  controlParameterBoolean2 = new FormControl(null, Validators.required);
  controlParameterBoolean3 = new FormControl(null, Validators.required);
  controlParameterBoolean4 = new FormControl(null, Validators.required);
  controlParameterBoolean5 = new FormControl(null, Validators.required);
  controlParameterBoolean6 = new FormControl(null, Validators.required);
  controlParameterBoolean7 = new FormControl(null, Validators.required);
  controlParameterBoolean8 = new FormControl(null, Validators.required);
i = 0;
  submitted = false;

parameterIndex = [];
parameterValue = [];
  ngOnInit(): void {

    if (!this.authenticationService.currentUserValue) {
      this.router.navigate(['/register']);
    }

    for(this.i; this.i < 16; this.i++)
{
  this.roomParameterIndex[this.i] = -1;
}

    this.parameters$ = this.parametersService.getParameters();
    this.calendarService.parameters$ = this.parametersService.getParameters();
    // this.rooms$ = this.roomService.getRooms();
   //  this.reservations$ = this.reservationService.getReservations();
    if (this.calendarService.rooms$)
    {

    this.calendarService.rooms$.subscribe(rooms => {
      of(rooms.sort((a, b) => a.number1 - b.number1)).pipe(
        mergeMap(x => rooms),
        distinct(v => v.number1),
        toArray(),
      ).subscribe(x => {
        this.roomNumbersOfBeds = x;

      });
    });
      setTimeout(() => {
        if(this.roomNumbersOfBeds.length === 0) {
          setTimeout(() => {
            this.noAvailableRooms = false;
            this.router.navigate(['/greeting']);
          }, 5000);
          this.noAvailableRooms = true;
        }

      }, 200);

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
             // this.numberIndex++;
             // this.roomParameterIndex[this.parameter.id] = 0;
              this.parameterIndex.push(this.parameter.id);
              this.parameterValue.push(0);
             // if (this.index === 5)
            //  {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number5 - b.number5)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number5),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter2 = x;
                    this.roomParameter3 = x;
                    this.roomParameter4 = x;
                    this.roomParameter5 = x;
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
              /*}
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
              else if (this.index === 10)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number9 - b.number9)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number9),
                    toArray(),
                  ).subscribe(x => this.roomParameter7 = x);
                });
                this.index++;
              }
              else if (this.index === 11)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number9 - b.number9)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number9),
                    toArray(),
                  ).subscribe(x => this.roomParameter8 = x);
                });
                this.index++;
              }
              else if (this.index === 12)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number9 - b.number9)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number9),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
              }*/
            }

            else if (this.parameter.typeId === 1)
            {
              // this.doubleIndex++;
             // this.roomParameterIndex[this.parameter.id] = 1;
              this.parameterIndex.push(this.parameter.id);
              this.parameterValue.push(1);
              // if (this.index === 5)
             // {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number14 - b.number14)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number14),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter2 = x;
                    this.roomParameter3 = x;
                    this.roomParameter4 = x;
                    this.roomParameter5 = x;
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
             /* }
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
                  of(rooms.sort((a, b) => a.number14 - b.number14)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number14),
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
              else if (this.index === 10)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number17 - b.number17)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number17),
                    toArray(),
                  ).subscribe(x => this.roomParameter7 = x);
                });
                this.index++;
              }
              else if (this.index === 11)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number17 - b.number17)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number17),
                    toArray(),
                  ).subscribe(x => this.roomParameter8 = x);
                });
                this.index++;
              }
              else if (this.index === 12)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms.sort((a, b) => a.number17 - b.number17)).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.number17),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
              }*/
            }
            else if (this.parameter.typeId === 2)
            {
              // this.stringIndex++;
             // this.roomParameterIndex[this.parameter.id] = 2;
              this.parameterIndex.push(this.parameter.id);
              this.parameterValue.push(2);
              if (this.index === 5)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string1),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter2 = x;
                    this.roomParameter3 = x;
                    this.roomParameter4 = x;
                    this.roomParameter5 = x;
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
              }
              else if (this.index === 6)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string1),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter3 = x;
                    this.roomParameter4 = x;
                    this.roomParameter5 = x;
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;});
                });
                this.index++;
              }
              else if (this.index === 7)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string1),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter4 = x;
                    this.roomParameter5 = x;
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x; });
                });
                this.index++;
              }
              else if (this.index === 8)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string1),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter5 = x;
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x; });
                });
                this.index++;
              }
              else
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string1),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x}
                  );
                });
                this.index++;
              }
              /*else if (this.index === 10)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string5),
                    toArray(),
                  ).subscribe(x => this.roomParameter7 = x);
                });
                this.index++;
              }
              else if (this.index === 11)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string5),
                    toArray(),
                  ).subscribe(x => this.roomParameter8 = x);
                });
                this.index++;
              }
              else if (this.index === 12)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.string5),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
              }*/

            }
            else
            {
              // this.booleanIndex++;
             // this.roomParameterIndex[this.parameter.id] = 3;
              this.parameterIndex.push(this.parameter.id);
              this.parameterValue.push(3);
              // if (this.index === 5)
             // {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean1),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter2 = x;
                    this.roomParameter3 = x;
                    this.roomParameter4 = x;
                    this.roomParameter5 = x;
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
              /*}
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
              else
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean5),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter6 = x;
                    this.roomParameter7 = x;
                    this.roomParameter8 = x;
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x});
                });
                this.index++;
              }*/
             /* else if (this.index === 10)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean5),
                    toArray(),
                  ).subscribe(x => this.roomParameter7 = x);
                });
                this.index++;
              }
              else if (this.index === 11)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean5),
                    toArray(),
                  ).subscribe(x => this.roomParameter8 = x);
                });
                this.index++;
              }
              else if (this.index === 12)
              {
                this.calendarService.rooms$.subscribe(rooms => {
                  of(rooms).pipe(
                    mergeMap(x => rooms),
                    distinct(v => v.boolean5),
                    toArray(),
                  ).subscribe(x => {
                    this.roomParameter9 = x;
                    this.roomParameter10 = x;
                    this.roomParameter11 = x;
                  });
                });
                this.index++;
              }*/
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
    this.calendarService.room.number1 = this.numberOfBedsControl.value;
    for (this.forRoomIndex2; this.forRoomIndex2 < this.parameterValue.length; this.forRoomIndex2++)
   {
     if (this.parameterValue[this.forRoomIndex2] === 0)
     {
       if ( this.numberIndex === 0  && this.controlParameterInt.value > -1 ) {
         this.calendarService.room.number5 = this.controlParameterInt.value;
       }
       else if ( this.numberIndex === 1 && this.controlParameterInt2.value > -1  ){
         this.calendarService.room.number6 = this.controlParameterInt2.value;
       }
       else if ( this.numberIndex === 2  && this.controlParameterInt3.value > -1 ){
         this.calendarService.room.number7 = this.controlParameterInt3.value;
       }
       else if ( this.numberIndex === 3 && this.controlParameterInt4.value > -1 ){
         this.calendarService.room.number8 = this.controlParameterInt4.value;
       }
       else if ( this.numberIndex === 4 && this.controlParameterInt5.value > -1 ){
         this.calendarService.room.number9 = this.controlParameterInt5.value;
       }
       this.numberIndex++;
     }
     else if (this.parameterValue[this.forRoomIndex2] === 1)
     {
       if ( this.doubleIndex === 0  && this.controlParameterDouble.value > -1 ) {
         this.calendarService.room.number13 = this.controlParameterDouble.value;
       }
       else if ( this.doubleIndex === 1 && this.controlParameterDouble2.value > -1 ) {
         this.calendarService.room.number14 = this.controlParameterDouble2.value;
       }
       else if ( this.doubleIndex === 2 && this.controlParameterDouble3.value > -1 ) {
         this.calendarService.room.number15 = this.controlParameterDouble3.value;
       }
       else if ( this.doubleIndex === 3 && this.controlParameterDouble4.value > -1 ) {
         this.calendarService.room.number16 = this.controlParameterDouble4.value;
       }
       else if ( this.doubleIndex === 4  && this.controlParameterDouble5.value > -1 ){
         this.calendarService.room.number17 = this.controlParameterDouble5.value;
       }
       this.doubleIndex++;
     }
     else if (this.parameterValue[this.forRoomIndex2] === 2)
     {
       if ( this.stringIndex === 0  && this.controlParameterString !== null ) {
         this.calendarService.room.string1 = this.controlParameterString.value;
       }
       else   if ( this.stringIndex === 1  && this.controlParameterString2 !== null){
         this.calendarService.room.string2 = this.controlParameterString2.value;
       }
       else   if ( this.stringIndex === 2  && this.controlParameterString3 !== null){
         this.calendarService.room.string3 = this.controlParameterString3.value;
       }
       else   if ( this.stringIndex === 3  && this.controlParameterString4 !== null){
         this.calendarService.room.string4 = this.controlParameterString4.value;
       }
       else if ( this.stringIndex === 4  && this.controlParameterString5 !== null){
         this.calendarService.room.string5 = this.controlParameterString5.value;
       }
       this.stringIndex++;
     }
     else
     {
       if ( this.booleanIndex === 0 && this.controlParameterBoolean !== null ) {
         this.calendarService.room.boolean1 = this.controlParameterBoolean.value;
       }
       else  if ( this.booleanIndex === 1 && this.controlParameterBoolean2 !== null ) {
         this.calendarService.room.boolean2 = this.controlParameterBoolean2.value;
       }
       else  if ( this.booleanIndex === 2 && this.controlParameterBoolean3 !== null ) {
         this.calendarService.room.boolean3 = this.controlParameterBoolean3.value;
       }
       else  if ( this.booleanIndex === 3 && this.controlParameterBoolean4 !== null ) {
         this.calendarService.room.boolean4 = this.controlParameterBoolean4.value;
       }
       else if ( this.booleanIndex === 4 && this.controlParameterBoolean5 !== null ) {
         this.calendarService.room.boolean5 = this.controlParameterBoolean5.value;
       }
       else if ( this.booleanIndex === 5 && this.controlParameterBoolean6 !== null ) {
         this.calendarService.room.boolean6 = this.controlParameterBoolean6.value;
       }
       else if ( this.booleanIndex === 6 && this.controlParameterBoolean7 !== null ) {
         this.calendarService.room.boolean7 = this.controlParameterBoolean7.value;
       }
       else if ( this.booleanIndex === 7 && this.controlParameterBoolean8 !== null ){
         this.calendarService.room.boolean8 = this.controlParameterBoolean8.value;
       }
       this.booleanIndex++;
     }
   }
    this.calendarService.rooms$.subscribe(room => {
     for (this.forRoomIndex; ; this.forRoomIndex++)
     {
       if (this.forRoomIndex === room.length) {
         break;
       }

       if (room[this.forRoomIndex].number1 ===  this.calendarService.room.number1)
       {
         this.calendarService.room.number2 = room[this.forRoomIndex].number2;
         this.calendarService.room.number3 = room[this.forRoomIndex].number3;
         this.calendarService.room.number4 = room[this.forRoomIndex].number4;
         this.calendarService.room.number13 = room[this.forRoomIndex].number13;
         this.calendarService.room.id = room[this.forRoomIndex].id;
         break;
       }
     }
    });

    this.router.navigate(['/summary']);
  }

  dismiss()
  {
    this.parent.sidenav.open();
    this.router.navigate(['/greeting']);
  }

  book() {
    /*this.reservation.startDate = this.calendarService.startDate;
    this.reservation.endDate = this.calendarService.endDate;
    this.reservation.numberOfDays = this.calendarService.differenceInDays;
    this.reservation.roomTypeId = this.roomTypeId;
    this.reservation.userId = this.authenticationService.currentUserValue.id;
    this.reservation.price = this.calendarService.room.number13 * this.reservation.numberOfDays;
    this.reservationService.addReservation(this.reservation).pipe(take(1)).subscribe(x => {
    });
    setTimeout(() => {
      if (this.reservationService.status !== null)
      {
        setTimeout(() => {
          this.parent.reservationNotCreated = false;
        }, 5000);
        this.parent.reservationNotCreated = true;
        this.reservationService.status = null;
      }
      else
      {
        setTimeout(() => {
          this.parent.createdNewReservation = false;
        }, 5000);
        this.parent.createdNewReservation = true;
        this.parent.sidenav.open();
        this.router.navigate(['']);
      }
    }, 50);*/

  }

}
