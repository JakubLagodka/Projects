package com.company;

public class Ułamek implements Comparable<Ułamek> {
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

        if (this.mianownik != doDodania.mianownik) {
            //NNW

            for (int i = this.mianownik; ; i += this.mianownik) {
                if (i % doDodania.mianownik == 0) {
                    int ileRazyPierwotny = i / this.mianownik;
                    this.mianownik = i;
                    this.licznik *= ileRazyPierwotny;
                    int ileRazyDoDodania = i / doDodania.mianownik;
                    doDodania.licznik *= ileRazyDoDodania;
                    doDodania.mianownik = i;
                    break;
                }
            }
        }

        this.licznik += doDodania.licznik;
        skróć();
        return this;
    }

    public Ułamek odejmij(Ułamek doOdjęcia) {

        if (this.mianownik != doOdjęcia.mianownik) {
            //NNW

            for (int i = this.mianownik; ; i += this.mianownik) {
                if (i % doOdjęcia.mianownik == 0) {
                    int ileRazyPierwotny = i / this.mianownik;
                    this.mianownik = i;
                    this.licznik *= ileRazyPierwotny;
                    int ileRazyDoOdjecia = i / doOdjęcia.mianownik;
                    doOdjęcia.licznik *= ileRazyDoOdjecia;
                    doOdjęcia.mianownik = i;
                    break;
                }
            }
        }
        this.licznik -= doOdjęcia.licznik;
        skróć();
        return this;
    }

    public Ułamek wymnóż(Ułamek doMnożenia) {

        this.licznik *= doMnożenia.licznik;
        this.mianownik *= doMnożenia.mianownik;

        return this;
    }

    public Ułamek podziel(Ułamek doDzielenia) {

        this.licznik *= doDzielenia.mianownik;
        this.mianownik *= doDzielenia.licznik;

        return this;
    }

    public Ułamek skróć() {

        for (int i = this.licznik; i > 1; i--) {
            if (this.licznik % i == 0 && this.mianownik % i == 0) {
                this.licznik /= i;
                this.mianownik /= i;
                break;
            }
        }
        return this;
    }

    public double zapisDziesiętny() {
        return (double) this.licznik / (double) this.mianownik;
    }

    public Ułamek potęguj(int wykladnik) {

        this.licznik = (int) Math.pow(this.licznik, wykladnik);
        this.mianownik = (int) Math.pow(this.mianownik, wykladnik);

        return this;
    }

    public Ułamek pierwiastkuj() {

        this.licznik = (int) Math.sqrt(this.licznik);
        this.mianownik = (int) Math.sqrt(this.mianownik);

        return this;
    }



    @Override
    public String toString() {
        return "Ułamek{" +
                "licznik=" + licznik +
                ", mianownik=" + mianownik +
                '}';
    }

    @Override
    public int compareTo(Ułamek o) {
        return 0;
    }
}
