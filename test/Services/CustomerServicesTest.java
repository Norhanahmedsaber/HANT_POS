/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Customer;
import Entities.Item;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author norha
 */
public class CustomerServicesTest {
    private CustomerServices customerServices;
    public CustomerServicesTest() {
         customerServices = new CustomerServices();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        customerServices.deleteAll();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Customer customer = new Customer();
        ArrayList<UUID> itemsIds = null;
        CustomerServices instance = new CustomerServices();
        instance.create(customer, itemsIds);

    }


    @Test
    public void testDelete() {
        System.out.println("delete");
        UUID customerId = null;
        CustomerServices instance = new CustomerServices();
        boolean expResult = false;
        boolean result = instance.delete(customerId);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        UUID customerId = null;
        CustomerServices instance = new CustomerServices();
        Customer expResult = null;
        Customer result = instance.getById(customerId);
        assertEquals(expResult, result);

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        UUID customerId = null;
        Customer customer = null;
        CustomerServices instance = new CustomerServices();
        boolean expResult = false;
        boolean result = instance.update(customerId, customer);
        assertEquals(expResult, result);

    }

    @Test
//    public void testGetAll() {
//        System.out.println("getAll");
//        ArrayList<UUID>
//          Customer Customer1= new Customer();
//          Customer Customer2= new Customer();
//          Customer Customer3= new Customer();
//          Customer Customer4= new Customer();
//          Customer Customer5= new Customer();
//          Calendar D=Calendar.getInstance();
//          
//          Customer1.name="norhan ahmed";
//           D.setTime(new Date());
//           D.add(Calendar.MONTH, 1);
//          Customer1.purchaseDate = D.getTime();
//          Customer1.email="norhan3182001@gmail.com";
//          customerServices.create(Customer1);
//          
//           Customer2.name="toka";
//           D.setTime(new Date());
//           D.add(Calendar.MONTH, 1);
//          Customer2.purchaseDate = D.getTime();
//          Customer2.email="toka2252001@gmail.com";
//          customers.crea(Customer2);
//          
//           Customer3.name="Anas hesham";
//           D.setTime(new Date());
//           D.add(Calendar.MONTH, 1);
//          Customer3.purchaseDate = D.getTime();
//          Customer3.email="Anas1112001@gmail.com";
//          customers.add(Customer3);
//          
//           Customer4.name="hussien mostafa";
//           D.setTime(new Date());
//           D.add(Calendar.MONTH, 1);
//          Customer4.purchaseDate = D.getTime();
//          Customer4.email="s7s1122001@gmail.com";
//          customers.add(Customer4);
//          
//           Customer5.name="z";
//            D.setTime(new Date());
//           D.add(Calendar.MONTH, 1);
//          Customer5.purchaseDate = D.getTime();
//          Customer5.email="habiba2542001@gmail.com";
//          customers.add(Customer5);
//        
//        CustomerServices instance = new CustomerServices();
//        ArrayList<Customer> expResult = null;
//        ArrayList<Customer> result = instance.getAll();
//        assertEquals(expResult, result);
//
//    }

//    @Test
//    public void testGetAssignedItems() {
//        System.out.println("getAssignedItems");
//        
//        
//        UUID customerId = null;
//        CustomerServices instance = new CustomerServices();
//        ArrayList<Item> expResult = null;
//        ArrayList<Item> result = instance.getAssignedItems(customerId);
//        assertEquals(expResult, result);
//
//    }


    @Test
    public void testAssignItemsToCustomer() {
        System.out.println("assignItemsToCustomer");
        UUID customerId = null;
        ArrayList<UUID> itemsIds = null;
        CustomerServices instance = new CustomerServices();
        instance.assignItemsToCustomer(customerId, itemsIds);

    }


    @Test
    public void testUpdateAssignedItemsToCustomer() {
        System.out.println("updateAssignedItemsToCustomer");
        UUID customerId = null;
        ArrayList<UUID> itemsIds = null;
        CustomerServices instance = new CustomerServices();
        instance.updateAssignedItemsToCustomer(customerId, itemsIds);

    }


    @Test
    public void testDeleteAssignedItems() {
        System.out.println("deleteAssignedItems");
        UUID customerId = null;
        CustomerServices instance = new CustomerServices();
        boolean expResult = false;
        boolean result = instance.deleteAssignedItems(customerId);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetDayCustomers() {
        System.out.println("getDayCustomers");
        Date day = null;
        CustomerServices instance = new CustomerServices();
        ArrayList<Customer> expResult = null;
        ArrayList<Customer> result = instance.getDayCustomers(day);
        assertEquals(expResult, result);

    }
    
}
