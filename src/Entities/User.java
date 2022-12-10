package Entities;

import java.util.UUID;

public class User {
    public UUID id = UUID.randomUUID();
    public String name;
    public String userName;
    public String password;// hash
    public String role;
}
