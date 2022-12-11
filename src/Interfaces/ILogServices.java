package Interfaces;

import Entities.Log;
import java.util.ArrayList;
import java.util.UUID;

public interface ILogServices {
    void deleteLog(Log log);
    UUID getById(UUID idlog);
    ArrayList<Log> getALL();
    void create(Log log);
    
}
