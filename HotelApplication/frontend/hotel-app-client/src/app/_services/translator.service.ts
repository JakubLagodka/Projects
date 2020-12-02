import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TranslatorService {
  returnedWord;
  constructor() { }

  translatePillowToPolish(word)
  {
    if (word === "NATURAL")
      this.returnedWord = "naturalna";
    else if (word === "ANTIALLERGIC")
      this.returnedWord = "antyalergiczna";

    return this.returnedWord;
  }
  translateBoolToPolish(word)
  {
      if (word === true)
        this.returnedWord = "Tak";
      else if (word === false)
        this.returnedWord = "Nie";

    return this.returnedWord;
  }
  translateMonthToPolish(word)
{

    word++;
    if(word === 1)
      this.returnedWord = "Stycznia";
    else if(word === 2)
      this.returnedWord = "Lutego";
    else if(word === 3)
      this.returnedWord = "Marca";
    else if(word === 4)
      this.returnedWord = "Kwietnia";
    else if(word === 5)
      this.returnedWord = "Maja";
    else if(word === 6)
      this.returnedWord = "Czerwca";
    else if(word === 7)
      this.returnedWord = "Lipca";
    else if(word === 8)
      this.returnedWord = "Sierpnia";
    else if(word === 9)
      this.returnedWord = "Września";
    else if(word === 10)
      this.returnedWord = "Października";
    else if(word === 11)
      this.returnedWord = "Listopada";
    else if(word === 12)
      this.returnedWord = "Grudnia";

  return this.returnedWord;
}
}
