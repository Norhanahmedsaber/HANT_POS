package Services;
import Entities.Log;
import Interfaces.ILogServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogServices implements ILogServices{
    private final Connection conn;

    public LogServices() {
        conn = ConnectionManager.getInstance().getConnection();
    }
    
    
    
    @Override
    public boolean deleteLog(UUID logId) {
        String sql = "DELETE FROM logs WHERE id = ? ";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ) {
                stmt.setString(1, logId.toString());
                int affected = stmt.executeUpdate();
                return affected == 1;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public Log getById(UUID logId) {
        String sql = "SELECT * FROM logs WHERE id = ?";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql);
            ){
            stmt.setString(1, logId.toString());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Log log = new Log();
                log.id = logId;
                log.actedOn = rs.getString("actedOn");
                log.actedOnName = rs.getString("actedOnName");
                log.action = rs.getString("action");
                log.userName = rs.getString("userName");
                log.userRole = rs.getString("userRole");
                log.date = rs.getDate("date");
                return log;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    @Override
    public void create(Log log) {
        String sql = "INSERT into logs (id, actedOn, actedOnName, action, userName, userRole, date) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {

                stmt.setString(1, log.id.toString());
                stmt.setString(2, log.actedOn);
                stmt.setString(3, log.actedOnName);
                stmt.setString(4, log.action);
                stmt.setString(5, log.userName);
                stmt.setString(6, log.userRole);
                stmt.setDate(7, new java.sql.Date(log.date.getTime()));
                stmt.executeUpdate();
            
        } catch (SQLException e) {
                System.err.println(e);
        }
    }
    
    @Override
    public ArrayList<Log> getAll() { 
        String sql = "SELECT * FROM logs";
        ArrayList<Log> logs = new ArrayList<>();
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ){
                while (rs.next()) {
                    Log log = new Log();
                    log.id = UUID.fromString(rs.getString("id"));
                    log.actedOn = rs.getString("actedOn");
                    log.actedOnName = rs.getString("actedOnName");
                    log.action = rs.getString("action");
                    log.userName = rs.getString("userName");
                    log.userRole = rs.getString("userRole");
                    log.date = rs.getDate("date");
                    logs.add(log);
                }
                return logs;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return logs;
    } 

    @Override
    public boolean deleteAll() {
        String sql = "DELETE FROM logs";
        try (
            Statement stmt = conn.createStatement();
            
            ){
              int affected = stmt.executeUpdate(sql);
              if(affected > 0) return true;
              return false;
            } catch (SQLException ex) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
