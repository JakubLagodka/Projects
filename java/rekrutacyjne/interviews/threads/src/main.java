import java.util.ArrayList;
import java.util.HashMap;

public class main {
}
import java.io.IOException;
import java.io.SyncFailedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.*;

public class MultistageFileProcessor {

    private final Path inputFile;
    private final Path outputFile;
    private final int amountOfTransformerThreads;

    private BlockingQueue<String> readerQueue;
    private BlockingQueue<String> writerQueue;

    public MultistageFileProcessor(Path inputFile, Path outputFile, int backpressureAmount, int amountOfTransformerThreads) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.amountOfTransformerThreads = amountOfTransformerThreads;

        readerQueue = new ArrayBlockingQueue<>(backpressureAmount);
        writerQueue = new LinkedBlockingQueue<>();
            new HashMap<>();
    }

    public void process() throws ExecutionException, InterruptedException {
//        Future<ReaderThread> submit = Executors.newSingleThreadExecutor()
//                .submit(() -> new ReaderThread());
//
//
//        submit.get();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<ReaderThread> submit = executorService.submit(() -> new ReaderThread());
        submit.get();

        executorService.shutdown();

//        new Thread(new ReaderThread()).start();


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Path inputFile = Path.of("generated_5MB_lowercase.txt");
        Path outputFile = Path.of("outputFile.txt");

        new MultistageFileProcessor(inputFile, outputFile, 1000, 2)
                .process();
    }

    class ReaderThread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("In thread.");
                Files.lines(inputFile)
                        .peek(System.out::println)
                        .forEach(line -> {
                            try {
                                readerQueue.put(line);

//                                if (readerQueue.size() % 100 == 0) {
//                                    System.out.println("Reader queue size: " + readerQueue.size());
//                                }
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

import java.io.IOException;
import java.io.SyncFailedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.*;

    public class MultistageFileProcessor {

        private final Path inputFile;
        private final Path outputFile;
        private final int amountOfTransformerThreads;

        private BlockingQueue<String> readerQueue;
        private BlockingQueue<String> writerQueue;

        public MultistageFileProcessor(Path inputFile, Path outputFile, int backpressureAmount, int amountOfTransformerThreads) {
            this.inputFile = inputFile;
            this.outputFile = outputFile;
            this.amountOfTransformerThreads = amountOfTransformerThreads;

            readerQueue = new ArrayBlockingQueue<>(backpressureAmount);
            writerQueue = new LinkedBlockingQueue<>();
        }

        public void process() throws ExecutionException, InterruptedException {
//        Future<ReaderThread> submit = Executors.newSingleThreadExecutor()
//                .submit(() -> new ReaderThread());
//
//
//        submit.get();

//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<ReaderThread> submit = executorService.submit(() -> new ReaderThread());
//        submit.get();
//
//        executorService.shutdown();


            ExecutorService executorService = Executors.newFixedThreadPool(1);
            Future<?> future = executorService.submit(() -> {
                ReaderThread readerThread = new ReaderThread();
                readerThread.run(); // explicitly call run
            });
            future.get();
            executorService.shutdown();





//        new Thread(new ReaderThread()).start();


        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            Path inputFile = Path.of("generated_5MB_lowercase.txt");
            Path outputFile = Path.of("outputFile.txt");

            new MultistageFileProcessor(inputFile, outputFile, 1000, 2)
                    .process();
        }

        class ReaderThread implements Runnable {

            @Override
            public void run() {
                try {
                    System.out.println("In thread.");
                    Files.lines(inputFile)
                            .peek(System.out::println)
                            .forEach(line -> {
                                try {
                                    readerQueue.put(line);

//                                if (readerQueue.size() % 100 == 0) {
//                                    System.out.println("Reader queue size: " + readerQueue.size());
//                                }
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
