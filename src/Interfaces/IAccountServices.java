package Interfaces;

import Entities.User;

public interface IAccountServices {
    User login(String username, String password);
    void signUp(User user);
}
