package org.example;

import java.util.concurrent.*;
//Implement a printer simulator handling multiple threads.
// Ensure only one page of a document is printed at a time.
//        · Create a Printer class with a print(String document) method.
// · Implement a PrintJob class as a Runnable representing printing tasks.
// Each task should print a random number of pages (e.g., from 1 to 10),
// and each page should take a random number of milliseconds to print (e.g., from 100 to 1000).
//        · Synchronize printing in the Printer class to ensure single-page printing.
//        · Instantiate a printer object and threads in the Main class to test synchronization.
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String document1 = """
                page1
                page2
                page3
                page4
                page5
                page6
                page7
                page8
                page9
                page11
                page12
                page13
                page14
                page15
                page16
                page17
                page18
                page19
                """;

        var es = Executors.newSingleThreadExecutor();

        var printer = new Printer(es);
        printer.print(document1);
    }
}
