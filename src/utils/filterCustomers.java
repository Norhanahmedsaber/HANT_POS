package utils;

import Entities.Customer;
import java.util.ArrayList;

public class filterCustomers {
    public ArrayList<Customer> filter(ArrayList<Customer> customers, String searchName, String sortBy) {
        ArrayList <Customer> filtered = Search(customers, searchName);
        return filtered;
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
}
