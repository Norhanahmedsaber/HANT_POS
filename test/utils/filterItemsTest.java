/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entities.Item;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class filterItemsTest {
    
    public filterItemsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    
    private ArrayList getTestData()
    {
        ArrayList<Item> items = new ArrayList<>();
        Item item1 = new Item();
        Calendar cl = Calendar. getInstance();
        
        item1.name="oven";
        item1.category="Electrical devices";
        item1.description="Toshiba";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item1.createdAt= cl.getTime();
        item1.price=1000;
        items.add(item1);
        
        Item item2= new Item();
        item2.name="Restistors";
        item2.category="electronics";
        item2.description="k resistor";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item2.createdAt= cl.getTime();
        item2.price=100;
        items.add(item2);
        
        Item item3 = new Item();
        item3.name="microwave";
        item3.category="Electrical devices";
        item3.description="samsung";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item3.createdAt= cl.getTime();
        item3.price=12000;
        items.add(item3);
        return items;
    }



    @Test
    public void testFilter() {
        ArrayList<Item> items = getTestData();
        String search = "";
        String sortitemby = "";
        boolean toggle = false;
        filterItems instance = new filterItems();
        ArrayList<Item> result = null;
        Item item1 = items.get(0);
        Item item2 = items.get(1);
        Item item3 = items.get(2);
        
        //Branch Coverage
        //Test Case 1
        ArrayList<Item> expResult1 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 2
        ArrayList<Item> expResult2 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=true;
        expResult2.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult2.toArray(), result.toArray());
        
        //Test Case 3
        ArrayList<Item> expResult3 = new ArrayList<>();
        search="m";
        sortitemby="Date";
        toggle=false;
        expResult3.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult3.toArray(), result.toArray());
        
        //Test Case 4
        ArrayList<Item> expResult4 = new ArrayList<>();
        search="m";
        sortitemby="Date";
        toggle=true;
        expResult4.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
        
        //Test Case 5
        expResult4 = new ArrayList<>();
        search="m";
        sortitemby="";
        toggle=true;
        expResult4.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
        
        //Condition Coverage
        //Test Case 1
        expResult1 = new ArrayList<>();
        search="";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        expResult1.add(item1);
        expResult1.add(item2);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 2
        expResult1 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 3
        expResult2 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=true;
        expResult2.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult2.toArray(), result.toArray());
        
        //Test Case 4
        expResult3 = new ArrayList<>();
        search="m";
        sortitemby="Date";
        toggle=false;
        expResult3.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult3.toArray(), result.toArray());
        
        //Test Case 5
        expResult4 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=true;
        expResult4.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
        
        //Test Case 6
        expResult4 = new ArrayList<>();
        search="m";
        sortitemby="";
        toggle=true;
        expResult4.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
 
        //Multiple Condition Coverage
        //Test Case 1
        expResult1 = new ArrayList<>();
        search="";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        expResult1.add(item1);
        expResult1.add(item2);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 2
        expResult1 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 3
        expResult2 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=true;
        expResult2.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult2.toArray(), result.toArray());
        
        //Test Case 4
        expResult3 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=false;
        expResult3.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult3.toArray(), result.toArray());
        
        //Test Case 5
        expResult4 = new ArrayList<>();
        search="m";
        sortitemby="Date";
        toggle=true;
        expResult4.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
        
        //Test Case 6
        expResult4 = new ArrayList<>();
        search="m";
        sortitemby="Date";
        toggle=false;
        expResult4.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
        
        //Path Coverage
        //Test Case 1 (1 - 2 - 3 - 4 - 1 - 5 -  6 - 7 - 11)
        expResult1 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 2 (1 - 2 - 3 - 4 - 1 - 5 - 6 - 8 - 10 - 11)
        expResult1 = new ArrayList<>();
        search="m";
        sortitemby="";
        toggle=true;
        expResult1.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 3 (1 - 2 - 3 - 4 - 1 - 5 - 6 - 8 - 9 - 11)
        expResult1 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=true;
        expResult1.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 4 (1 - 5 - 6 - 7 - 11)
        expResult1 = new ArrayList<>();
        search="";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        expResult1.add(item1);
        expResult1.add(item2);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //Test Case 5 (1 - 2 - 4 - 1 - 5 - 6 - 7 - 11)
        expResult1 = new ArrayList<>();
        search="ggg";
        sortitemby="Name";
        toggle=false;
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
    }

    /**
     * Test of search method, of class filterItems.
     */
    @Test
    public void testSearch() {
        ArrayList<Item> items = getTestData();
        String search = "";
        filterItems instance = new filterItems();
        ArrayList<Item> result = null;
        Item item1 = items.get(0);
        Item item2 = items.get(1);
        Item item3 = items.get(2);
        Item item4 = items.get(3);
        Item item5 = items.get(4);
        
        //testcase1:
        ArrayList<Item> expResult1 = new ArrayList<>();
        search="m";
        expResult1.add(item3);
        expResult1.add(item4);
        result = instance.search(items, search);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        //testcase2
        ArrayList<Item> expResult2 = new ArrayList<>();
        search="toy";
        expResult2.add(item4);
        result = instance.search(items, search);
        assertArrayEquals(expResult2.toArray(), result.toArray());
        
        //testcase3
         ArrayList<Item> expResult3 = new ArrayList<>();
        search="res";
        expResult3.add(item2);
        result = instance.search(items, search);
        assertArrayEquals(expResult3.toArray(), result.toArray());
        
    }

   
    @Test
    public void testSortby() {
        ArrayList<Item> items = getTestData();
        String sortitemby = "";
        boolean toggle = false;
        filterItems instance = new filterItems();
        ArrayList<Item> result = null;
        Item item1 = items.get(0);
        Item item2 = items.get(1);
        Item item3 = items.get(2);
        Item item4 = items.get(3);
        Item item5 = items.get(4);
       
        //sortby name 
         ArrayList<Item> expResult1 = new ArrayList<>();
        sortitemby="Name";
        toggle=false;
        expResult1.add(item5);
        expResult1.add(item3);
        expResult1.add(item4);
        expResult1.add(item1);
        expResult1.add(item2);
        result = instance.Sortby(items, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        ArrayList<Item> expResult2 = new ArrayList<>();
        sortitemby="Name";
        toggle=true;
        expResult2.add(item2);
        expResult2.add(item1);
        expResult2.add(item4);
        expResult2.add(item3);
        expResult2.add(item5);
        result = instance.Sortby(items, sortitemby, toggle);
        assertArrayEquals(expResult2.toArray(), result.toArray());
        
        //sortby Date 
        ArrayList<Item> expResult3 = new ArrayList<>();
        sortitemby="Date";
        toggle=false;
        expResult3.add(item2);
        expResult3.add(item1);
        expResult3.add(item4);
        expResult3.add(item3);
        expResult3.add(item5);
        result = instance.Sortby(items, sortitemby, toggle);
        assertArrayEquals(expResult3.toArray(), result.toArray());
        
        ArrayList<Item> expResult4 = new ArrayList<>();
        sortitemby="Date";
        toggle=true;
        expResult4.add(item5);
        expResult4.add(item3);
        expResult4.add(item4);
        expResult4.add(item1);
        expResult4.add(item2);
        result = instance.Sortby(items, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
        
        //sortby catgory
         ArrayList<Item> expResult5 = new ArrayList<>();
        sortitemby="Category";
        toggle=false;
        expResult5.add(item3);
        expResult5.add(item1);
        expResult5.add(item5);
        expResult5.add(item2);
        expResult5.add(item4);
        result = instance.Sortby(items, sortitemby, toggle);
        assertArrayEquals(expResult5.toArray(), result.toArray());
        
         ArrayList<Item> expResult6 = new ArrayList<>();
        sortitemby="Category";
        toggle=true;
        expResult6.add(item4);
        expResult6.add(item2);
        expResult6.add(item5);
        expResult6.add(item1);
        expResult6.add(item3);
        result = instance.Sortby(items, sortitemby, toggle);

        assertArrayEquals(expResult6.toArray(), result.toArray());
        
        //sortby Price
         ArrayList<Item> expResult7 = new ArrayList<>();
        sortitemby="Price";
        toggle=false;
        expResult7.add(item2);
        expResult7.add(item1);
        expResult7.add(item3);
        expResult7.add(item4);
        expResult7.add(item5);
        result = instance.Sortby(items, sortitemby, toggle);
        assertArrayEquals(expResult7.toArray(), result.toArray());
        
         ArrayList<Item> expResult8 = new ArrayList<>();
        sortitemby="Price";
        toggle=true;
        expResult8.add(item5);
        expResult8.add(item4);
        expResult8.add(item3);
        expResult8.add(item1);
        expResult8.add(item2);
        result = instance.Sortby(items, sortitemby, toggle);
        assertArrayEquals(expResult8.toArray(), result.toArray());
    }

    @Test
    public void testGetLargestPrice() {
        ArrayList<Float> prices;
        float expected, a, b, c;
        filterItems Instance = new filterItems();
        
        //Branch Coverage
        //Test Case 1
        prices = new ArrayList<>();
        expected = -1;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Test Case 2
        prices = new ArrayList<>();
        a = 1;
        b = 2;
        c = 5;
        prices.add(a);
        prices.add(b);
        prices.add(c);
        expected = c;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Condition Coverage
        //Test Case 1
        prices = new ArrayList<>();
        expected = -1;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.001);
        
        //Test Case 2
        prices = new ArrayList<>();
        a = 1;
        prices.add(a);
        expected = a;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Test Case 3
        prices = new ArrayList<>();
        a = 10;
        b = 5;
        c = 3;
        prices.add(a);
        prices.add(b);
        prices.add(c);
        expected = a;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Test Case 4
        prices = new ArrayList<>();
        a = 1;
        b = 3;
        c = 5;
        prices.add(a);
        prices.add(b);
        prices.add(c);
        expected = c;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Multiple Condition Coverage
        //Test Case 1
        prices = new ArrayList<>();
        expected = -1;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.001);
        
        //Test Case 2
        prices = new ArrayList<>();
        a = 1;
        prices.add(a);
        expected = a;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Test Case 3
        prices = new ArrayList<>();
        a = 10;
        b = 5;
        c = 3;
        prices.add(a);
        prices.add(b);
        prices.add(c);
        expected = a;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Test Case 4
        prices = new ArrayList<>();
        a = 1;
        b = 3;
        c = 5;
        prices.add(a);
        prices.add(b);
        prices.add(c);
        expected = c;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Path Coverage
        //Test Case 1 (1 - 2 - 8)
        prices = new ArrayList<>();
        expected = -1;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.001);
        
        //Test Case 2 (1 - 3 - 7 - 8)
        prices = new ArrayList<>();
        a = 1;
        prices.add(a);
        expected = a;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Test Case 3 (1 - 3 - 4 - 6 - 3 - 7 - 8)
        prices = new ArrayList<>();
        a = 10;
        b = 5;
        prices.add(a);
        prices.add(b);
        expected = a;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
        //Test Case 4 (1 - 3 - 4 - 5 - 6 - 3 - 7 - 8)
        prices = new ArrayList<>();
        a = 1;
        b = 3;
        prices.add(a);
        prices.add(b);
        expected = b;
        assertEquals(expected, Instance.getLargestPrice(prices), 0.000001);
        
    }
    
}
