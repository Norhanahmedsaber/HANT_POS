package Entities;

import java.util.Date;
import java.util.UUID;

public class Log {
    public UUID id = UUID.randomUUID();
    public String userName;
    public String userRole;
    public String action;
    public String actedOn;
    public String actedOnName;
    public Date date; 
}
