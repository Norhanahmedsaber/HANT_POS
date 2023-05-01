package utils;

import Entities.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class FilterLogs {
    
    public ArrayList<Log> filter(ArrayList<Log> logs, String searchName, String sortBy , boolean toggle ) {
         
        return SortBy( search(logs, searchName ),sortBy,toggle);  
    }
    
    public ArrayList<Log> search(ArrayList<Log> logs , String search ){
        ArrayList <Log> logsAftersearch = new ArrayList<Log>();
        for(int i=0 ; i<logs.size();i++)
        {
            boolean userName = logs.get(i).userName.toLowerCase().contains(search.toLowerCase().trim());
            boolean action =logs.get(i).action.toLowerCase().contains(search.toLowerCase().trim());
            boolean actedOn = logs.get(i).actedOn.toLowerCase().contains(search.toLowerCase().trim());

            if(userName || action || actedOn)
            {      
                logsAftersearch.add(logs.get(i));   
            }
        }
        return logsAftersearch;   
    }
    public ArrayList<Log> SortBy (ArrayList<Log> logs,String sortedBy , boolean toggle){
        // sort by user name  Ascendingly :
        if (sortedBy == "User Name" && toggle == true)
        {     
            Collections.sort(logs,new Comparator<Log>() {
                public int compare(Log l1, Log l2) {
                    return l1.userName.toLowerCase().compareTo(l2.userName.toLowerCase());
                }
            });
            return logs;
        } 
        
        // sort by user name  Descendingly:
        else if (sortedBy == "User Name"&& toggle== false )
        {     
            Collections.sort(logs,new Comparator<Log>() {
                public int compare(Log l1, Log l2) {
                    return l1.userName.toLowerCase().compareTo(l2.userName.toLowerCase());
                }
            });
            Collections.reverse(logs);
            return logs ;
        }
        
        // sort by Action  Ascendingly :
        if (sortedBy == "Action"&& toggle == true)
        {     
            Collections.sort(logs,new Comparator<Log>() {
                public int compare(Log l1, Log l2) {
                    return l1.action.toLowerCase().compareTo(l2.action.toLowerCase());
                }
            });
            return logs;
        } 
             
        // sort by Action  Descendingly:
        else if (sortedBy == "Action"&& toggle== false )
        {     
            Collections.sort(logs,new Comparator<Log>() {
                public int compare(Log l1, Log l2) {
                    return l1.action.toLowerCase().compareTo(l2.action.toLowerCase());
                }
            });
            Collections.reverse(logs);
            return logs ;
        }
        
        // sort by Acted on  Ascendingly :
        if (sortedBy == "Acted on"&& toggle == true)
        {     
            Collections.sort(logs,new Comparator<Log>() {
                public int compare(Log l1, Log l2) {
                    return l1.actedOn.toLowerCase().compareTo(l2.actedOn.toLowerCase());
                }
            });
            return logs;
        } 
             
        // sort by Acted on  Descendingly:
        else if (sortedBy == "Acted on"&& toggle== false )
        {     
            Collections.sort(logs,new Comparator<Log>() {
                public int compare(Log l1, Log l2) {
                    return l1.actedOn.toLowerCase().compareTo(l2.actedOn.toLowerCase());
                }
            });
            Collections.reverse(logs);
            return logs ;
        }
        
        // sort by Date  Ascendingly :
        else if (sortedBy=="Date" && toggle== false)
        { 
             Collections.sort(logs,new Comparator<Log>() {
                public int compare(Log l1, Log l2) {
                    return l1.date.compareTo(l2.date);
                }
            });
             
            return logs ;
        }
        
        // sort by Date  Descendingly:
        else if (sortedBy=="Date" && toggle==true)
        { 
             Collections.sort(logs,new Comparator<Log>() {
                @Override
                public int compare(Log l1, Log l2) {
                    return (l1.date.compareTo(l2.date));
                }
            });
             Collections.reverse(logs);
            return logs ;
        }
  
        return logs ;
   }
    
}
