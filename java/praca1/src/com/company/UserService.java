package com.company;

public interface UserService {
    User save(User user);

    User update(User user);

    void deleteById(Long id);

    User getById(Long id);
}
