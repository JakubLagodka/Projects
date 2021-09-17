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
        User toUpdate = getById(user.getId());
        toUpdate.setAge(user.getAge());
        toUpdate.setEmail(user.getEmail());
        toUpdate.setFirstName(user.getFirstName());
        toUpdate.setJob(user.getJob());
        toUpdate.setLastName(user.getLastName());
        toUpdate.setSalary(user.getSalary());

        return user;
    }

    @Override
    public void deleteById(Long id) {
        userList.remove(id);
//wrócić po interfejsach funkcyjnych
    }

    //interfejs comparable, metoda compareTo(), nie można wstawiać nulli
    //EnumMap jest najszybszą implementacją Mapy
    @Override
    public User getById(Long id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
            return user;
            }
        }
        throw new EntityNotFoundException("User not find with id: " + id);
    }
}
