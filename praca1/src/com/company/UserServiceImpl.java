package com.company;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final List<User> userList;

    public UserServiceImpl() {

        this.userList = new LinkedList<>();
    }

    @Override
    public User save(User user) {
        userList.add(user);
        return user;

    }

    @Override
    public User update(User user) {
        for (User currentUser : userList) {
            if (currentUser.getId() == user.getId()) {
                userList.remove(currentUser);
            }
        }

        userList.add(user);
        return user;
    }

    @Override
    public void deleteById(long id) {
      userList.remove(id);

    }

    @Override
    public User getById(long id) {
        return userList.get((int) id);
    }
}
