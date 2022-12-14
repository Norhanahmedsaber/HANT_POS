package Services;
import Entities.Role;
import Interfaces.IRoleServices;
import java.util.ArrayList;
import java.util.UUID;

public class RoleServices implements IRoleServices{

    public static ArrayList<Role> roles = new ArrayList<Role>();
    public RoleServices() {
        if(roles.isEmpty()) { 
            Role role = new Role() {{
            name = "Admin";
            canViewUsers = true;
            canCreateCustomer = true;
            canCreateItem = true;
            canCreateRole = true;
            canCreateUser = true;
            canDeleteCustomer = true;
            canDeleteItem = true;
            canDeleteLog = true;
            canDeleteUser = true;
            canUpdateCustomer = true;
            canUpdateItem = true;
            canUpdateRole = true;
            canViewCustomers = true;
            canViewItems = true;
            canViewLogs = true;
            canViewUsers = true;
            canViewRoles = true;
            }};
            roles.add(role);
        }
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
        for(Role rolee : roles) {
            if(rolee.id == roleId) {
            }
        }
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
        for(int i=0;i<roles.size();i++) {
            if(roles.get(i).name.equals(name)) {
                return roles.get(i);
            }
        }
        return null;
    }
    
}
