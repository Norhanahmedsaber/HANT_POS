package Interfaces;

import Entities.Role;
import java.util.ArrayList;
import java.util.UUID;

public interface IRoleServices {
    void getById(UUID id);
    void create(Role role);
    void delete(UUID id);
    void update(UUID id, Role role);
    ArrayList<Role> getAll(); 
    Role getByName(String name);
}
