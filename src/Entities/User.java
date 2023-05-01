package Entities;

import java.util.UUID;

public class User {
    public UUID id;
    public String name;
    public String userName;
    public String password;// hash
    public Role role;
    @Override
    public String toString() {
        return name + userName + role.name;
    }
}
