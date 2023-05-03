package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.DBType;  

public class ConnectionManager {
    private static ConnectionManager instance = null;

//    private final String USERNAME2 = "admin";
//    private final String PASSWORD2 = "bYE87ppv";
//    private final String M_CONN_STRING2 =
//                    "jdbc:mysql://181.215.242.74:18939/dbs";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private final String M_CONN_STRING =
                    "jdbc:mysql://localhost:3306/hant_test";
    
    
    
    private final String H_CONN_STRING =
                    "jdbc:hsqldb:data/hant";
    private DBType dbType = DBType.MYSQL;
    
    private Connection conn = null;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void setDBType(DBType dbType) {
            this.dbType = dbType;
    }

    private boolean openConnection()
    {
            try {
                    switch (dbType) {

                    case MYSQL:
                            conn = DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
                            return true;

                    case HSQLDB:
                        conn = DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
                        return true;

                    default: 
                        return false;
                    }
            }
            catch (SQLException e) {
                    System.err.println(e);
                    return false;
            }

    }

    public Connection getConnection()
    {
            if (conn == null) {
                if (openConnection()) {
                        System.out.println("Connection opened");
                        return conn;
                } else {
                        return null;
                }
            }
            return conn;
    }

    public void close() {
        System.out.println("Closing connection");
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
        }
    }
}
