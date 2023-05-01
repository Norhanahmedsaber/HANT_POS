package Entities;

import java.util.Date;
import java.util.UUID;

public class Log {
    public UUID id = UUID.randomUUID();
    public String userName;
    public String userRole;
    public String action; // Update, Create, Edit, Delete
    public String actedOn; // Customer, Item, User
    public String actedOnName;
    public Date date; 

    @Override
    public String toString() {
        return this.userName+this.userRole+this.action+this.actedOn+this.actedOnName;


    }
}
