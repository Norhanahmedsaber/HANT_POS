 package Services;
import Entities.User;
import Interfaces.IAccountServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
public class AccountServices implements IAccountServices{
    
    private static Connection conn;
    public AccountServices() {
        conn = ConnectionManager.getInstance().getConnection();
        _RoleServices = new RoleServices();
        _UserServices = new UserServices();
    }
    @Override
     
    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE userName = ? AND password = ?";
        ResultSet rs = null;
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, username);
                stmt.setString(2, password);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    User bean = new User();
                    bean.id = UUID.fromString(rs.getString("id"));
                    bean.name = rs.getString("name");
                    bean.userName = rs.getString("userName");
                    bean.password = rs.getString("password");
                    bean.role = _RoleServices.getByName(rs.getString("roleName"));
                    return bean;
                } else {
                    return null;
                }

        } catch (SQLException e) {
                System.err.println(e);
                return null;
        }
    } 


    
    @Override
    public void signUp(User user) {
        _UserServices.create(user);
    }
    private final RoleServices _RoleServices;
    private final UserServices _UserServices;
}
