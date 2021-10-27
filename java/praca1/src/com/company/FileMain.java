package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileMain {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("C:\\Users\\Kuba\\Desktop\\Programs\\java\\praca1\\src\\com\\company\\imput.txt"))
                .forEach(System.out::println);
        //spróbować Enuma
    }
}
