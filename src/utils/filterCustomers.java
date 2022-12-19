package utils;

import Entities.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class filterCustomers {
    public ArrayList<Customer> filter(ArrayList<Customer> customers, String searchName, String sortBy , boolean toggle ) {
       
       return Sortby( Search(customers, searchName ),sortBy,toggle);
        
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
    
   public ArrayList<Customer> Sortby (ArrayList<Customer> customers,String sortedby , boolean toggle)
   {
       // sortby name  Ascendingly :
             if (sortedby=="Name"&& toggle == true)
        {     
            Collections.sort(customers,new Comparator<Customer>() {
                public int compare(Customer c1, Customer c2) {
                    return c1.name.compareTo(c2.name);
                }
            });
            return customers ;

        } 
        // sortby name  Descendingly:
       else if (sortedby=="Name"&& toggle== false )
        {     
            Collections.sort(customers,new Comparator<Customer>() {
                public int compare(Customer c1, Customer c2) {
                    return c1.name.compareTo(c2.name);
                }
            });
            Collections.reverse(customers);
            return customers ;

        } 
       // sortby Date Ascendingly :
       else if (sortedby=="Date" && toggle== true)
        { 
             Collections.sort(customers,new Comparator<Customer>() {
                public int compare(Customer c1, Customer c2) {
                    return c1.purchaseDate.compareTo(c2.purchaseDate);
                }
            });
             
            return customers ;
        }
         // sortby Date  Descendingly:
         else if (sortedby=="Date" && toggle== false)
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
