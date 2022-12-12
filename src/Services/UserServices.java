package Services;
import Entities.Item;
import Entities.User;
import Interfaces.IUserServices;
import java.util.ArrayList;
import java.util.UUID;

public class UserServices implements IUserServices{
    public static ArrayList<User> users = new ArrayList<User>();

    public UserServices() {
        _RoleServices = new RoleServices(); 
        User user = new User();
        user.id = UUID.randomUUID();
        user.name = "anas hesham";
        user.userName = "anas";
        user.password = "123";
        user.role = _RoleServices.getByName("Admin");
        users.add(user);
    }
    
    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public void delete(UUID userId) {
        users.remove(getById(userId));
    }

    @Override
    public User getById(UUID userId) {
        
        for(int i=0;i<users.size();i++) {
            if(users.get(i).id == userId) {
                return users.get(i);
            }
        }
        return null; 
    }

    @Override
    public void update(UUID userId, User user) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).id == userId) {
                users.get(i).name = user.name;
                users.get(i).userName = user.userName;
                users.get(i).password = user.password;
                users.get(i).role = user.role;
            }
        }
    }
    
    @Override
    public ArrayList<User> getAll() { 
        return users; 
    } 
    private RoleServices _RoleServices;
    
}
