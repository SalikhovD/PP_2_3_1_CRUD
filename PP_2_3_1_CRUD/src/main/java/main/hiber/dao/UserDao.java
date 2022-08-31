package main.hiber.dao;

import main.hiber.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void deleteUser(Long id);
    void saveOrUpdate(User user);

    List<User> listUsers();
    User getUser(Long id);

    void dropTable(String tableName);

}
