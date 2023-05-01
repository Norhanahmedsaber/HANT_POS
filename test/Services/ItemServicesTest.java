/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.CategoryInfo;
import Entities.Customer;
import Entities.Item;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author DELL
 */
public class ItemServicesTest {
    private ItemServices itemServices;
    
    public ItemServicesTest() {
        itemServices = new ItemServices();
                
    }
    
   
    
    @Before
    public void setUp() {
       itemServices.deleteAll();
        
    }
    
    @After
    public void tearDown() {
        itemServices.deleteAll();
    }

    /**
     * Test of create method, of class ItemServices.
     */
    @Test
    public void testCreate() {
        //testcase 1:
       Item item = new Item();
       UUID id =UUID.randomUUID();
       item.id = id;
       item.name = "oven";
       item.category ="Electrical device";
       item.description="Sharp";
       item.price=15000;
       Calendar cl = Calendar. getInstance();
       cl.setTime(new Date());
       cl. add(Calendar.MONTH, 1);
       item.createdAt=cl.getTime();
       boolean result =itemServices.create(item);
       assertTrue(result);
        
//       //testcase 2:
//       Item item2 = new Item();
//       item2.id = null;
//       item2.name = null;
//       item2.category =null;
//       item2.description=null;
//       item2.price=0;
//       Calendar c2 = Calendar. getInstance();
//       c2.setTime(new Date());
//       c2. add(Calendar.MONTH, 1);
//       item2.createdAt=null;
//       boolean result2 =itemServices.create(item2);
//       assertFalse(result2);
//       
    
       
    }

    /**
     * Test of delete method, of class ItemServices.
     */
    @Test
    public void testDelete() {
        
       Item item = new Item();
       UUID id =UUID.randomUUID();
       item.id = id;
       item.name = "oven";
       item.category ="Electrical device";
       item.description="Sharp";
       item.price=15000;
       Calendar cl = Calendar. getInstance();
       cl.setTime(new Date());
       cl. add(Calendar.MONTH, 1);
       item.createdAt=cl.getTime();
       itemServices.create(item);
       
       Item item2 = new Item();
       UUID id2 =UUID.randomUUID();
       item2.id = id2;
       item2.name = "oven";
       item2.category ="Electrical device";
       item2.description="Sharp";
       item2.price=15000;
       Calendar c2 = Calendar. getInstance();
       c2.setTime(new Date());
       c2. add(Calendar.MONTH, 1);
       item2.createdAt=c2.getTime();
       itemServices.create(item2);
       
       Item item3 = new Item();
       UUID id3 =UUID.randomUUID();
       item3.id = id3;
       item3.name = "oven";
       item3.category ="Electrical device";
       item3.description="Sharp";
       item3.price=15000;
       Calendar c3 = Calendar. getInstance();
       c3.setTime(new Date());
       c3. add(Calendar.MONTH, 1);
       item3.createdAt=c3.getTime();
      itemServices.create(item3);
       //testcase 1 :
       boolean result1 = itemServices.delete(id3);
        assertTrue(result1);
        
        //testcase 2 :
        boolean result2 = itemServices.delete(id);
        assertTrue(result2);
        
        //testcase3:
        boolean result3 = itemServices.delete(UUID.randomUUID());
        assertFalse(result3);
    }

    /**
     * Test of getById method, of class ItemServices.
     */
    @Test
    public void testGetById() throws ParseException {
        Item item = new Item();
       UUID id =UUID.randomUUID();
       item.id = id;
       item.name = "oven";
       item.category ="Electrical device";
       item.description="Sharp";
       item.price=15000;
       Calendar cl = Calendar. getInstance();
       cl.setTime(new Date());
       cl. add(Calendar.MONTH, 1);
       item.createdAt=cl.getTime();
       itemServices.create(item);
       
       Item item2 = new Item();
       UUID id2 =UUID.randomUUID();
       item2.id = id2;
       item2.name = "microwave";
       item2.category ="Electrical device";
       item2.description="Sharp";
       item2.price=15000;
       Calendar c2 = Calendar. getInstance();
       c2.setTime(new Date());
       c2. add(Calendar.MONTH, 1);
        System.out.println(c2.getTime());
       item2.createdAt=c2.getTime();
       itemServices.create(item2);
       
       Item item3 = new Item();
       UUID id3 =UUID.randomUUID();
       item3.id = id3;
       item3.name = "playstation";
       item3.category ="Electrical device";
       item3.description="Sharp";
       item3.price=15000;
       Calendar c3 = Calendar. getInstance();
       c3.setTime(new Date());
       c3. add(Calendar.MONTH, 1);
       item3.createdAt=c3.getTime();
      itemServices.create(item3);
      
      //testcase 1:
      Item  result1 = itemServices.getById(id);
      Item expresult1=item;
      assertEquals(expresult1.toString() , result1.toString());
      
      //testcase 2 :
      Item result2 = itemServices.getById(id2);
      Item expResult2 = item2;
      assertEquals(expResult2.toString(), result2.toString());
    
    }

    /**
     * Test of update method, of class ItemServices.
     */
    @Test
    public void testUpdate() {
     
       Item item = new Item();
       UUID id =UUID.randomUUID();
       item.id = id;
       item.name = "oven";
       item.category ="Electrical device";
       item.description="Sharp";
       item.price=15000;
       Calendar cl = Calendar. getInstance();
       cl.setTime(new Date());
       cl. add(Calendar.MONTH, 1);
       item.createdAt=cl.getTime();
       itemServices.create(item);
      
       //testcase 1:
       item.name = "Barbie doll";
       item.category ="toys";
       boolean result = itemServices.update(id, item);
       assertTrue(result);
       
       //testcase 2 :
       item.description="for girls";
       boolean result2 = itemServices.update(id, item);
        assertTrue(result2);
        
       //testcase 3 :
       boolean result3 = itemServices.update(UUID.randomUUID(), item);
        assertFalse(result3);
      
    }

    /**
     * Test of getAllItems method, of class ItemServices.
     */
    @Test
    public void testGetAllItems() {
         Item item = new Item();
       UUID id =UUID.randomUUID();
       item.id = id;
       item.name = "oven";
       item.category ="Electrical device";
       item.description="Sharp";
       item.price=15000;
       Calendar cl = Calendar. getInstance();
       cl.setTime(new Date());
       cl. add(Calendar.MONTH, 1);
       item.createdAt=cl.getTime();
       itemServices.create(item);
       
       Item item2 = new Item();
       UUID id2 =UUID.randomUUID();
       item2.id = id2;
       item2.name = "microwave";
       item2.category ="Electrical device";
       item2.description="Sharp";
       item2.price=15000;
       Calendar c2 = Calendar. getInstance();
       c2.setTime(new Date());
       c2. add(Calendar.MONTH, 1);
       item2.createdAt=c2.getTime();
       itemServices.create(item2);
       
       Item item3 = new Item();
       UUID id3 =UUID.randomUUID();
       item3.id = id3;
       item3.name = "playstation";
       item3.category ="Electrical device";
       item3.description="Sharp";
       item3.price=15000;
       Calendar c3 = Calendar. getInstance();
       c3.setTime(new Date());
       c3. add(Calendar.MONTH, 1);
       item3.createdAt=c3.getTime();
      itemServices.create(item3);
      
      //testcase 1 :
      ArrayList<Item> result = new ArrayList<>();
      ArrayList<Item> expResult = new ArrayList<>();
      result = itemServices.getAllItems();
      expResult.add(item);
      expResult.add(item2);
      expResult.add(item3);
      assertEquals(expResult.toArray().length, result.toArray().length);
      
        
    } 
    
}
