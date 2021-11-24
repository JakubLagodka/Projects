import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilesSorter {
    static void moveFile() throws Exception {
        Path path = Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\HOME");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            watchKey.pollEvents().forEach(watchEvent -> {
                String fileName = watchEvent.context().toString();
                Path sourceFile = Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\HOME", fileName);
                FileStatistics fileStatistics;
                try {
                    fileStatistics = FileStatistics.toFileStatistics(Files.readString(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\HOME\\count.txt")));
                } catch (IOException e) {
                    fileStatistics = new FileStatistics();
                }

                try {
                    BasicFileAttributes attr = Files.readAttributes(sourceFile, BasicFileAttributes.class);
                    fileStatistics.increaseTotalCounter();
                    if (fileName.endsWith(".xml")) {
                        Files.move(sourceFile, Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\DEV", fileName), StandardCopyOption.REPLACE_EXISTING);
                        fileStatistics.increaseDevCounter();
                    } else if (fileName.endsWith(".jar")) {
                        if (attr.creationTime().to(TimeUnit.HOURS) % 2 == 0/*czy godzina jest parzysta*/) {
                            Files.move(sourceFile, Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\DEV", fileName), StandardCopyOption.REPLACE_EXISTING);
                            fileStatistics.increaseDevCounter();
                        } else {
                            Files.move(sourceFile, Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\TEST", fileName), StandardCopyOption.REPLACE_EXISTING);
                            fileStatistics.increaseTestCounter();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                } finally {
                    try {
                        System.out.println(fileStatistics);
                        Files.writeString(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\HOME\\count.txt"), fileStatistics.toString(),
                                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            watchKey.reset();
        }
    }

    public static void main(String[] args) throws Exception {
        moveFile();
    }
}
