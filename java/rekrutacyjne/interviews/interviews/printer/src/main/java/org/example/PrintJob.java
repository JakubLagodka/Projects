package org.example;

import java.util.Random;

public class PrintJob implements Runnable {

    private final String[] pages;
    private final int pagesCount;
    private final int threadNumber;

    public PrintJob(String[] pages, int pagesCount, int threadNumber) {
        this.pages = pages;
        this.pagesCount = pagesCount;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < pagesCount; i++) {
            try {
                var waitTime = new Random().nextInt() % 1001 + 100;
                Thread.sleep(Math.abs(waitTime));
                System.out.println(String.format("Thread#: [%s], pagesCount: [%s] - %s", threadNumber, pagesCount, pages[i]));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
