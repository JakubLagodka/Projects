import { Component, OnInit } from '@angular/core';
import {Parameter} from '../_models/parameter';
import {Observable} from 'rxjs';
import {ParametersService} from '../_services/parameters.service';
import {RoomService} from '../_services/room.service';
import {Data} from '../_models/data';
import {take} from 'rxjs/operators';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {EditParametersDialogComponent} from '../edit-parameters/edit-parameters.component';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TranslatorService} from '../_services/translator.service';

@Component({
  selector: 'app-edit-rooms',
  templateUrl: './edit-rooms.component.html',
  styleUrls: ['./edit-rooms.component.css']
})
export class EditRoomsComponent implements OnInit {
  parameters$: Observable<Parameter[]>;
  rooms$: Observable<Data[]>;
  first;
  data: Data = new Data();
  confirmed = false;
  noRooms = false;
  booleanTypeControl = new FormControl('', Validators.required);
  booleanTypeControl2 = new FormControl('', Validators.required);
  booleanTypeControl3 = new FormControl('', Validators.required);
  booleanTypeControl4 = new FormControl('', Validators.required);
  booleanTypeControl5 = new FormControl('', Validators.required);
  booleanTypeControl6 = new FormControl('', Validators.required);
  booleanTypeControl7 = new FormControl('', Validators.required);
  booleanTypeControl8 = new FormControl('', Validators.required);
  booleanTypeControl9 = new FormControl('', Validators.required);
  booleanTypeControl10 = new FormControl('', Validators.required);
  booleanTypeControl11 = new FormControl('', Validators.required);
  booleanTypeControl12 = new FormControl('', Validators.required);
  booleanTypes = [ 'tak', 'nie'];
  constructor(private route: ActivatedRoute,
              private router: Router,
              public parametersService: ParametersService,
              public roomService: RoomService,
              public dialog: MatDialog,
              public translatorService: TranslatorService) { }

  ngOnInit(): void {
    this.parameters$ = this.parametersService.getParameters();
    this.rooms$ = this.roomService.getRooms();
    this.first =  this.rooms$.pipe(take(1));
    {
      setTimeout(() => {
        if (this.first === undefined)
          this.noRooms = true;
      }, 500);
    }

  }

  openDialog(): void {
    const dialogRef = this.dialog.open(EditParametersDialogComponent, {
      width: '250px',
    });

    //   dialogRef.afterClosed().subscribe(result => {

    this.confirmed = true;

    //  });
  }

  add(data: Data) {
    if(this.booleanTypeControl.value !== null && this.booleanTypeControl.value === 'tak')
      data.boolean1 = true;
    else
      data.boolean1 = false;
    if(this.booleanTypeControl2.value !== null && this.booleanTypeControl2.value === 'tak')
      data.boolean2 = true;
    else
      data.boolean2 = false;
    if(this.booleanTypeControl3.value !== null && this.booleanTypeControl3.value === 'tak')
      data.boolean3 = true;
    else
      data.boolean3 = false;
    if(this.booleanTypeControl4.value !== null && this.booleanTypeControl4.value === 'tak')
      data.boolean4 = true;
    else
      data.boolean4 = false;
    if(this.booleanTypeControl5.value !== null && this.booleanTypeControl5.value === 'tak')
      data.boolean5 = true;
    else
      data.boolean5 = false;
    if(this.booleanTypeControl6.value !== null && this.booleanTypeControl6.value === 'tak')
      data.boolean6 = true;
    else
      data.boolean6 = false;
    if(this.booleanTypeControl7.value !== null && this.booleanTypeControl7.value === 'tak')
      data.boolean7 = true;
    else
      data.boolean7 = false;
    if(this.booleanTypeControl8.value !== null && this.booleanTypeControl8.value === 'tak')
      data.boolean8 = true;
    else
      data.boolean8 = false;
    if(this.booleanTypeControl9.value !== null && this.booleanTypeControl9.value === 'tak')
      data.boolean9 = true;
    else
      data.boolean9 = false;
    if(this.booleanTypeControl10.value !== null && this.booleanTypeControl10.value === 'tak')
      data.boolean10 = true;
    else
      data.boolean10 = false;
    if(this.booleanTypeControl11.value !== null && this.booleanTypeControl11.value === 'tak')
      data.boolean11 = true;
    else
      data.boolean11 = false;
    if(this.booleanTypeControl12.value !== null && this.booleanTypeControl12.value === 'tak')
      data.boolean12 = true;
    else
      data.boolean12 = false;


    this.roomService.addRoom(data).pipe(take(1)).subscribe(x => {
    });
  }

  return() {
    this.router.navigate(['/administrator-panel']);
  }

  delete(room: Data) {
    this.roomService.deleteRoom(room.id).pipe(take(1)).subscribe(x => {
    });
  }
  edit(room: Data) {

  }
}

@Component({
  selector: 'app-edit-rooms-dialog',
  templateUrl: './edit-rooms-dialog.component.html'
})
export class EditRoomsDialogComponent {

  constructor(public dialogRef: MatDialogRef<EditRoomsDialogComponent>,
              private route: ActivatedRoute,
              private router: Router) {}

  onClick(): void {
    this.dialogRef.close();
  }

  close(): void {
    this.dialogRef.close();
    this.router.navigate(['/administrator-panel']);
  }

}
