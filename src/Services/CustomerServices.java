package Services; 
import Entities.Customer; 
import Entities.Item;
import Interfaces.ICustomerServices; 
import java.util.ArrayList; 
import java.util.UUID; 
 
public class CustomerServices implements ICustomerServices  { 
    public static ArrayList<Customer> customers = new ArrayList<Customer>(); 
    @Override 
    public void create(Customer customer) { 
        customers.add(customer); 
    } 
 
    @Override 
    public void delete(UUID customerId) { 
        customers.remove(getById(customerId));
    } 
 
    @Override 
    public Customer getById(UUID customerId) { 
        for(int i=0;i<customers.size();i++) {
            if(customers.get(i).id == customerId) {
                return customers.get(i);
            }
        }
        return null; 
    } 
 
    @Override 
    public void update(UUID customerId, Customer customer) { 
        for(int i=0;i<customers.size();i++) {
            if(customers.get(i).id == customerId) {
                customers.get(i).name = customer.name;
                customers.get(i).age = customer.age;
                customers.get(i).job = customer.job;
                customers.get(i).nationalId = customer.nationalId;
                customers.get(i).income = customer.income;
                customers.get(i).email = customer.email;
                customers.get(i).city = customer.city;
                customers.get(i).gender = customer.gender;
                customers.get(i).phoneNumber = customer.phoneNumber;
            }
        }
    } 
 
    @Override 
    public ArrayList<Customer> getAll() { 
        return customers; 
    } 

    @Override
    public ArrayList<Item> getAssignedItems(UUID customerId) {
        return new ArrayList<Item>();
    }
     
}