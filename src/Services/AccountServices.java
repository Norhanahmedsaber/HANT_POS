package Services;
import Entities.User;
import Interfaces.IAccountServices;

public class AccountServices implements IAccountServices{

    @Override
    public User login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void signUp(User user) {
        System.out.println("User Signed Up");
        
        System.out.println(user.name+ " " + user.userName+ " " + user.role);
    }
    
}
