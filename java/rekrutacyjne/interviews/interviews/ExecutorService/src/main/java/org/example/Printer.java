package org.example;

import java.util.Random;

public class Printer {

    public synchronized void  print(String document) {
        Random random = new Random(1000);
        try {

            String[] pages = document.split("\n");

            for(int i=0; i<=pages.length -1; i++) {
                Thread.sleep(random.nextInt(1000));

                System.out.println(pages[i]);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}