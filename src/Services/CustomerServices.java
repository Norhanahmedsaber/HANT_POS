package Services; 
import Entities.Customer; 
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
        customers.remove(customerId);
        System.out.println("heehe");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody 
    } 
 
    @Override 
    public ArrayList<Customer> getAll() { 
        return customers; 
    } 
     
}