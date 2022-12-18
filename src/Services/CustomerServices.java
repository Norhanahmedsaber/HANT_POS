package Services; 
import Entities.Customer; 
import Entities.Item;
import Interfaces.ICustomerServices; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.util.UUID; 
 
public class CustomerServices implements ICustomerServices  { 
    public Connection conn;

    public CustomerServices() {
        conn = ConnectionManager.getInstance().getConnection();
    }
    
    @Override 
    public void create(Customer customer, ArrayList<UUID> itemsIds) { 
        String sql = "INSERT into customers (id, name, nationalId, phoneNumber, "
                + " city, purchaseDate, email, income, job, gender, age) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? )";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {

                stmt.setString(1, customer.id.toString());
                stmt.setString(2, customer.name);
                stmt.setString(3, customer.nationalId);
                stmt.setString(4, customer.phoneNumber);
                stmt.setString(5, customer.city);
                stmt.setDate(6, new java.sql.Date(customer.purchaseDate.getTime()));
                stmt.setString(7, customer.email);
                stmt.setInt(8, customer.income);
                stmt.setString(9, customer.job);
                stmt.setString(10, customer.gender);
                stmt.setInt(11, customer.age);
                int affected = stmt.executeUpdate();
                if (affected == 1) {
                        System.out.print("Done!");
                        assignItemsToCustomer(customer.id, itemsIds);
                } else {
                        System.err.println("Error!");
                }

        } catch (SQLException e) {
                System.err.println(e);
        }
    } 
 
    @Override 
    public boolean delete(UUID customerId) { 
        String sql = "DELETE FROM customers WHERE id = ?";
        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, customerId.toString());
            boolean done = deleteAssignedItems(customerId);
            if(done) {
                int affected = stmt.executeUpdate();
                return affected == 1;
            }else {
                return false;
            }
        }
        catch(SQLException e) {
                System.err.println(e);
                return false;
        }
    } 
 
    @Override 
    public Customer getById(UUID customerId) { 
        String sql = "SELECT * FROM customers WHERE id = ?";
        ResultSet rs;
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, customerId.toString());
                rs = stmt.executeQuery();

                if (rs.next()) {
                    Customer bean = new Customer();
                    bean.id = customerId;
                    bean.name = rs.getString("name");
                    bean.nationalId = rs.getString("nationalId");
                    bean.phoneNumber = rs.getString("phoneNumber");
                    bean.city = rs.getString("city");
                    bean.purchaseDate = rs.getDate("purchaseDate");
                    bean.email = rs.getString("email");
                    bean.income = rs.getInt("income");
                    bean.job = rs.getString("job");
                    bean.gender = rs.getString("gender");
                    bean.age = rs.getInt("age");
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
    public boolean update(UUID customerId, Customer customer) { 
        String sql = "UPDATE customers SET " +
                     "name = ?, nationalId = ?, phoneNumber = ?, " +
                     "city = ?, purchaseDate = ?, email = ?, income = ?, job = ?, gender = ?, age = ? " + 
                     "WHERE id = ?";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {
                stmt.setString(1, customer.name);
                stmt.setString(2, customer.nationalId);
                stmt.setString(3, customer.phoneNumber);
                stmt.setString(4, customer.city);
                stmt.setDate(5, new java.sql.Date(customer.purchaseDate.getTime()));
                stmt.setString(6, customer.email);
                stmt.setInt(7, customer.income);
                stmt.setString(8, customer.job);
                stmt.setString(9, customer.gender);
                stmt.setInt(10, customer.age);
                stmt.setString(11, customer.id.toString());
                int affected = stmt.executeUpdate();
                return affected == 1;

        } catch (SQLException e) {
                System.err.println(e);
                return false;
        }
    } 
 
    @Override 
    public ArrayList<Customer> getAll() { 
        String sql = "SELECT * FROM customers";
        ArrayList<Customer> customers = new ArrayList<>();
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ){
                while (rs.next()) {
                    Customer bean = new Customer();
                    bean.id = UUID.fromString(rs.getString("id"));
                    bean.name = rs.getString("name");
                    bean.nationalId = rs.getString("nationalId");
                    bean.phoneNumber = rs.getString("phoneNumber");
                    bean.city = rs.getString("city");
                    bean.purchaseDate = rs.getDate("purchaseDate");
                    bean.email = rs.getString("email");
                    bean.income = rs.getInt("income");
                    bean.job = rs.getString("job");
                    bean.gender = rs.getString("gender");
                    bean.age = rs.getInt("age");
                    customers.add(bean);
                }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return customers;
    } 

    @Override
    public ArrayList<Item> getAssignedItems(UUID customerId) {
        String sql = "SELECT * FROM customeritem "
                + "WHERE customerId = ?";
        ArrayList<Item> items = new ArrayList<>();
        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, customerId.toString());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    sql = "SELECT * FROM items WHERE id = ?";
                    try (
                            PreparedStatement stmt2 = conn.prepareStatement(sql);
                        ) {
                            stmt2.setString(1, rs.getString("itemId"));
                            ResultSet rs2 = stmt2.executeQuery();
                            if(rs2.next()) {
                                Item item = new Item();
                                item.id = UUID.fromString(rs2.getString("id"));
                                item.name = rs2.getString("name");
                                item.price = rs2.getInt("price");
                                item.description = rs2.getString("description");
                                item.category = rs2.getString("category");
                                item.createdAt = rs2.getDate("createdAt");
                                items.add(item);
                            }
                    }
                }
                return items;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return items;
    }
    
    @Override
    public void assignItemsToCustomer(UUID customerId, ArrayList<UUID> itemsIds) {
        for(UUID itemId : itemsIds) {
            String sql = "INSERT into customeritem (customerId, itemId) " +
                            "VALUES (?, ?)";
            try (
                    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ) {
                    stmt.setString(1, customerId.toString());
                    stmt.setString(2, itemId.toString());
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
    }
    
    @Override
    public void updateAssignedItemsToCustomer(UUID customerId, ArrayList<UUID> itemsIds){
        deleteAssignedItems(customerId);
        assignItemsToCustomer(customerId, itemsIds);
    }
    
    @Override
    public boolean deleteAssignedItems(UUID customerId) {
        String sql = "DELETE FROM customeritem WHERE customerId = ?";
        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, customerId.toString());
            stmt.executeUpdate();
            return true;
        }
        catch(SQLException e) {
            System.err.println(e);
            return false;
        }
    }
     
}