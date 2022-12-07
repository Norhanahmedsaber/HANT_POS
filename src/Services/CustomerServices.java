package Services;
import Entities.Customer;
import Interfaces.ICustomerServices;
import java.util.ArrayList;
import java.util.UUID;

public class CustomerServices implements ICustomerServices  {
    public static ArrayList<Customer> customers  ;

    @Override
    public void create(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void delete(UUID customerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer getById(UUID customerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UUID customerId, Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Customer> getAll() {
        // test data
        customers = new ArrayList<Customer>();
        Customer c1 = new Customer ();
        c1.name = "anas";
        c1.email = "anashesham000@gmail.com";
        c1.address = "cairo";
        c1.age = 21;
        c1.income = 60;
        c1.nationalId = "30101011201693";
        c1.phoneNumber = "01127502010";
        Customer c2 = new Customer();
        c2.name = "hussien";
        c2.email = "hussienmostafa888@gmail.com";
        c2.address = "aswan";
        c2.age = 22;
        c2.income = 400000;
        c2.nationalId = "30002110103732";
        c2.phoneNumber = "01018538422";
        Customer c3 = new Customer();
        c3.name = "norhan";
        c3.email = "hesham000@gmail.com";
        c3.address = "bola2";
        c3.age = 18;
        c3.income = 600;
        c3.nationalId = "30101011201693";
        c3.phoneNumber = "01140106552";
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        return customers;
    }
    
}
