import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { User } from './models/user';
import { AuthenticationService } from './services/authentication.service';
import { HttpService } from './services/http.service';
import {MatSidenav} from '@angular/material/sidenav';
import {FormControl} from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy, OnInit{
  loggedUser: User;
  userSub: Subscription;

  title = 'hotel-app-client';
  name = Array<User>();
  @ViewChild('sidenav') sidenav: MatSidenav;

  reason = '';
  mode = new FormControl('over');
  close(reason: string) {
    this.reason = reason;
    this.sidenav.close();
  }

  constructor(
    private httpService: HttpService,
    private router: Router,
    public authenticationService: AuthenticationService
  ) {
    this.httpService.getHotels().subscribe(hotels => {
      console.log(hotels);
      this.name = hotels;
  });
  this.userSub = this.authenticationService.loggedUser.subscribe(x => this.loggedUser = x);
}
 logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

  ngOnDestroy(): void {
    this.userSub.unsubscribe();
  }
  getHotels(){
  }

  getHotel(){

  }

  addHotel(){
    const hotel: Hotel = ({
      hotelName: 'Angularowy',

      theBeginningOfTheHotelDay: 12,

      endOfTheHotelDay: 14,

      numberOfFreeRooms: 850,

      phoneNumber: '486513245',
     });
  }

  updateHotel(){
    const hotel: Hotel = ({
      hotelName: 'Zajefajny',

      theBeginningOfTheHotelDay: 12,

      endOfTheHotelDay: 14,

      numberOfFreeRooms: 750,

      phoneNumber: '222222222',
     });
  }

  deleteHotel(){

  }

  changeHotel(){
 const hotel: Hotel = ({

  phoneNumber: '245698542',
 });
  }

  ngOnInit(): void {
    this.sidenav.open();
  }
}

export interface Hotel{

  hotelName?: string;

  theBeginningOfTheHotelDay?: number;

  endOfTheHotelDay?: number;

  numberOfFreeRooms?: number;

  phoneNumber?: string;
}

export interface HotelRoom{
  numberOfBeds?: number;

  storey?: number;

  highStorey?: boolean;

  CloseToElevator?: boolean;

  BeautifulViewFromTheWindows?: boolean;

  typeOfPillow?: PillowType;

  balcony?: boolean;

  priceForOneDay?: number;

  hotelId?: number;

  readyToUseOnAGivenDay?: boolean;

  canBeReserved?: boolean;
}

export enum PillowType{
  ANTIALLERGIC, NATURAL, SYNTHETIC, SPECIALISED
}

