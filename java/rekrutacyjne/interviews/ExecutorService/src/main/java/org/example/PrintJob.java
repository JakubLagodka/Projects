package org.example;

public class PrintJob implements Runnable{
    String document;
    Printer printer;

    public PrintJob(Printer printer, String document) {
        this.document = document;
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print(document);
    }
}