package Services;
import Entities.Role;
import Interfaces.IRoleServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleServices implements IRoleServices{
    public Connection conn;
    public RoleServices() {
        conn = ConnectionManager.getInstance().getConnection();
    }
    
    @Override
    public void create(Role role) {
        String sql = "INSERT into roles (id, name, canCreateCustomer, canViewCustomers, canDeleteCustomer,"
                + " canUpdateCustomer , canCreateItem, canViewItems, canDeleteItem, canUpdateItem, canViewUsers,"
                + "canCreateUser, canViewLogs, canCreateLog, canDeleteLog, canCreateRole, canDeleteRole, canUpdateRole, "
                + "canViewRoles, canDeleteUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {
                stmt.setString(1, role.id.toString());
                stmt.setString(2, role.name);
                stmt.setBoolean(3, role.canCreateCustomer);
                stmt.setBoolean(4, role.canViewCustomers);
                stmt.setBoolean(5, role.canDeleteCustomer);
                stmt.setBoolean(6, role.canUpdateCustomer);
                stmt.setBoolean(7, role.canCreateItem);
                stmt.setBoolean(8, role.canViewItems);
                stmt.setBoolean(9, role.canDeleteItem);
                stmt.setBoolean(10, role.canUpdateItem);
                stmt.setBoolean(11, role.canViewUsers);
                stmt.setBoolean(12, role.canCreateUser);
                stmt.setBoolean(13, role.canViewLogs);
                stmt.setBoolean(14, role.canCreateLog);
                stmt.setBoolean(15, role.canDeleteLog);
                stmt.setBoolean(16, role.canCreateRole);
                stmt.setBoolean(17, role.canDeleteRole);
                stmt.setBoolean(18, role.canUpdateRole);
                stmt.setBoolean(19, role.canViewRoles);
                stmt.setBoolean(20, role.canDeleteUser);
                
                int affected = stmt.executeUpdate();

                if (affected == 1) {
                    System.out.print("Donecreation!");
                } else {
                    System.err.println("Error!");
                }

        } catch (SQLException e) {
                System.err.println(e);
        } 
    }
    
    @Override
    public boolean update(UUID roleId, Role role) {
        String sql = "UPDATE roles SET name = ?, canCreateCustomer = ?, canViewCustomers = ?, canDeleteCustomer = ?,"
                + " canUpdateCustomer = ?, canCreateItem = ?, canViewItems = ?, canDeleteItem = ?, canUpdateItem = ?, canViewUsers = ?,"
                + "canCreateUser = ?, canViewLogs = ?, canCreateLog = ?, canDeleteLog = ?, canCreateRole = ?, canDeleteRole = ?, canUpdateRole = ?, "
                + "canViewRoles = ?, canDeleteUser = ? "
                + "WHERE id = ? ";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {
                stmt.setString(1, role.name);
                stmt.setBoolean(2, role.canCreateCustomer);
                stmt.setBoolean(3, role.canViewCustomers);
                stmt.setBoolean(4, role.canDeleteCustomer);
                stmt.setBoolean(5, role.canUpdateCustomer);
                stmt.setBoolean(6, role.canCreateItem);
                stmt.setBoolean(7, role.canViewItems);
                stmt.setBoolean(8, role.canDeleteItem);
                stmt.setBoolean(9, role.canUpdateItem);
                stmt.setBoolean(10, role.canViewUsers);
                stmt.setBoolean(11, role.canCreateUser);
                stmt.setBoolean(12, role.canViewLogs);
                stmt.setBoolean(13, role.canCreateLog);
                stmt.setBoolean(14, role.canDeleteLog);
                stmt.setBoolean(15, role.canCreateRole);
                stmt.setBoolean(16, role.canDeleteRole);
                stmt.setBoolean(17, role.canUpdateRole);
                stmt.setBoolean(18, role.canViewRoles);
                stmt.setBoolean(19, role.canDeleteUser);
                stmt.setString(20, roleId.toString());
                
                int affected = stmt.executeUpdate();

                if (affected == 1) {
                        return true;
                } else {
                        return false;
                }

        } catch (SQLException e) {
                System.err.println(e);
                return false;
        } 

    }

    @Override
    public Role getById(UUID id) {
        String sql ="SELECT * From roles WHERE id = ?";
        ResultSet rs = null;
         try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                String idd = id.toString();
                stmt.setString(1, idd);
                rs = stmt.executeQuery();
                if(rs.next())
                {
                    Role bean = new Role();
                    bean.id = UUID.fromString(rs.getString("id"));
                    bean.name = rs.getString("name");
                    bean.canCreateCustomer = rs.getBoolean("canCreateCustomer");
                    bean.canCreateItem = rs.getBoolean("canCreateItem");
                    bean.canCreateLog = rs.getBoolean("canCreateLog");
                    bean.canCreateRole = rs.getBoolean("canCreateRole");
                    bean.canCreateUser = rs.getBoolean("canCreateUser");
                    bean.canDeleteCustomer = rs.getBoolean("canDeleteCustomer");
                    bean.canDeleteItem = rs.getBoolean("canDeleteItem");
                    bean.canDeleteLog = rs.getBoolean("canDeleteLog");
                    bean.canDeleteUser = rs.getBoolean("canDeleteUser");
                    bean.canUpdateCustomer = rs.getBoolean("canUpdateCustomer");
                    bean.canUpdateItem = rs.getBoolean("canUpdateItem");
                    bean.canUpdateRole = rs.getBoolean("canUpdateRole");
                    bean.canViewCustomers = rs.getBoolean("canViewCustomers");
                    bean.canViewItems = rs.getBoolean("canViewItems");
                    bean.canViewLogs = rs.getBoolean("canViewLogs");
                    bean.canViewRoles = rs.getBoolean("canViewRoles");
                    bean.canViewUsers = rs.getBoolean("canViewUsers");
                    return bean;
                } else {
                    return null;
                }
         }   
            
         catch (SQLException e) {
                System.err.println(e);
                return null;
        }
        
     }

    @Override
    public ArrayList<String> getAll() {
        String sql = "SELECT name FROM roles";
            try (
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                ){
                    ArrayList roleNames = new ArrayList<Role>();
                    while (rs.next()) {
                        String roleName = rs.getString("name");
                        roleNames.add(roleName);
                    }
                    return roleNames;
            } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Role getByName(String name) {
        String sql = "SELECT * FROM roles WHERE";
        ResultSet rs = null;

        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, name);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    Role bean = new Role();
                    bean.id = UUID.fromString(rs.getString("id"));
                    bean.name = rs.getString("name");
                    bean.canCreateCustomer = rs.getBoolean("canCreateCustomer");
                    bean.canCreateItem = rs.getBoolean("canCreateItem");
                    bean.canCreateLog = rs.getBoolean("canCreateLog");
                    bean.canCreateRole = rs.getBoolean("canCreateRole");
                    bean.canCreateUser = rs.getBoolean("canCreateUser");
                    bean.canDeleteCustomer = rs.getBoolean("canDeleteCustomer");
                    bean.canDeleteItem = rs.getBoolean("canDeleteItem");
                    bean.canDeleteLog = rs.getBoolean("canDeleteLog");
                    bean.canDeleteUser = rs.getBoolean("canDeleteUser");
                    bean.canUpdateCustomer = rs.getBoolean("canUpdateCustomer");
                    bean.canUpdateItem = rs.getBoolean("canUpdateItem");
                    bean.canUpdateRole = rs.getBoolean("canUpdateRole");
                    bean.canViewCustomers = rs.getBoolean("canViewCustomers");
                    bean.canViewItems = rs.getBoolean("canViewItems");
                    bean.canViewLogs = rs.getBoolean("canViewLogs");
                    bean.canViewRoles = rs.getBoolean("canViewRoles");
                    bean.canViewUsers = rs.getBoolean("canViewUsers");
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
    public boolean deleteAll() {
        String sql = "DELETE FROM roles";
        try (
            Statement stmt = conn.createStatement();
            
            ){
             int affected= stmt.executeUpdate(sql);
             if(affected>0) return true;
             else return false;
            } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
