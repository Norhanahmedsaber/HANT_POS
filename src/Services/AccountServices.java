package Services;
import Entities.User;
import Interfaces.IAccountServices;

public class AccountServices implements IAccountServices{
    
    public static String us ="s7s" ;
    
    public static String pass ="anas" ;
 
    
    
    @Override
    public User login(String username, String password) {
        //return us.equals(username) && pass.equals(password);
        
        return new User();
    }

    @Override
    public void signUp(User user) {
        System.out.println("User Signed Up");
        System.out.println(user.id + " " + user.name+ " " + user.userName+ " " + user.role);
    }
    
}
