package Services;
import Entities.Role;
import Interfaces.IRoleServices;
import java.util.ArrayList;
import java.util.UUID;

public class RoleServices implements IRoleServices{

    ArrayList<Role> roles = new ArrayList<Role>();
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
    
}
