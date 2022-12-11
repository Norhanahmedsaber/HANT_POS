package Interfaces;

import Entities.Customer;
import Entities.Item;
import java.util.ArrayList;
import java.util.UUID;

public interface ICustomerServices {
    void create(Customer customer);
    void delete(UUID customerId);
    ArrayList<Customer> getAll();
    Customer getById(UUID customerId);
    // UUID to be figured
    void update(UUID customerId, Customer customer);
    ArrayList<Item> getAssignedItems(UUID customerId);
}
