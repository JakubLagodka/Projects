import java.io.IOException;
import java.nio.file.*;

public class MoveFile {
    static void moveFile() throws Exception {
        Path path = Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\A");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            watchKey.pollEvents().forEach(watchEvent -> {
                String fileName = watchEvent.context().toString();
                Path sourceFile = Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\A", fileName);
                try {
                    if (fileName.endsWith(".txt")) {
                        Files.move(sourceFile, Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\katalogi\\TXT", fileName));
                    } else if (fileName.endsWith(".csv")){
                        Files.delete(sourceFile);
                    }
                } catch (IOException e) {

                }

            });
            watchKey.reset();
        }
    }

    public static void main(String[] args) throws Exception {
        moveFile();
    }
}
