package com.company;

public class Ułamek {
    private double licznik;
    private double mianownik;

    public Ułamek(double licznik, double mianownik) {
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    public double getLicznik() {
        return licznik;
    }

    public void setLicznik(double licznik) {
        this.licznik = licznik;
    }

    public double getMianownik() {
        return mianownik;
    }

    public void setMianownik(double mianownik) {
        this.mianownik = mianownik;
    }

    public Ułamek dodaj(Ułamek doDodania) {
        Ułamek suma = new Ułamek(this.licznik + doDodania.licznik, this.mianownik + doDodania.mianownik);
        this.licznik += doDodania.licznik;
        this.mianownik += doDodania.mianownik;
        return suma;
    }

    public Ułamek odejmij(Ułamek doOdjęcia) {
        Ułamek różnica = new Ułamek(this.licznik - doOdjęcia.licznik, this.mianownik - doOdjęcia.mianownik);
        this.licznik -= doOdjęcia.licznik;
        this.mianownik -= doOdjęcia.mianownik;
        return różnica;
    }

    public Ułamek wymnóż(Ułamek doMnożenia){
        Ułamek iloczyn = new Ułamek(this.licznik * doMnożenia.licznik, this.mianownik * doMnożenia.mianownik);
        this.licznik *= doMnożenia.licznik;
        this.mianownik *= doMnożenia.mianownik;
        return iloczyn;
    }

    public Ułamek podziel(Ułamek doDzielenia){
        Ułamek iloraz = new Ułamek(this.licznik / doDzielenia.licznik, this.mianownik / doDzielenia.mianownik);
        this.licznik /= doDzielenia.licznik;
        this.mianownik /= doDzielenia.mianownik;
        return iloraz;
    }

    /*public Ułamek skróć(){
        Ułamek
    }*/
}
