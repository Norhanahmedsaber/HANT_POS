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
    private ItemServices itemServices;
    private CustomerServices customerServices;
    public CustomerServicesTest() {
         itemServices = new ItemServices();
         customerServices = new CustomerServices();
         
    }
   private ArrayList getitemsIds()
    {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<UUID> itemsIds = new ArrayList<>();
        Item item1 = new Item();
        Calendar cl = Calendar. getInstance();
        
        item1.name="oven";
        item1.id=UUID.randomUUID();
        itemsIds.add(item1.id);
        item1.category="Electrical devices";
        item1.description="Toshiba";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item1.createdAt= cl.getTime();
        item1.price=1000;
        items.add(item1);
        itemServices.create(item1);
        
        Item item2= new Item();
        item2.name="Restistors";
        item2.id=UUID.randomUUID();
        itemsIds.add(item2.id);
        item2.category="electronics";
        item2.description="k resistor";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item2.createdAt= cl.getTime();
        item2.price=100;
        items.add(item2);
        itemServices.create(item2);
        
        Item item3 = new Item();
        item3.name="microwave";
        item3.id=UUID.randomUUID();
        itemsIds.add(item3.id);
        item3.category="Electrical devices";
        item3.description="samsung";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item3.createdAt= cl.getTime();
        item3.price=12000;
        items.add(item3);
        itemServices.create(item3);
        
        Item item4 = new Item();
        item4.id=UUID.randomUUID();
        itemsIds.add(item4.id);
        item4.name=" mini playstation";
        item4.category="toys";
        item4.description="samsung";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item4.createdAt= cl.getTime();
        item4.price=500;
        items.add(item4);
        itemServices.create(item4);
        
        Item item5 = new Item();
        item5.id=UUID.randomUUID();
        itemsIds.add(item5.id);
        item5.name="baby strollers";
        item5.category="baby";
        item5.description="secure";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item5.createdAt= cl.getTime();
        item5.price=6000;
        items.add(item5);
        itemServices.create(item5);
        
        return itemsIds;
    }
     private ArrayList getitems()
    {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<UUID> itemsIds = new ArrayList<>();
        Item item1 = new Item();
        Calendar cl = Calendar. getInstance();
        
        item1.name="oven";
        item1.id=UUID.randomUUID();
        itemsIds.add(item1.id);
        item1.category="Electrical devices";
        item1.description="Toshiba";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item1.createdAt= cl.getTime();
        item1.price=1000;
        items.add(item1);
        itemServices.create(item1);
        
        Item item2= new Item();
        item2.name="Restistors";
        item2.id=UUID.randomUUID();
        itemsIds.add(item2.id);
        item2.category="electronics";
        item2.description="k resistor";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item2.createdAt= cl.getTime();
        item2.price=100;
        items.add(item2);
        itemServices.create(item2);
        
        Item item3 = new Item();
        item3.name="microwave";
        item3.id=UUID.randomUUID();
        itemsIds.add(item3.id);
        item3.category="Electrical devices";
        item3.description="samsung";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item3.createdAt= cl.getTime();
        item3.price=12000;
        items.add(item3);
        itemServices.create(item3);
        
        Item item4 = new Item();
        item4.id=UUID.randomUUID();
        itemsIds.add(item4.id);
        item4.name=" mini playstation";
        item4.category="toys";
        item4.description="samsung";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item4.createdAt= cl.getTime();
        item4.price=500;
        items.add(item4);
        itemServices.create(item4);
        
        Item item5 = new Item();
        item5.id=UUID.randomUUID();
        itemsIds.add(item5.id);
        item5.name="baby strollers";
        item5.category="baby";
        item5.description="secure";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item5.createdAt= cl.getTime();
        item5.price=6000;
        items.add(item5);
        itemServices.create(item5);
        
        return items;
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    //    customerServices.deleteAllCustomers();
    customerServices.deleteAll();
           itemServices.deleteAll();
    }
    
//    @After
//    public void tearDown() {
//         customerServices.deleteAllCustomers();
//         itemServices.deleteAll();
//    }

    @Test
    public void testCreate() {
        System.out.println("create");   
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<UUID> itemsIds = new ArrayList<>();
        itemsIds=getitemsIds();
        items=getitems();
        Calendar D=Calendar.getInstance(); 
        
           Customer Customer1= new Customer();
           UUID id =UUID.randomUUID();
           Customer1.id=id;
           Customer1.name="toto ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.email="norhan3182001@gmail.com";
           Customer1.age=20;
           Customer1.gender="female";
           Customer1.phoneNumber="011119554367";
           Customer1.nationalId="30108310102083";
     
          // test case1
           assertTrue(customerServices.create(Customer1,itemsIds));
    }

    @Test
    public void testDelete() {
           System.out.println("delete");
           ArrayList <UUID> itemsIds=new ArrayList<>();
           itemsIds=getitemsIds();
           Calendar D=Calendar.getInstance();         
           Customer Customer1= new Customer();
           UUID id =UUID.randomUUID();
           Customer1.id=id;
           Customer1.name="norhan ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.email="norhan3182001@gmail.com";
           Customer1.age=20;
           Customer1.gender="female";
           Customer1.phoneNumber="011119554367";
           Customer1.nationalId="30108310102083";
           customerServices.create(Customer1,itemsIds);
        
         //test case 1 
         CustomerServices instance = new CustomerServices();
        boolean result = instance.delete(UUID.randomUUID());
        assertFalse(result);
        
         //test case1  
         if( instance.deleteAssignedItems(id))
         { result = instance.delete(id);
             System.out.println("delete assisgned items");}
        assertTrue(result);

    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        ArrayList <UUID> itemsIds=new ArrayList<>();
           itemsIds=getitemsIds();
           Calendar D=Calendar.getInstance();         
           Customer Customer1= new Customer();
           UUID id =UUID.randomUUID();
           Customer1.id=id;
           Customer1.name="norhan ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.email="norhan3182001@gmail.com";
           Customer1.age=20;
           Customer1.gender="female";
           Customer1.phoneNumber="011119554367";
           Customer1.nationalId="30108310102083";
           customerServices.create(Customer1,itemsIds);
        
        //test case1
         Customer result = customerServices.getById(UUID.randomUUID());
        assertEquals(null, result);
        //test case2
        Customer expResult = Customer1;
         result = customerServices.getById(id);
        assertEquals(expResult.toString().indexOf(0), result.toString().indexOf(0));
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
         ArrayList<Item> items = new ArrayList<>();
        ArrayList<UUID> itemsIds = new ArrayList<>();
        itemsIds=getitemsIds();
        items=getitems();
        Calendar D=Calendar.getInstance(); 
        
           Customer Customer1= new Customer();
           UUID id =UUID.randomUUID();
           Customer1.id=id;
           Customer1.name="norhan ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.email="norhan3182001@gmail.com";
           Customer1.age=20;
           Customer1.gender="female";
           Customer1.phoneNumber="011119554367";
           Customer1.nationalId="30108310102083";
        customerServices.create(Customer1,itemsIds);
        
        //test case1
        Customer1.email="toto31@gmail";
       boolean result=customerServices.update(id, Customer1);
        assertTrue(result);
        
        //test case2
        Customer1.name="anas31@gmail";
        result=customerServices.update(UUID.randomUUID(), Customer1);
        assertTrue(result);
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
      CustomerServices instance = new CustomerServices();
          Calendar D=Calendar.getInstance(); 
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<UUID> itemsIds = new ArrayList<>();
            items=getitems();
            itemsIds=getitemsIds();
           Customer Customer1= new Customer();
          Customer Customer2= new Customer();
          Customer Customer3= new Customer();
          Customer Customer4= new Customer();
          Customer Customer5= new Customer();
          
           Customer1.name="norhan ahmed";
           Customer1.items=items;
           Customer1.id=UUID.randomUUID();
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.phoneNumber="011119554367";           
           Customer1.email="norhan3182001@gmail.com";
           Customer1.nationalId="30108310102083";
           Customer1.gender="female";
           customerServices.create(Customer1,itemsIds);
          
           Customer2.name="toka";
           Customer2.items=items;
           Customer2.id=UUID.randomUUID(); 
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer2.purchaseDate = D.getTime();
           Customer2.email="toka2252001@gmail.com";
           Customer2.phoneNumber="011119554367";
           Customer2.nationalId="30105212100685";
           Customer2.gender="female";
           customerServices.create(Customer2,itemsIds);
          
           Customer3.name="Anas hesham";
           Customer3.items=items;
           Customer3.id=UUID.randomUUID();
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer3.purchaseDate = D.getTime();
           Customer3.email="Anas1112001@gmail.com";
           Customer3.nationalId="30105212110056";
           Customer3.phoneNumber="011119554367";
           Customer3.gender="female";
           customerServices.create(Customer3,itemsIds);
          
           Customer4.name="hussien mostafa";
           Customer4.items=items;  
           Customer4.id=UUID.randomUUID();
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer4.purchaseDate = D.getTime();
           Customer4.email="s7s1122001@gmail.com";
           Customer4.nationalId="301052121510056";
           Customer4.phoneNumber="011119554367";  
           Customer4.gender="female";
           customerServices.create(Customer4,itemsIds);
          
           Customer5.name="z";
           Customer5.items=items;
           Customer5.id=UUID.randomUUID();
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer5.purchaseDate = D.getTime();
           Customer5.email="habiba2542001@gmail.com";
           Customer5.phoneNumber="011119554367";           
           Customer5.nationalId="301055212110056";
           Customer5.gender="female";
           customerServices.create(Customer5,itemsIds);

        ArrayList <Customer> expResult=new ArrayList<> ();
        expResult.add(Customer1);
        expResult.add(Customer2);
        expResult.add(Customer3);
        expResult.add(Customer4);
        expResult.add(Customer5);

        ArrayList<Customer> result = instance.getAll();
        assertEquals(result.size(), expResult.size());
  }

    @Test
    public void testGetAssignedItems() {
        System.out.println("getAssignedItems");
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<UUID> itemsIds = new ArrayList<>();
        itemsIds=getitemsIds();
        items=getitems();
        Calendar D=Calendar.getInstance(); 
        
           Customer Customer1= new Customer();
           UUID id =UUID.randomUUID();
           Customer1.id=id;
           Customer1.name="norhan ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.email="norhan3182001@gmail.com";
           Customer1.age=20;
           Customer1.gender="female";
           Customer1.phoneNumber="011119554367";
           Customer1.nationalId="30108310102083";
        customerServices.create(Customer1,itemsIds);
        ArrayList <Item> assigneditemsresult=customerServices.getAssignedItems(id);   
        assertEquals(items.size(), assigneditemsresult.size());

    }


    @Test
    public void testAssignItemsToCustomer() {
        System.out.println("assignItemsToCustomer");
          ArrayList <UUID> itemsIds=new ArrayList<>();
           itemsIds=getitemsIds();
           Calendar D=Calendar.getInstance();         
           Customer Customer1= new Customer();
           UUID id =UUID.randomUUID();
           Customer1.id=id;
           Customer1.name="norhan ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.email="norhan3182001@gmail.com";
           Customer1.age=20;
           Customer1.gender="female";
           Customer1.phoneNumber="011119554367";
           Customer1.nationalId="30108310102083";
           customerServices.create(Customer1,itemsIds);
        CustomerServices instance = new CustomerServices();
        ArrayList <Item> result= instance.getAssignedItems(id);
        System.out.println("result size ="+result.size());
        assertEquals(result.size(),5);

    }
    @Test
    public void testDeleteAssignedItems() {
        System.out.println("deleteAssignedItems");
         ArrayList <UUID> itemsIds=new ArrayList<>();
           itemsIds=getitemsIds();
           Calendar D=Calendar.getInstance();         
           Customer Customer1= new Customer();
           UUID id =UUID.randomUUID();
           Customer1.id=id;
           Customer1.name="norhan ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
           Customer1.purchaseDate = D.getTime();
           Customer1.email="norhan3182001@gmail.com";
           Customer1.age=20;
           Customer1.gender="female";
           Customer1.phoneNumber="011119554367";
           Customer1.nationalId="30108310102083";
           customerServices.create(Customer1,itemsIds);
        CustomerServices instance = new CustomerServices();
        
         //test case1  
        assertTrue(instance.deleteAssignedItems(id));
        //test case2
        assertTrue(instance.deleteAssignedItems(UUID.randomUUID()));
    }
 
}
