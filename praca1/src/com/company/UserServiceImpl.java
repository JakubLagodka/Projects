package com.company;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final List<User> userList;

    public UserServiceImpl(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public User save(User user) {
        if (userList.add(user))
            return user;
        else
            return null;

    }

    @Override
    public User update(User user) {
        for (User currentUser : userList) {
            if (currentUser.getId() == user.getId()) {
                userList.remove(currentUser);
            }
        }
        if (userList.add(user))
            return user;
        else
            return null;
    }

    @Override
    public void deleteById(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                userList.remove(user);
            }
        }
    }

    @Override
    public User getById(long id) {
        return userList.get((int) id);
    }
}
