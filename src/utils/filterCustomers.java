package utils;

import Entities.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class filterCustomers {
    public ArrayList<Customer> filter(ArrayList<Customer> customers, String searchName, String sortBy) {
       
       return Sortby( Search(customers, searchName ),sortBy);
        
    }
    
    
    public ArrayList<Customer> Search( ArrayList<Customer> customers , String searchName )
    {
        ArrayList <Customer> customerAfterSearch = new ArrayList<Customer>();
        for( int i=0 ; i<customers.size() ; i++)
        {
            if(customers.get(i).name.contains(searchName.toLowerCase().trim()))
            {
                customerAfterSearch.add(customers.get(i));
            }
        }
        return customerAfterSearch ;
    }
    
   public ArrayList<Customer> Sortby (ArrayList<Customer> customers,String sortedby)
   {
             if (sortedby=="NameAscendingly")
        {     
            Collections.sort(customers,new Comparator<Customer>() {
                public int compare(Customer c1, Customer c2) {
                    return c1.name.compareTo(c2.name);
                }
            });
            return customers ;

        } 
       else if (sortedby=="NameDescendingly")
        {     
            Collections.sort(customers,new Comparator<Customer>() {
                public int compare(Customer c1, Customer c2) {
                    return c1.name.compareTo(c2.name);
                }
            });
            Collections.reverse(customers);
            return customers ;

        }          
       else if (sortedby=="DateAscendingly")
        { 
             Collections.sort(customers,new Comparator<Customer>() {
                public int compare(Customer c1, Customer c2) {
                    return c1.purchaseDate.compareTo(c2.purchaseDate);
                }
            });
             
            return customers ;
        }
         else if (sortedby=="DateDescendingly")
        { 
             Collections.sort(customers,new Comparator<Customer>() {
                public int compare(Customer c1, Customer c2) {
                    return (c1.purchaseDate.compareTo(c2.purchaseDate));
                }
            });
             Collections.reverse(customers);
            return customers ;
        }
             
       

      return customers ;
   }   

}
