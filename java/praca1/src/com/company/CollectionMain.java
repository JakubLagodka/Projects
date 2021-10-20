package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        //strings.add("ahgdihgal");

        List<Integer> integerList = new LinkedList<>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(9);

        List<Integer> evenStringLength = evenStringLength(strings);

        System.out.println(evenStringLength);

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
        List<String> strings1 = findUserEmailsWhoseIdIsOdd(users);
        System.out.println(strings1);

        List<User> users1 = findUsers(users);
        System.out.println(users1);

        List<Integer> oddOrEvenAgeList = findOddOrEvenAge(users);
        System.out.println(oddOrEvenAgeList);

        List<User> usersScalaAndKotlin = findUsersScalaAndKotlin(users);
        System.out.println(usersScalaAndKotlin);

        List<Job> jobsWithLowSalary = findJobsWithLowSalary(users);
        System.out.println(jobsWithLowSalary);

        List<User> specifiedUsers = findSpecifiedUsers(users);
        System.out.println(specifiedUsers);


        /*Map<Integer, String> integerStringMap = findStrings(integerList, strings);
        for (Integer integer1 : integerList) {
            if (integerStringMap.containsKey(integer1)) {
                System.out.println(integerStringMap.get(integer1));
            }
        }

        //lub takie rozwiązanie:
        for (Map.Entry<Integer, String> entry : integerStringMap.entrySet()) {
            System.out.println("pair: " + entry.getKey() + ", value: " + entry.getValue());
        }*/

        List<Pair> pairs = findStrings(integerList, strings);
        for (Pair pair : pairs) {
            System.out.println(pair.getKey() + ", " + pair.getValue());
        }
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

    //zawsze zwiększa się tablica o 1 w arrayList. przy usuwaniu rozmiar tablicy się nie zmniejsza, ale indeks zmniejsza się o 1.
//poczytać o treeSet i linkedHashSet
//linkedHashMap, TreeMap i EnumMap - pytali na każdej rozmowie o funkcję put(). Na kluczu wywoływana jest metoda HashCode, która zwraca indeks
    // tablicy i sprawdzany jest czy nie ma obiektu, jeśli nie, to klucz jest wstawiany i kończy się działanie, a jeśli jest obiekt
    //sprawdzana jest equals, jeśli tak, to wartość jest nadpisywana, a jeśli nie, to tworzy się linkedlista, do której wstawiany jest
    //poprzedny element i obecny ( w get wtedy jest iteracja po każdym elemencie dopóki nie znajdzie true).
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
//przerobić na Math.min()
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
        //Math.min(integers.size(),strings.size());
        return foundPairs;
    }
}

