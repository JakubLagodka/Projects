package org.example;

import org.example.PrintJob;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Printer {

    private final ExecutorService executorService;

    public Printer(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void print(String document) throws ExecutionException, InterruptedException {
        String[] pages = document.split("\n");
        // TODO chunking to random batches of pages

        var pagesCount = Math.abs(new Random().nextInt() % 11 + 1);
        var task = new PrintJob(pages, pagesCount, 1);

        var pagesCount2 = Math.abs(new Random().nextInt() % 11 + 1);
        var task2 = new PrintJob(pages, pagesCount2, 2);

        var pagesCount3 = Math.abs(new Random().nextInt() % 11 + 1);
        var task3 = new PrintJob(pages, pagesCount3, 3);

        var tasks = List.of(task, task2, task3);

        var submittedTasks = tasks.stream().map(executorService::submit).toList();

        for (Future<?> submittedTask : submittedTasks) {
            submittedTask.get();
        }

        System.out.println("bp");
    }
}
