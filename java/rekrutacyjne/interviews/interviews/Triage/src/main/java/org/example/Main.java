package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Prepare a program when we can assign patients to doctors based on triage result.
//
//Every patient will have assigned severity (number from 1 to 4 - we can randomize it)
// and time which treatment will take (1-10 seconds - could be randomized).
//        1 - almost died - should see doctor asap
//4 - probably lied - can wait
//
//In our hospital we have a various number of doctors, which can treat patients.
//
//Our program needs to assign patients to doctors based on triage severity.
// We should avoid situation when single doctor will treat all the patients.
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Patient(1, 1));
        Thread thread1 = new Thread(new Patient(2, 1));
        Thread thread2 = new Thread(new Patient(3, 1));
        Thread thread3 = new Thread(new Patient(4, 1));

        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);

        executorService.shutdown();
    }
}