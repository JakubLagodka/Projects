package com.company;

import java.util.HashMap;
import java.util.Map;

public class UserProxyService implements UserService {
    private final UserService userService;
    private final Map<Long, User> map;

    public UserProxyService() {
        this.userService = new UserServiceImpl();
        this.map = new HashMap<>();
    }

    @Override
    public User save(User user) {

        return map.put(user.getId(), userService.save(user));
    }

    @Override
    public User update(User user) {
        return map.put(user.getId(), userService.update(user));

    }

    @Override
    public void deleteById(Long id) {
        userService.deleteById(id);
        map.remove(id);
    }

    @Override
    public User getById(Long id) {

        User user = map.get(id);
        if (user == null) {
            return map.put(id, userService.getById(id));
        } else return user;

    }
}

