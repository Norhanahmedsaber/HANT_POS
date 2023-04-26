package Services;
import Entities.CategoryInfo;
import Entities.Customer;
import Entities.Item;
import Interfaces.IItemServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.DataFormat;

public class ItemServices implements IItemServices {
    private static Connection conn;
    private CustomerServices _CustomerServices;
    public ItemServices() {
        conn = ConnectionManager.getInstance().getConnection();
        _CustomerServices = new CustomerServices();
    }
     
    @Override
    public boolean create(Item item) {
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
                return true;
                
        } catch (SQLException e) {
                System.err.println(e);
                return false;
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

    @Override
    public ArrayList<CategoryInfo> getCatsInfo() {
        ArrayList<String> names = new ArrayList<>();
        String sql = "SELECT category FROM items";
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
            ){
                while (rs.next() && names.size() < 6) {
                    String name = rs.getString("category");
                    if(!names.contains(name)) {
                        names.add(name);
                    }
                }
        } catch (SQLException ex) {
            return null;
        }
        ArrayList<CategoryInfo> cats = new ArrayList<>();
        for(String name : names) {
            CategoryInfo bean = new CategoryInfo();
            bean.name = name;
            bean.NumberOfItemsThisMonth = 0;
            bean.NumberOfItemsThisWeek = 0;
            bean.NumberOfItemsThisYear = 0;
            bean.NumberOfItemsToday = 0;
            bean.incomeThisMonth = 0;
            bean.incomeThisWeek = 0;
            bean.incomeThisYear = 0;
            bean.incomeToday = 0;
            cats.add(bean);
        }
        sql = "SELECT id, purchaseDate FROM customers";
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
            ){
                while (rs.next()) {
                    Customer bean = new Customer();
                    bean.id = UUID.fromString(rs.getString("id"));
                    bean.purchaseDate = rs.getDate("purchaseDate");
                    ArrayList<Item> assignedItems = _CustomerServices.getAssignedItems(bean.id);
                    if(isDateToday(bean.purchaseDate)) {
                        for(Item item : assignedItems) {
                            for(CategoryInfo cat : cats) {
                                if (item.category.equals(cat.name)) {
                                    cat.NumberOfItemsToday++;
                                    cat.NumberOfItemsThisMonth++;
                                    cat.NumberOfItemsThisWeek++;
                                    cat.NumberOfItemsThisYear++;
                                    cat.incomeThisMonth += item.price;
                                    cat.incomeThisWeek += item.price;
                                    cat.incomeThisYear += item.price;
                                    cat.incomeToday += item.price;
                                }
                            }
                        }
                    }else if(isDateInCurrentWeek(bean.purchaseDate)) {
                        for(Item item : assignedItems) {
                            for(CategoryInfo cat : cats) {
                                if (item.category.equals(cat.name)) {
                                    cat.NumberOfItemsThisMonth++;
                                    cat.NumberOfItemsThisWeek++;
                                    cat.NumberOfItemsThisYear++;
                                    cat.incomeThisMonth += item.price;
                                    cat.incomeThisWeek += item.price;
                                    cat.incomeThisYear += item.price;
                                }
                            }
                        }
                    }else if(isDateInCurrentMonth(bean.purchaseDate)) {
                        for(Item item : assignedItems) {
                            for(CategoryInfo cat : cats) {
                                if (item.category.equals(cat.name)) {
                                    cat.NumberOfItemsThisMonth++;
                                    cat.NumberOfItemsThisYear++;
                                    cat.incomeThisMonth += item.price;
                                    cat.incomeThisYear += item.price;
                                }
                            }
                        }
                    }else if(isDateInCurrentYear(bean.purchaseDate)) {
                        for(Item item : assignedItems) {
                            for(CategoryInfo cat : cats) {
                                if (item.category.equals(cat.name)) {
                                    cat.NumberOfItemsThisYear++;
                                    cat.incomeThisYear += item.price;
                                }
                            }
                        }
                    }
                    
                }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
        return cats;
    }
    private static boolean isDateToday(Date date) {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus1Day = currentDate.minusDays(1);
        LocalDate ldate = Instant.ofEpochMilli(date.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
        return !ldate.isBefore(currentDateMinus1Day);
    }
    private static boolean isDateInCurrentWeek(Date date) {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus1Week = currentDate.minusWeeks(1);
        LocalDate ldate = Instant.ofEpochMilli(date.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
        return !ldate.isBefore(currentDateMinus1Week);
    }
    private static boolean isDateInCurrentMonth(Date date) {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus1Months = currentDate.minusMonths(1);
        LocalDate ldate = Instant.ofEpochMilli(date.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
        return !ldate.isBefore(currentDateMinus1Months);
    }
    private static boolean isDateInCurrentYear(Date date) {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus1Year = currentDate.minusYears(1);
        LocalDate ldate = Instant.ofEpochMilli(date.getTime())
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
        return !ldate.isBefore(currentDateMinus1Year);
    }
    public boolean deleteAll() {      
        String sql = "DELETE FROM items";
        try (          
                Statement stmt = conn.createStatement();
                        ){
            int affected = stmt.executeUpdate(sql); 
            if(affected > 0) return true;
            else return false;          
        } catch (SQLException ex) {
                Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);        }
        return false;       
    }
   
}
