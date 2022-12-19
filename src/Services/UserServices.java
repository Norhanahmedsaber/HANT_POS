package Services;
import Entities.User;
import Interfaces.IUserServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class UserServices implements IUserServices{
    public Connection conn;
    private final RoleServices _RoleServices;
    public UserServices() {
        conn = ConnectionManager.getInstance().getConnection();
        _RoleServices = new RoleServices();
    }
     
    @Override
    public void create(User user) {
        String sql = "INSERT into users (id, name, userName, password, roleName) " +
                        "VALUES (?, ?, ?, ?, ?)";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {

                stmt.setString(1, user.id.toString());
                stmt.setString(2, user.name);
                stmt.setString(3, user.userName);
                stmt.setString(4, user.password);
                stmt.setString(5, user.role.name);
                int affected = stmt.executeUpdate();

                if (affected == 1) {
                        System.out.print("Done!");
                } else {
                        System.err.println("Error!");
                }

        } catch (SQLException e) {
                System.err.println(e);
        } 
    }

    @Override
    public boolean delete(UUID userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, userId.toString());
            int affected = stmt.executeUpdate();
            return affected == 1;
        }
        catch(SQLException e) {
                System.err.println(e);
                return false;
        }
}

    @Override
    public User getById(UUID userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        ResultSet rs;
        
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, userId.toString());
                rs = stmt.executeQuery();

                if (rs.next()) {
                    User bean = new User();
                    bean.id = userId;
                    bean.name = rs.getString("name");
                    bean.userName = rs.getString("userName");
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
    public boolean update(UUID userId, User user) {
        String sql = "UPDATE users SET " +
                     "name = ?, userName = ?, password = ?, roleName = ? " +
                     "WHERE id = ?";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, user.name);
                stmt.setString(2, user.userName);
                stmt.setString(3, user.password);
                stmt.setString(4, user.role.name);
                stmt.setString(5, userId.toString());
                int affected = stmt.executeUpdate();
                return affected == 1;

        }
        catch(SQLException e) {
                System.err.println(e);
                return false;
        }
    }
    
    @Override
    public ArrayList<User> getAll() {
        String sql = "SELECT id, name, userName, roleName FROM users";
        ArrayList<User> users = new ArrayList<>();
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ){
                while (rs.next()) {
                       User user = new User();
                       user.id = UUID.fromString(rs.getString("id"));
                       user.name = rs.getString("name");
                       user.userName = rs.getString("userName");
                       user.role = _RoleServices.getByName(rs.getString("roleName"));
                       users.add(user);
                }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return users;
    } 
    
}
