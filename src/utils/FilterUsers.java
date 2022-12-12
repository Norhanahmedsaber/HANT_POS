package utils;
import Entities.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FilterUsers { 
    
    public ArrayList<User> filter(ArrayList<User> users, String searchName, String sortBy , boolean toggle ) {
         
       return SortBy( Search(users, searchName ),sortBy,toggle);  
    }
    public ArrayList<User> Search( ArrayList<User> customers , String searchName ){
        ArrayList <User> customerAfterSearch = new ArrayList<User>();
        for( int i=0 ; i<customers.size() ; i++)
        {
            if(customers.get(i).name.trim().contains(searchName.toLowerCase().trim()))
            {
                customerAfterSearch.add(customers.get(i));
            }
        }
        return customerAfterSearch ;
    }
    public ArrayList<User> SortBy (ArrayList<User> users,String sortedBy , boolean toggle){
       // sort by name  Ascendingly :
             if (sortedBy=="Name"&& toggle == true)
        {     
            Collections.sort(users,new Comparator<User>() {
                public int compare(User c1, User c2) {
                    return c1.name.compareTo(c2.name);
                }
            });
            return users;

        } 
        // sort by name  Descendingly:
       else if (sortedBy=="Name"&& toggle== false )
        {     
            Collections.sort(users,new Comparator<User>() {
                public int compare(User c1, User c2) {
                    return c1.name.compareTo(c2.name);
                }
            });
            Collections.reverse(users);
            return users ;

        }
       else if (sortedBy=="Role"&&toggle==true)
       {
           Collections.sort(users,new Comparator<User>(){
               public int compare(User c1 , User c2)
               {
                   return c1.role.name.compareTo(c2.role.name);
               }
           });
       }
        else if (sortedBy=="Role"&&toggle==false)
       {
           Collections.sort(users,new Comparator<User>(){
               public int compare(User c1 , User c2)
               {
                   return c1.role.name.compareTo(c2.role.name);
               }
           });
           Collections.reverse(users);
           return users;
       }


      return users ;
   }
    
}
