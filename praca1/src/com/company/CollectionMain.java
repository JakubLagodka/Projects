package com.company;

import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(-1);
        linkedList.add(0);
        Integer integer = minNumber(linkedList);
        System.out.println(integer);

        List<Integer> integers = evenNumber(linkedList);

        System.out.println(integers);

        List<String> strings = new LinkedList<>();
        strings.add("sa");
        strings.add("kuba");
        strings.add("ahgdihgal");
        List<Integer> evenStringLength = evenStringLength(strings);

        System.out.println(evenStringLength);

        List<User> users = new LinkedList<>();

        users.add(new User(1L, "Jan", "Kowalski", 25, 5000.0, Job.JAVA_DEVELOPER, "kowalski@gmail.com"));
        users.add(new User(1L, "Jan", "Kowalski", 25, 50000.0, Job.SCALA_DEVELOPER, "kowalski111@gmail.com"));
        users.add(new User(1L, "Jan", "Kowalski", 25, 5000.0, Job.KOTLIN_DEVELOPER, "kowalski123@gmail.com"));
        users.add(new User(1L, "Jakub", "Kowalski", 25, 5000.0, Job.JAVA_DEVELOPER, "kowalski@gmail.com"));
        users.add(new User(1L, "Jakub", "Kowalski", 25, 5000.0, Job.SCALA_DEVELOPER, "kowalski111@gmail.com"));
        users.add(new User(1L, "Jakub", "Kowalski", 25, 5000.0, Job.KOTLIN_DEVELOPER, "kowalski123@gmail.com"));
        users.add(new User(1L, "Janusz", "Kowalski", 25, 5000.0, Job.JAVA_DEVELOPER, "kowalski@gmail.com"));
        users.add(new User(1L, "Janusz", "Kowalski", 25, 5000.0, Job.SCALA_DEVELOPER, "kowalski111@gmail.com"));
        users.add(new User(1L, "Janusz", "Kowalski", 25, 5000.0, Job.SCALA_DEVELOPER, "kowalski123@gmail.com"));

        List<String> strings1 = userEmails(users);
        System.out.println(strings1);

        List<User> users1 = findUsers(users);
        System.out.println(users1);
        //znalesc userów gdzie job=scala_dev i salary>5000

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

    static List<String> userEmails(List<User> users) {
        List<String> emails = new LinkedList<>();

        for (User user : users) {
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

}

