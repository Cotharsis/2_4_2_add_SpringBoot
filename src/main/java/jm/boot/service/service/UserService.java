package jm.boot.service.service;//package jm.boot.example.service;



import jm.boot.model.User;

import java.util.List;

public interface UserService {

        List<User> allUsers();
        void add(User user);
        void delete(User user);
        void edit(User user);
        User getById(int id);

    }

