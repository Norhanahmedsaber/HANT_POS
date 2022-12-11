package Services;
import Entities.Role;
import Entities.User;
import Interfaces.IAccountServices;
import static Services.UserServices.users;

public class AccountServices implements IAccountServices{
    
    public static String us ="s7s" ;
    
    public static String pass ="anas" ;
 
    
    
    @Override
    public User login(String username, String password) {
        User user = new User();
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
        user.role = role;
        return user;
    } 

    
    @Override
    public void signUp(User user) {
        users.add(user);
        System.out.println("User Signed Up");
        System.out.println(user.id + " " + user.name+ " " + user.userName+ " " + user.role);
    }
    
}
