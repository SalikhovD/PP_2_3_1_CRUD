package main.hiber.service;

import main.hiber.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void deleteUser(Long id);

    void saveOrUpdate(User user);

    List<User> listUsers();
    User getUser(Long id);
}
