import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

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
                try {
                    if (fileName.endsWith(".xml")) {
                        Files.move(sourceFile, Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\DEV", fileName));
                    } else if (fileName.endsWith(".jar")) {
                        if (true/*czy godzina jest parzysta*/)
                            Files.move(sourceFile, Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\DEV", fileName));
                        else
                            Files.move(sourceFile, Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\TEST", fileName));
                    }
                } catch (IOException e) {

                } finally {
                    List<String> collect = new ArrayList<>();
                    collect.add("liczba przeniesionych plików = ");
                    try {
                        Files.write(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\praca1\\src\\com\\company\\output.txt"), collect,
                                StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);
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
