package jm.boot.dao;


import jm.boot.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    User getById(int id);
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);

}
