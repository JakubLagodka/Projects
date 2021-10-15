package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .filter(i -> {
                    System.out.println("filter " + i);
                    return i % 2 == 0;
                }).map(i -> {
                    System.out.println("map " + i);
                    return i * 2;
                })
                .forEach(System.out::println);
//        Stream<Integer> stream = Stream.of(1,2,3);
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);
        System.out.println(Stream.of(1, 2, 3)
                .findFirst());

        System.out.println(Stream.of(1, 2, 3)
                .findAny());

        System.out.println(Stream.of(1, 2, 3)
                .parallel()
                .findAny());

        List<String> strings = new LinkedList<>();
        strings.add("sa");
        strings.add("kuba");
        strings.add("ahgdihgal");

        System.out.println(evenStringsLength(strings));

        List<User> users = new LinkedList<>();

        users.add(new User(1L, "Jan", "Kowalski", 25, 5000.0, Job.JAVA_DEVELOPER, "kowalski@gmail.com"));
        users.add(new User(2L, "Jan", "Kowalski", 26, 50000.0, Job.SCALA_DEVELOPER, "kowalski1@gmail.com"));
        users.add(new User(3L, "Jan", "Nowak", 27, 1500.0, Job.KOTLIN_DEVELOPER, "nowak123@gmail.com"));
        users.add(new User(4L, "Jakub", "Kowalski", 28, 7800.0, Job.JAVA_DEVELOPER, "kowalski11@gmail.com"));
        users.add(new User(5L, "Jakub", "Nowak", 29, 15000.0, Job.SCALA_DEVELOPER, "nowak111@gmail.com"));
        users.add(new User(6L, "Jakub", "Kowalski", 20, 500.0, Job.KOTLIN_DEVELOPER, "kowalski123@gmail.com"));
        users.add(new User(7L, "Janusz", "Nowak", 30, 2000.0, Job.JAVA_DEVELOPER, "nowak@gmail.com"));
        users.add(new User(8L, "Janusz", "Kowalski", 31, 5000.0, Job.SCALA_DEVELOPER, "kowalski111@gmail.com"));
        users.add(new User(9L, "Janusz", "Kowalski", 32, 1900.0, Job.SCALA_DEVELOPER, "123kowalski@gmail.com"));
        users.add(new User(10L, "Robert", "Nowak", 34, 5001.0, Job.SCALA_DEVELOPER, "123nowak@gmail.com"));

        System.out.println(findEmails(users));

        System.out.println(isAnyUser(users));

        System.out.println(isJavaDeveloper(users));

        System.out.println(hasUserGoodSalary(users));

        System.out.println(groupById(users));

        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> linkedList = new ArrayList<>();
        linkedList.add(10);
        linkedList.add(-1);
        linkedList.add(0);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(9);

        listList.add(linkedList);
        listList.add(integerList);

        System.out.println(flatIntegers(listList));

        System.out.println(minNumber(integerList));

        System.out.println(evenNumber(integerList));

        System.out.println(evenStringLength(strings));

        System.out.println(findUserEmailsWhoseIdIsOdd(users));

        System.out.println(findUsers(users));

        System.out.println(findOddOrEvenAge(users));

        System.out.println(findJobsWithLowSalary(users));

        System.out.println(findSpecifiedUsers(users));

        System.out.println(findUsersScalaAndKotlin(users));

    }

    static List<Integer> evenStringsLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    static List<String> findEmails(List<User> userList) {
        return userList.stream()
                .filter(user -> user.getJob() == Job.JAVA_DEVELOPER && user.getAge() > 30)
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    static List<Integer> flatIntegers(List<List<Integer>> listList) {
        return listList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    static boolean isJavaDeveloper(List<User> users) {
        return users.stream()
                .allMatch(user -> user.getJob() == Job.JAVA_DEVELOPER);
    }

    static boolean isAnyUser(List<User> users) {
        return users.stream()
                .anyMatch(user -> user.getAge() < 30 && user.getSalary() > 20000);
    }

    static boolean hasUserGoodSalary (List<User> users){
        return users.stream()
                .noneMatch(user -> user.getSalary() < 2000);
    }

    static Map<Long, User> groupById(List<User> users) {
        return users.stream()
                //.collect(Collectors.toMap(User::getId,user -> user));
                .collect(Collectors.toMap(User::getId, Function.identity()));
    }

    static Optional<Integer> minNumber(List<Integer> list) {

        return list.stream()
                .min(Comparator.naturalOrder());
    }

    static List<Integer> evenNumber(List<Integer> list) {

        return list.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    static List<Integer> evenStringLength(List<String> strings) {

        return strings.stream()
                .map(String::length)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    static List<String> findUserEmailsWhoseIdIsOdd(List<User> users) {

        return users.stream()
                .filter(user -> user.getId() % 2 == 0)
                .map(User::getEmail)
                .collect(Collectors.toList());

    }

    static List<User> findUsers(List<User> users) {

        return users.stream()
                .filter(user -> user.getJob() == Job.SCALA_DEVELOPER && user.getSalary() > 5000)
                .collect(Collectors.toList());
    }

    static List<Integer> findOddOrEvenAge(List<User> users) {

        if (users.stream()
                .filter(user -> user.getAge() % 2 == 0)
                .count() >
                users.stream()
                        .filter(user -> user.getAge() % 2 != 0)
                        .count()) {
            return users.stream()
                    .map(User::getAge)
                    .filter(i -> i % 2 == 0)
                    .collect(Collectors.toList());
        } else {
            return users.stream()
                    .map(User::getAge)
                    .filter(i -> i % 2 != 0)
                    .collect(Collectors.toList());
        }
    }

    static List<User> findUsersScalaAndKotlin(List<User> users) {

        return users.stream()
                .filter(user -> user.getJob() == Job.SCALA_DEVELOPER || user.getJob() == Job.KOTLIN_DEVELOPER)
                .collect(Collectors.toList());
    }

    static List<Job> findJobsWithLowSalary(List<User> users) {

        return users.stream()
                .filter(user -> user.getSalary() < 2000)
                .map(User::getJob)
                .distinct()
                .collect(Collectors.toList());
    }

    static List<User> findSpecifiedUsers(List<User> users) {

        return users.stream()
                .filter((user -> (user.getJob() == Job.SCALA_DEVELOPER && user.getSalary() > 2000) ||
                        (user.getJob() == Job.KOTLIN_DEVELOPER && user.getAge() < 30)))
                .collect(Collectors.toList());
    }


    /*static List<Pair> findStrings(List<Integer> integers, List<String> strings) {

    }*/

    static Map<Long, User> groupUsersById(List<User> users){
        return users.stream()
                .collect(Collectors.toMap(User::getId,Function.identity()));
    }

    static Map<Job, List<User>> groupUsersByJob(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getJob));
    }

    static Map<Job, Long> countUsersByJob(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getJob,Collectors.counting()));
    }

    static Map<Job,Double> sumSalariesByJob(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getJob,Collectors.summingDouble(User::getSalary)));
    }

    static Map<Job, Set<String>> groupEmailsByJob(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getJob,Collectors.mapping(User::getEmail,Collectors.toSet())));
    }
}
