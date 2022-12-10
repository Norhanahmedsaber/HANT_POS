package Services;
import Entities.User;
import Interfaces.IAccountServices;

public class AccountServices implements IAccountServices{
    
    public User user = new User();

    @Override
    public User login(String username, String password) {
        //return us.equals(username) && pass.equals(password);
        user.name = username;
        return user;
    }

    @Override
    public void signUp(User user) {
        System.out.println("User Signed Up");
        System.out.println(user.id + " " + user.name+ " " + user.userName+ " " + user.role);
    }
    
}
