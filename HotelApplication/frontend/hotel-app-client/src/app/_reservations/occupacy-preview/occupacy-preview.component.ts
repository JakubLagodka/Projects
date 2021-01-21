import {Component, Inject, OnInit} from '@angular/core';
import {Reservation} from '../../_models/reservation';
import {AppComponent} from '../../app.component';
import {ReservationService} from '../../_services/reservation.service';
import {TranslatorService} from '../../_services/translator.service';
import {Observable} from 'rxjs';
import {User} from '../../_models/user';
import {UserService} from '../../_services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {EditParametersDialogComponent} from '../../edit-parameters/edit-parameters.component';

@Component({
  selector: 'app-occupacy-preview',
  templateUrl: './occupacy-preview.component.html',
  styleUrls: ['./occupacy-preview.component.css']
})
export class OccupacyPreviewComponent implements OnInit {
  reservations$: Observable<Reservation[]>;
  users$: Observable<User[]>;
  returned;
  details = false;
  userId;
  user;
  constructor(@Inject(AppComponent) private parent: AppComponent,
              public reservationService: ReservationService,
              public translatorService: TranslatorService,
              public userService: UserService,
              private route: ActivatedRoute,
              private router: Router,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.reservations$ = this.reservationService.getReservations();
    this.users$ = this.userService.getUsers();
  }
  check(reservation: Reservation)
  {
this.details = true;


  }

  delete(reservation: Reservation)
  {
    this.reservationService.deleteReservation(reservation.id);
  }

  openDialog(userId: number) {
    this.userId = userId;
 this.userService.currentUser = this.userService.getUserById(userId);

    const dialogRef = this.dialog.open(OccupancyPreviewDialogComponent, {
      width: '250px',

    });
  }

  return() {
    this.details = false;
  }
}

@Component({
  selector: 'app-occupancy-preview-dialog',
  templateUrl: './occupancy-preview-dialog.component.html'
})
export class OccupancyPreviewDialogComponent implements OnInit{
  currentUser;
  constructor(public dialogRef: MatDialogRef<OccupancyPreviewDialogComponent>,
              private route: ActivatedRoute,
              private router: Router,
              public userService: UserService,
             ) {
  }
ngOnInit(){
  this.currentUser = this.userService.currentUser;
}

  close(): void {
    this.dialogRef.close();
  }

}
