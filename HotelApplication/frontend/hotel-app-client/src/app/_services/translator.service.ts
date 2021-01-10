import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TranslatorService {
  returnedWord;
  constructor() { }

  translatePillowToPolish(word)
  {
    if (word === 'NATURAL') {
      this.returnedWord = 'naturalna';
    }
    else if (word === 'ANTIALLERGIC') {
      this.returnedWord = 'antyalergiczna';
 }

    return this.returnedWord;
  }
  translateBoolToPolish(word)
  {
      if (word === true) {
        this.returnedWord = 'tak';
      }
      else if (word === false) {
        this.returnedWord = 'nie';
 }

      return this.returnedWord;
  }
  translateTypeToPolish(word) {


    if (word === 'boolean') {
      this.returnedWord = 'tak/nie';
    }
    else if (word === 'string') {
      this.returnedWord = 'tekst';
    }
    else if (word === 'number'){
      this.returnedWord = 'liczba';
    }
    else
    {
      this.returnedWord = 'cena';
    }


    return this.returnedWord;
  }
  translateMonthStringToPolish(word)
  {

    if (word === '1' || word === '01') {
      this.returnedWord = 'stycznia';
    }
    else if (word === '2'|| word === '02') {
      this.returnedWord = 'lutego';
 }
    else if (word === '3'|| word === '03') {
      this.returnedWord = 'marca';
 }
    else if (word === '4'|| word === '04') {
      this.returnedWord = 'kwietnia';
 }
    else if (word === '5'|| word === '05') {
      this.returnedWord = 'maja';
 }
    else if (word === '6'|| word === '06') {
      this.returnedWord = 'czerwca';
 }
    else if (word === '7'|| word === '07') {
      this.returnedWord = 'lipca';
 }
    else if (word === '8'|| word === '08') {
      this.returnedWord = 'sierpnia';
 }
    else if (word === '9'|| word === '09') {
      this.returnedWord = 'września';
 }
    else if (word === '10') {
      this.returnedWord = 'października';
 }
    else if (word === '11') {
      this.returnedWord = 'listopada';
 }
    else if (word === '12') {
      this.returnedWord = 'grudnia';
 }

    return this.returnedWord;
  }
  translateMonthToPolish(word)
{
    word++;
    if (word === 1) {
      this.returnedWord = 'stycznia';
    }
    else if (word === 2) {
      this.returnedWord = 'lutego';
 }
    else if (word === 3) {
      this.returnedWord = 'marca';
 }
    else if (word === 4) {
      this.returnedWord = 'kwietnia';
 }
    else if (word === 5) {
      this.returnedWord = 'maja';
 }
    else if (word === 6) {
      this.returnedWord = 'czerwca';
 }
    else if (word === 7) {
      this.returnedWord = 'lipca';
 }
    else if (word === 8) {
      this.returnedWord = 'sierpnia';
 }
    else if (word === 9) {
      this.returnedWord = 'września';
 }
    else if (word === 10) {
      this.returnedWord = 'października';
 }
    else if (word === 11) {
      this.returnedWord = 'listopada';
 }
    else if (word === 12) {
      this.returnedWord = 'grudnia';
 }

    return this.returnedWord;
}
  fixUnproperHour(word)
  {

    if (word === '0') {
      this.returnedWord = '1';
    }
    else if (word === '1') {
      this.returnedWord = '2';
 }
    else if (word === '2') {
      this.returnedWord = '3';
 }
    else if (word === '3') {
      this.returnedWord = '4';
 }
    else if (word === '4') {
      this.returnedWord = '5';
 }
    else if (word === '5') {
      this.returnedWord = '6';
 }
    else if (word === '6') {
      this.returnedWord = '7';
 }
    else if (word === '7') {
      this.returnedWord = '8';
 }
    else if (word === '8') {
      this.returnedWord = '9';
 }
    else if (word === '9') {
      this.returnedWord = '10';
 }
    else if (word === '10') {
      this.returnedWord = '11';
 }
    else if (word === '11') {
      this.returnedWord = '12';
 }
    else if (word === '12') {
      this.returnedWord = '13';
 }
    else if (word === '13') {
      this.returnedWord = '14';
 }
    else if (word === '14') {
      this.returnedWord = '15';
 }
    else if (word === '15') {
      this.returnedWord = '16';
 }
    else if (word === '16') {
      this.returnedWord = '17';
 }
    else if (word === '17') {
      this.returnedWord = '18';
 }
    else if (word === '18') {
      this.returnedWord = '19';
 }
    else if (word === '19') {
      this.returnedWord = '20';
 }
    else if (word === '20') {
      this.returnedWord = '21';
 }
    else if (word === '21') {
      this.returnedWord = '22';
 }
    else if (word === '22') {
      this.returnedWord = '23';
 }
    else if (word === '23') {
      this.returnedWord = '0';
 }

    return this.returnedWord;
  }
}
