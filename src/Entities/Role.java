package Entities;
import java.util.UUID;

public class Role { 
    public UUID id;
    public String name;
    public boolean canCreateCustomer;
    public boolean canViewCustomers; 
    public boolean canDeleteCustomer;
    public boolean canUpdateCustomer;
    public boolean canCreateItem;
    public boolean canViewItems;
    public boolean canDeleteItem;
    public boolean canUpdateItem;
    public boolean canViewUsers;
    public boolean canCreateUser;
    public boolean canDeleteUser;
    public boolean canViewLogs;
    public boolean canCreateLog;
    public boolean canDeleteLog;
    public boolean canUpdateRole;
    public boolean canViewRoles;
    
    
    public boolean canDeleteRole;
    public boolean canCreateRole;
}
