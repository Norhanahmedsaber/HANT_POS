package Services;
import Entities.Role;
import Interfaces.IRoleServices;
import java.util.ArrayList;
import java.util.UUID;

public class RoleServices implements IRoleServices{

    ArrayList<Role> roles = new ArrayList<Role>();
    public RoleServices() {
        Role role = new Role();
        role.name = "Manager";
        role.canCreateUser = true;
        roles.add(role);
    }
    @Override
    public void create(Role role) {
        roles.add(role);
    }
    
    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UUID roleId, Role role) {
        
    }

    @Override
    public void getById(UUID id) {
        
    }

    @Override
    public ArrayList<Role> getAll() {
        return roles;
    }

    @Override
    public Role getByName(String name) {
        Role role = new Role();
        role.canViewUsers = true;
        role.canCreateCustomer = true;
        role.canCreateItem = true;
        role.canCreateRole = true;
        role.canCreateUser = true;
        role.canDeleteCustomer = true;
        role.canDeleteItem = true;
        role.canDeleteLog = true;
        role.canDeleteUser = true;
        role.canUpdateCustomer = true;
        role.canUpdateItem = true;
        role.canUpdateRole = true;
        role.canViewCustomers = true;
        role.canViewItems = true;
        role.canViewLogs = true;
        role.canViewUsers = true;
        return role;
    }
    
}
