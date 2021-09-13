package com.company;

public interface UserService {
    User save(User user);

    User update(User user);

    void deleteById(long id);

    User getById(long id);
}
