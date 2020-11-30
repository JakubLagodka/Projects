import { Component, OnInit } from '@angular/core';
import {ReservationComponent} from '../reservation/reservation.component';
import {of} from 'rxjs';
import {distinct, mergeMap, toArray} from 'rxjs/operators';

@Component({
  selector: 'app-new-reservation',
  templateUrl: './new-reservation.component.html',
  styleUrls: ['./new-reservation.component.css']
})
export class NewReservationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

  }

}
