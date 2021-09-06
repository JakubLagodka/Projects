package com.company;

import java.util.*;

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

        List<Integer> integerList = new LinkedList<>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(8);

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


        Map<Integer, String> integerStringMap = findStrings(strings, integerList);
        for(int i = 0; i < strings.size(); i++)
        {
            System.out.println(integerStringMap.get(i));
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
    static Map<Integer, String> findStrings(List<String> strings, List<Integer> integers){
        Map<Integer,String> foundPairs = new Map() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            @Override
            public Object remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set keySet() {
                return null;
            }

            @Override
            public Collection values() {
                return null;
            }

            @Override
            public Set<Entry> entrySet() {
                return null;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
        int counter = 0;
        for (String string : strings) {
            if(string.length() == integers.get(counter)){
                foundPairs.put(integers.get(counter),string);
            }
        }
        return foundPairs;
    }
}

