package utils;

import Entities.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class filterCustomers {
    public ArrayList<Customer> filter(ArrayList<Customer> customers, String searchName, String sortBy) {
      // public  search(searchName);
       Sortby(customers,sortBy);
       return customers;
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
