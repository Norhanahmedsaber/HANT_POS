package Services;
import Entities.Role;
import Entities.User;
import Interfaces.IAccountServices;
import static Services.UserServices.users;

public class AccountServices implements IAccountServices{
    @Override 
    public User login(String username, String password) {
        for(int i=0;i<UserServices.users.size();i++) {
            if(users.get(i).userName.equals(username) && users.get(i).password.equals(password)) {
                return users.get(i);
            }
        }
        return null;
    } 


    
    @Override
    public void signUp(User user) {
        users.add(user);
    }
    
}
