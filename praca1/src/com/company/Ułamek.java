package com.company;

public class Ułamek implements Comparable {
    private int licznik;
    private int mianownik;

    public Ułamek(int licznik, int mianownik) {
        if (mianownik == 0)
            throw new NoZeroDivideException("Ułamek nie może mieć zera w mianowniku!");
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    public int getLicznik() {
        return licznik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public void setMianownik(int mianownik) {
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
         for (int i = this.licznik; i < 1; i--)
         {
             if(this.licznik % i == 0 && this.mianownik % i == 0)
             {
                 wynik.licznik = this.licznik = this.licznik / i;
                 wynik.mianownik = this.mianownik = this.mianownik / i;
             }
         }
        return wynik;
    }

    public double zapisDziesiętny() {
        return 0.0;
    }

    public Ułamek potęguj(int wykladnik) {
        Ułamek wynik = this;

        wynik.licznik = this.licznik = (int) Math.pow(this.licznik, wykladnik);
        wynik.mianownik = this.mianownik = (int) Math.pow(this.mianownik, wykladnik);

        return wynik;
    }

    public Ułamek pierwiastkuj() {
        Ułamek wynik = this;

        wynik.licznik = this.licznik = (int) Math.sqrt(this.licznik);
        wynik.mianownik = this.mianownik = (int) Math.sqrt(this.mianownik);

        return wynik;
    }

    @Override
    public int compareTo(Object ułamek) {

        return this.compareTo(ułamek);
    }
}
