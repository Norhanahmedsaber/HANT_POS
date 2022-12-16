package Services;
import Entities.Item;
import Interfaces.IItemServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class ItemServices implements IItemServices {
    private static Connection conn;

    public ItemServices() {
        conn = ConnectionManager.getInstance().getConnection();
    }
    
    @Override
    public void create(Item item) {
        String sql = "INSERT into items (id, name, description, price, category, createdAt) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {

                stmt.setString(1, item.id.toString());
                stmt.setString(2, item.name);
                stmt.setString(3, item.description);
                stmt.setInt(4, item.price);
                stmt.setString(5, item.category);
                stmt.setDate(6, new java.sql.Date(item.createdAt.getTime()));
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
    public boolean delete(UUID itemId) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, itemId.toString());
            deleteItemFromCustomers(itemId);
            int affected = stmt.executeUpdate();
            return affected == 1;
        }
        catch(SQLException e) {
                System.err.println(e);
                return false;
        }
    }

    @Override
    public Item getById(UUID itemId) {
        String sql = "SELECT * FROM items WHERE id = ?";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, itemId.toString());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Item item = new Item();
                item.id = UUID.fromString(rs.getString("id"));
                item.name = rs.getString("name");
                item.category = rs.getString("category");
                item.description = rs.getString("description");
                item.price = rs.getInt("price");
                item.createdAt = rs.getDate("createdAt");
                return item;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
        return null;
    }

    @Override
    public boolean update(UUID itemId, Item item) {
        String sql = "UPDATE items SET " +
                     "name = ?, description = ?, category = ?, price = ? " +
                     "WHERE id = ?";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
                stmt.setString(1, item.name);
                stmt.setString(2, item.description);
                stmt.setString(3, item.category);
                stmt.setInt(4, item.price);
                stmt.setString(5, itemId.toString());
                int affected = stmt.executeUpdate();
                return affected == 1;
        }
        catch(SQLException e) {
                System.err.println(e);
                return false;
        }
    }

    @Override
    public ArrayList<Item> getAllItems() {
        String sql = "SELECT id, name, description, category, price, createdAt FROM items";
        ArrayList<Item> items = new ArrayList<>();
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ){
                while (rs.next()) {
                       Item item = new Item();
                       item.id = UUID.fromString(rs.getString("id"));
                       item.name = rs.getString("name");
                       item.price = rs.getInt("price");
                       item.description = rs.getString("description");
                       item.category = rs.getString("category");
                       item.createdAt = rs.getDate("createdAt");
                       items.add(item);
                }
                return items;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return items;
    }

    @Override
    public void addItemsToCustomer(UUID customerId , ArrayList<UUID> itemsIds) {
        
        System.out.println("Added Succesfully");
    }
    @Override
    public void deleteItemFromCustomers(UUID itemId) {
        String sql = "DELETE FROM customeritem WHERE itemId = ?";
        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, itemId.toString());
            stmt.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println(e);
        }
    }
    
}
