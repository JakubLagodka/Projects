package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileMain {
    public static void main(String[] args) throws IOException {
        List<String> collect = Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\praca1\\src\\com\\company\\imput.txt"))
                .map(line -> line.split(" "))
                .map(line -> Operation.findOperationBySign(line[1]).calculate(Double.parseDouble(line[0]), Double.parseDouble(line[2])).toString())
                .collect(Collectors.toList());
        Files.write(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\praca1\\src\\com\\company\\output.txt"), collect,
                StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
