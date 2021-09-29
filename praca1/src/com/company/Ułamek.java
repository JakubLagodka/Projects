package com.company;

public class Ułamek implements Comparable {
    private double licznik;
    private double mianownik;

    public Ułamek(double licznik, double mianownik) {
        if (mianownik == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
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
        if (mianownik == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
        this.mianownik = mianownik;
    }

    public Ułamek dodaj(Ułamek doDodania) {
        Ułamek suma = new Ułamek(this.licznik + doDodania.licznik, this.mianownik + doDodania.mianownik);
        this.licznik += doDodania.licznik;
        this.mianownik += doDodania.mianownik;
        if (this.mianownik == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
        return suma;
    }

    public Ułamek odejmij(Ułamek doOdjęcia) {
        Ułamek różnica = new Ułamek(this.licznik - doOdjęcia.licznik, this.mianownik - doOdjęcia.mianownik);
        this.licznik -= doOdjęcia.licznik;
        this.mianownik -= doOdjęcia.mianownik;
        if (this.mianownik == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
        return różnica;
    }

    public Ułamek wymnóż(Ułamek doMnożenia) {
        Ułamek iloczyn = new Ułamek(this.licznik * doMnożenia.licznik, this.mianownik * doMnożenia.mianownik);
        this.licznik *= doMnożenia.licznik;
        this.mianownik *= doMnożenia.mianownik;
        if (this.mianownik == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
        return iloczyn;
    }

    public Ułamek podziel(Ułamek doDzielenia) {
        Ułamek iloraz = new Ułamek(this.licznik / doDzielenia.licznik, this.mianownik / doDzielenia.mianownik);
        this.licznik /= doDzielenia.licznik;
        this.mianownik /= doDzielenia.mianownik;
        if (this.mianownik == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
        return iloraz;
    }

    public Ułamek skróć() {
        Ułamek wynik = this;
        // for (int i = this.licznik)
        return wynik;
    }

    public double zapisDziesiętny() {
        return 0.0;
    }

    public Ułamek potęguj() {
        Ułamek wynik = this;
        return wynik;
    }

    public Ułamek pierwiastkuj() {
        Ułamek wynik = this;
        return wynik;
    }

    @Override
    public int compareTo(Object ułamek) {

        return this.compareTo(ułamek);
    }
}
