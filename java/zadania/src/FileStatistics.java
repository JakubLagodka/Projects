public class FileStatistics {

    private int totalCounter;
    private int devCounter;
    private int testCounter;

    public static FileStatistics toFileStatistics(String text) {
//        System.out.println(text);
        String[] split = text.split("\n");
        FileStatistics fileStatistics = new FileStatistics();

        fileStatistics.totalCounter = Integer.parseInt(split[0].split(" ")[2]);
        fileStatistics.devCounter = Integer.parseInt(split[1].split(" ")[2]);
        fileStatistics.testCounter = Integer.parseInt(split[2].split(" ")[2]);
        return fileStatistics;
    }

    public void increaseTotalCounter() {
        totalCounter++;
        System.out.println("increaseTotalCounter = " + totalCounter);
    }


    public void increaseDevCounter() {
        devCounter++;
        System.out.println("increasedevlCounter = " + devCounter);
    }


    public void increaseTestCounter() {
        testCounter++;
        System.out.println("increasetestCounter = " + testCounter);
    }

    @Override
    public String toString() {
        return "totalCounter = " + totalCounter +
                "\ndevCounter = " + devCounter +
                "\ntestCounter = " + testCounter;
    }
}
