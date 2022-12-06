package Interfaces;

import Entities.User;

public interface IAccountServices {
    boolean login(String username, String password);
    void signUp(User user);
}
