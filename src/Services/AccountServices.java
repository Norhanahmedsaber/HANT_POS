package Services;
import Entities.User;
import Interfaces.IAccountServices;

public class AccountServices implements IAccountServices{
    
    public static String us ="norhan" ;
    
    public static String pass ="123" ;
    
    
    @Override
    public boolean login(String username, String password) {
        return us.equals(username) && pass.equals(password);
    }

    @Override
    public void signUp(User user) {

        System.out.println("User Signed Up");
        
        System.out.println(user.name+ " " + user.userName+ " " + user.role);

    }
    
}
