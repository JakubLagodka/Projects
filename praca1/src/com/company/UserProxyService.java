package com.company;

import java.util.HashMap;
import java.util.Map;

public class UserProxyService implements UserService {
    private UserServiceImpl userService;
    private Map<Long, User> map;

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
    public void deleteById(long id) {
        userService.deleteById(id);
        map.remove(id);
    }

    @Override
    public User getById(long id) {
        if (map.containsKey(id)) {
            return map.get(id);
        } else {
            return map.put(id, userService.getById(id));
        }
    }
}
