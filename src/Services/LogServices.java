package Services;
import Entities.Log;
import Entities.User;
import Interfaces.ILogServices;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class LogServices implements ILogServices{
    static ArrayList<Log> logs = new ArrayList<Log>();
    
    
    @Override
    public void deleteLog(UUID logId) {
     logs.remove(getById(logId));
    }

    @Override
    public Log getById(UUID logId) {
        
        for(int i=0;i<logs.size();i++) {
            if(logs.get(i).id == logId) {
                return logs.get(i);
            }
        }
        return null;
    }

    @Override
    public void create(Log log) {
     logs.add(log);
    }
    
    @Override
    public ArrayList<Log> getAll() { 
        return logs; 
    } 
    
    
}
