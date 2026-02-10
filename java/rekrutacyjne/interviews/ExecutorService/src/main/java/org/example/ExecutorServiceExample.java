package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        String document1 = """ 
                document1 line 1
                document1 line 2
                document1 line 3""";

        String document2 = """
                document2 line 1
                document2 line 2""";

        String document3 = """ 
                document3 line 1
                document3 line 2
                document3 line 3
                document3 line 4""";

        Printer printer = new Printer();
        executorService.submit(new PrintJob(printer, document1));
        Thread thread1 = new Thread(new PrintJob(printer, document1));
        Thread thread2 = new Thread(new PrintJob(printer, document2));
        Thread thread3 = new Thread(new PrintJob(printer, document3));

        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);

        executorService.shutdown();
    }
}