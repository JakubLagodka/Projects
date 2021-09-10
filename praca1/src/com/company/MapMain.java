package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        users.add(new User(10L, "Robert", "Nowak", 34, 5001.0, Job.SCALA_DEVELOPER, "123nowak@gmail.com"));

        Map<Long, User> longUserMap = groupUsersById(users);
        System.out.println(longUserMap);

        Map<Job, List<User>> jobListMap = groupUsersByJob(users);
        System.out.println(jobListMap);
    }

    static Map<Long, User> groupUsersById(List<User> users) {
        Map<Long, User> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.put(user.getId(), user);
        }
        return groupedUsers;
    }

    static Map<Job, List<User>> groupUsersByJob(List<User> users) {
        Map<Job, List<User>> groupedUsers = new HashMap<>();
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
}