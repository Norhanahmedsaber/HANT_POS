package Interfaces;

import Entities.Role;
import java.util.ArrayList;
import java.util.UUID;

public interface IRoleServices {
    Role getById(UUID id);
    void create(Role role);
    boolean update(UUID id, Role role);
    ArrayList<String> getAll(); 
    Role getByName(String name);
    boolean deleteAll();
} 
