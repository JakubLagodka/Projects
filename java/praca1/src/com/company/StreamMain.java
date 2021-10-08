package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        System.out.println(Stream.of(1,2,3)
                .findFirst());

        System.out.println(Stream.of(1,2,3)
                .findAny());

        System.out.println(Stream.of(1,2,3)
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
    }

    static List<Integer> evenStringsLength(List<String> strings){
        return strings.stream()
                .map(String::length)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    static List<String> findEmails(List<User> userList){
        return userList.stream()
                .filter(user -> user.getJob() == Job.JAVA_DEVELOPER && user.getAge() > 30)
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    static List<Integer> flatIntegers(List<List<Integer>> listList){
        return listList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    static boolean isJavaDeveloper(List<User> users){
        return users.stream()
                .allMatch(user -> user.getJob() == Job.JAVA_DEVELOPER);
    }

    static boolean isAnyUser(List<User> users){
        return users.stream()
                .anyMatch(user -> user.getAge() < 30 && user.getSalary() > 20000);
    }
    static Map<Long,User> groupById(List<User> users){
        return users.stream()
                //.collect(Collectors.toMap(User::getId,user -> user));
             .collect(Collectors.toMap(User::getId, Function.identity()));
    }
    static Integer minNumber(List<Integer> list) {
        Integer min = list.get(0);

        for (Integer integer : list) {
            if (integer < min)
                min = integer;
        }
        return min;
    }

    static List<Integer> evenNumber(List<Integer> list) {
        List<Integer> result = new LinkedList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                result.add(integer);
            }
        }
        return result;
    }

    static List<Integer> evenStringLength(List<String> strings) {
        List<Integer> result = new LinkedList<>();

        for (String string : strings) {
            if (string.length() % 2 == 0) {
                result.add(string.length());
            }
        }
        return result;
    }

    static List<String> findUserEmailsWhoseIdIsOdd(List<User> users) {
        List<String> emails = new LinkedList<>();

        for (User user : users) {
            if (user.getId() % 2 != 0)
                emails.add(user.getEmail());
        }
        return emails;

    }

    static List<User> findUsers(List<User> users) {
        List<User> foundUsers = new LinkedList<>();
        for (User user : users) {
            if (user.getJob() == Job.SCALA_DEVELOPER && user.getSalary() > 5000) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    static List<Integer> findOddOrEvenAge(List<User> users) {
        List<Integer> evenAge = new LinkedList<>();
        List<Integer> oddAge = new LinkedList<>();
        for (User user : users) {
            if (user.getAge() % 2 != 0) {
                oddAge.add(user.getAge());
            } else
                evenAge.add(user.getAge());

        }
        if (evenAge.size() > oddAge.size()) {
            return evenAge;
        } else {
            return oddAge;
        }
    }

    static List<User> findUsersScalaAndKotlin(List<User> users) {
        List<User> returnedUsers = new LinkedList<>();
        for (User user : users) {
            if (user.getJob() == Job.SCALA_DEVELOPER || user.getJob() == Job.KOTLIN_DEVELOPER) {
                returnedUsers.add(user);
            }
        }
        return returnedUsers;
    }

    static List<Job> findJobsWithLowSalary(List<User> users) {
        List<Job> jobs = new LinkedList<>();
        for (User user : users) {
            if (user.getSalary() < 2000 && !jobs.contains(user.getJob())) {
                jobs.add(user.getJob());
            }
        }
        return jobs;
    }

    static List<User> findSpecifiedUsers(List<User> users) {
        List<User> foundUsers = new LinkedList<>();
        for (User user : users) {
            if ((user.getJob() == Job.SCALA_DEVELOPER && user.getSalary() > 2000) || (user.getJob() == Job.KOTLIN_DEVELOPER && user.getAge() < 30)) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    /*static Map<Integer, String> findStrings(List<Integer> integers, List<String> strings) {
        Map<Integer, String> foundPairs = new HashMap<>();
        int index = 0;
        for (String string : strings) {
            if (string.length() == integers.get(index)) {
                foundPairs.put(integers.get(index), string);
            }
            index++;
        }
        return foundPairs;
    }*/

    static List<Pair> findStrings(List<Integer> integers, List<String> strings) {
        List<Pair> foundPairs = new LinkedList<>();
        int index = 0;
        if (integers.size() < strings.size()) {
            for (Integer integer : integers) {
                if (integer == strings.get(index).length()) {
                    foundPairs.add(new Pair(integer, strings.get(index)));
                    index++;
                }
            }
        } else {
            for (String string : strings) {
                if (integers.get(index) == string.length()) {
                    foundPairs.add(new Pair(integers.get(index), string));
                    index++;
                }
            }
        }
        return foundPairs;
    }
}
