package org.example;
//Warehouse:
//sells beer (thus should have a method like sellBeer)
//automatically places orders for beer to the appropriate brewery if stock runs low
// (if the quantity of bottles of a particular type of beer is less than 100)
//accepts beer deliveries (thus should have a corresponding method - for example, acceptBeer)
//generates a report on the quantity of each type of beer (also a corresponding method -
// a textual report with a list of beers in the format <BEER> (<BREWERY>) : <QUANTITY>)
//        For now, the warehouse is just starting up, so it only knows about 2 breweries
//        (Czarnków Brewery and Miłosław Brewery) - each of them has its own interface that accepts orders.
//        Someday, in the unspecified future, they will send beer and call the acceptBeer method :)
//From the Czarnków Brewery, you can order these beers:
//noteckie jasne
//noteckie ciemne eire
//From the Miłosław Brewery, you can order these beers:
//komes porter
//miłosław pils
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}