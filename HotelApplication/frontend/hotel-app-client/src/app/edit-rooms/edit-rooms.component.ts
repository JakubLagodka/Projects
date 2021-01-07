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

@Component({
  selector: 'app-edit-rooms',
  templateUrl: './edit-rooms.component.html',
  styleUrls: ['./edit-rooms.component.css']
})
export class EditRoomsComponent implements OnInit {
  parameters$: Observable<Parameter[]>;
  rooms$;
  first;
  data: Data = new Data();
  confirmed = false;
  noRooms = false;
  newRoom = new FormGroup({
    numberOfRoomsAvailable: new FormControl(['', Validators.required]),
    numberOfBeds: new FormControl(['', Validators.required]),
    checkInTime: new FormControl(['', Validators.required]),
    checkOutTime: new FormControl(['', Validators.required]),
    price: new FormControl(['', Validators.required])
  });
  constructor(public parametersService: ParametersService,
              public roomService: RoomService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.parameters$ = this.parametersService.getParameters();
    this.rooms$ = this.roomService.getRooms();
    this.first = this.roomService.getRooms().pipe(take(1));
   // console.log( this.rooms$.id );
    if (this.rooms$.id === undefined)
      this.noRooms = true;
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
  this.roomService.addRoom(data);
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
