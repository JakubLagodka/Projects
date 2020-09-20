import { Component } from '@angular/core';
import { HttpService } from './services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hotel-app-client';

  constructor(private httpService: HttpService) { }

  getHotels(){
this.httpService.getHotels().subscribe(hotels => {
  console.log(hotels);
});
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
