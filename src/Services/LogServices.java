package Services;
import Entities.Log;
import Entities.User;
import Interfaces.ILogServices;
import java.util.ArrayList;
import java.util.UUID;

public class LogServices implements ILogServices{
    ArrayList<Log> logs = new ArrayList<Log>();
    Log log = new Log();
    


    
    @Override
    public void deleteLog(Log log) {
     
    }

    @Override
    public UUID getById(UUID idlog) {
        return null;
    
    }

    @Override
    public ArrayList<Log> getALL() {
        
      return logs;
    }

    @Override
    public void create(Log log) {
     
    }
    
}
