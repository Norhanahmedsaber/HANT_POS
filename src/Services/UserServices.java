package Services;
import Entities.Item;
import Entities.User;
import Entities.UserInfo;
import Interfaces.IUserServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class UserServices implements IUserServices{
    public Connection conn;
    private final RoleServices _RoleServices;
    private final CustomerServices _CustomerServices;
    public UserServices() {
        conn = ConnectionManager.getInstance().getConnection();
        _RoleServices = new RoleServices();
        _CustomerServices = new CustomerServices();
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

    @Override
    public ArrayList<UserInfo> getUsersInfo() {
        String sql = "Select userName FROM users";
        ArrayList<String> usernames = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next() && usernames.size() != 5) {
                usernames.add(rs.getString("username"));
            }
            ArrayList<UserInfo> users = new ArrayList<>();
            for(String name : usernames) {
                UserInfo user = new UserInfo();
                user.username = name;
                user.dealsDoneThisMonth = 0;
                user.dealsDoneThisWeek = 0;
                user.dealsDoneThisYear = 0;
                user.dealsDoneToday = 0;
                user.itemsSoldThisMonth = 0;
                user.itemsSoldThisWeek = 0;
                user.itemsSoldThisYear = 0;
                user.itemsSoldToday = 0;
                user.itemsImportedThisMonth = 0;
                user.itemsImportedThisWeek = 0;
                user.itemsImportedThisYear = 0;
                user.itemsImportedToday = 0;
                users.add(user);
            }
            sql = "SELECT userName, actedOnName, date FROM logs WHERE action = 'Created' AND actedOn = 'Customer' ";
            try {
                Statement stmt2 = conn.createStatement();
                rs = stmt2.executeQuery(sql);
                while(rs.next()) {
                    if(isDateToday(rs.getDate("date"))){
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.dealsDoneThisMonth++;
                                user.dealsDoneThisWeek++;
                                user.dealsDoneThisYear++;
                                user.dealsDoneToday++;
                            }
                        }
                    }else if(isDateInCurrentWeek(rs.getDate("date"))) {
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.dealsDoneThisMonth++;
                                user.dealsDoneThisWeek++;
                                user.dealsDoneThisYear++;
                            }
                        }
                    }else if (isDateInCurrentMonth(rs.getDate("date")))
                    {
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.dealsDoneThisMonth++;
                                user.dealsDoneThisYear++;
                            }
                        }
                    }else if(isDateInCurrentYear(rs.getDate("date")))
                    {
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.dealsDoneThisYear++;
                            }
                        }
                    }
                    sql = "SELECT id FROM customers WHERE name = ? ";
                    try {
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, rs.getString("actedOnName"));
                        ResultSet r = ps.executeQuery();
                        if(r.next()) {
                            ArrayList<Item> items = _CustomerServices.getAssignedItems(UUID.fromString(r.getString("id")));
                            if(isDateToday(rs.getDate("date"))){
                                for(UserInfo user : users) {
                                    if(rs.getString("userName").equals(user.username)) {
                                        for(Item item : items) {
                                            user.itemsSoldThisMonth++;
                                            user.itemsSoldThisWeek++;
                                            user.itemsSoldThisYear++;
                                            user.itemsSoldToday++;
                                            user.profitToday += item.price;
                                            user.profitThisWeek += item.price;
                                            user.profitThisMonth += item.price;
                                            user.profitThisYear += item.price;
                                        }

                                    }
                                }
                            }else if(isDateInCurrentWeek(rs.getDate("date"))) {
                                for(UserInfo user : users) {
                                    if(rs.getString("userName").equals(user.username)) {
                                        for(Item item : items) {
                                            user.itemsSoldThisMonth++;
                                            user.itemsSoldThisWeek++;
                                            user.itemsSoldThisYear++;
                                            user.profitThisWeek += item.price;
                                            user.profitThisMonth += item.price;
                                            user.profitThisYear += item.price;
                                        }

                                    }
                                }
                            }else if (isDateInCurrentMonth(rs.getDate("date")))
                            {
                                for(UserInfo user : users) {
                                    if(rs.getString("userName").equals(user.username)) {
                                        for(Item item : items) {
                                            user.itemsSoldThisMonth++;
                                            user.itemsSoldThisYear++;
                                            user.profitThisMonth += item.price;
                                            user.profitThisYear += item.price;
                                        }

                                    }
                                }
                            }else if(isDateInCurrentYear(rs.getDate("date")))
                            {
                                for(UserInfo user : users) {
                                    if(rs.getString("userName").equals(user.username)) {
                                        for(Item item : items) {
                                            user.itemsSoldThisYear++;
                                            user.profitThisYear += item.price;
                                        }

                                    }
                                }
                            }
                        }
                    }catch (SQLException exp) {
                        System.out.println(exp);
                        return null;
                    }
                }
            }catch(SQLException e) {
                System.out.println(e);
                return null;
            }
            sql = "SELECT userName, date FROM logs WHERE action = 'Created' AND actedOn = 'Item' ";
            try {
                Statement stmt2 = conn.createStatement();
                rs = stmt2.executeQuery(sql);
                while(rs.next()) {
                    if(isDateToday(rs.getDate("date"))){
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.itemsImportedThisMonth++;
                                user.itemsImportedThisWeek++;
                                user.itemsImportedThisYear++;
                                user.itemsImportedToday++;
                            }
                        }
                    }else if(isDateInCurrentWeek(rs.getDate("date"))) {
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.itemsImportedThisMonth++;
                                user.itemsImportedThisWeek++;
                                user.itemsImportedThisYear++;
                            }
                        }
                    }else if (isDateInCurrentMonth(rs.getDate("date")))
                    {
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.itemsImportedThisMonth++;
                                user.itemsImportedThisYear++;
                            }
                        }
                    }else if(isDateInCurrentYear(rs.getDate("date")))
                    {
                        for(UserInfo user : users) {
                            if(rs.getString("userName").equals(user.username)) {
                                user.itemsImportedThisYear++;
                            }
                        }
                    }
                }
            }catch(SQLException e) {
                System.out.println(e);
                return null;
            }
            return users;
        }catch(SQLException ex) {
            System.out.println(ex);
            return null;
        }
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
    
}
