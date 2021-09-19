package com.company;

import java.util.*;

public class MapMain {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Kuba");
        map.put(1, "Janusz");
        map.put(2, "Marek");
        map.put(3, "Ania");
        map.put(4, "Basia");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
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
        users.add(new User(10L, "Robert", "Nowak", 34, 5001.55, Job.SCALA_DEVELOPER, "123nowak@gmail.com"));

        Map<Long, User> longUserMap = groupUsersById(users);
        System.out.println(longUserMap);

        Map<Job, List<User>> jobListMap = groupUsersByJob(users);
        System.out.println(jobListMap);

        UserProxyService userProxyService = new UserProxyService();
        userProxyService.save(users.get(0));
        System.out.println(userProxyService.getById(1L));

        users.get(0).setAge(55);
        userProxyService.update(users.get(0));
        System.out.println(userProxyService.getById(1L));

        userProxyService.deleteById(1L);

        Map<Job, Integer> jobIntegerMap = countUsersByJob(users);
        System.out.println(jobIntegerMap);

        Map<Job, Double> jobDoubleMap = countSumSalaryByJob(users);
        System.out.println(jobDoubleMap);
    }

    static Map<Long, User> groupUsersById(List<User> users) {
        Map<Long, User> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.put(user.getId(), user);
        }
        return groupedUsers;
    }

    static Map<Job, List<User>> groupUsersByJob(List<User> users) {
        Map<Job, List<User>> groupedUsers = new EnumMap<>(Job.class);
        for (User user : users) {
            List<User> userList = groupedUsers.get(user.getJob());
            if(userList == null){
                userList = new LinkedList<>();
            }
            userList.add(user);
            groupedUsers.put(user.getJob(), userList);
        }
        return groupedUsers;
    }

    static Map<Job, Integer> countUsersByJob(List<User> users){
        Map<Job,Integer> usersCount = new EnumMap<>(Job.class);
        for (User user : users) {
            Integer count = usersCount.get(user.getJob());
            if(count == null){
                count = 0;
            }
            count++;
            usersCount.put(user.getJob(), count);
        }
        return usersCount;
    }

    static Map<Job, Double> countSumSalaryByJob(List<User> users){
        Map<Job,Double> salarySum = new EnumMap<>(Job.class);
        for (User user : users) {
            Double salary = salarySum.get(user.getJob());
            if(salary == null){
                salary = 0.0;
            }
            salary += user.getSalary();
            salarySum.put(user.getJob(),salary);
        }
        return salarySum;
    }
}
