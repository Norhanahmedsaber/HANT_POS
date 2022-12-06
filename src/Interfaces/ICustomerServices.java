package Interfaces;

import Entities.Customer;
import java.util.UUID;

public interface ICustomerServices {
    void create(Customer customer);
    void delete(UUID customerId);
    Customer getById(UUID customerId);
    // UUID to be figured
    void update(UUID customerId, Customer customer);
}
