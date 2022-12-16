package Interfaces;

import Entities.User;
import java.util.ArrayList;
import java.util.UUID;
 
public interface IUserServices {
    void create(User user);
    boolean delete(UUID userId);
    User getById(UUID userId);
    // UUID to be figured
    boolean update(UUID userId, User user);
    ArrayList<User> getAll();
}
