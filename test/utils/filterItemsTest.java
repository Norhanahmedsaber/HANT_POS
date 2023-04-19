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
        
        Item item4 = new Item();
        item4.name=" mini playstation";
        item4.category="toys";
        item4.description="samsung";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item4.createdAt= cl.getTime();
        item4.price=500;
        items.add(item4);
        
        Item item5 = new Item();
        item5.name="baby strollers";
        item5.category="baby";
        item5.description="secure";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        item5.createdAt= cl.getTime();
        item5.price=6000;
        items.add(item5);

        
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
        Item item4 = items.get(3);
        Item item5 = items.get(4);
        
        //search by name sortby name :
        ArrayList<Item> expResult1 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=false;
        expResult1.add(item3);
        expResult1.add(item4);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult1.toArray(), result.toArray());
        
        ArrayList<Item> expResult2 = new ArrayList<>();
        search="m";
        sortitemby="Name";
        toggle=true;
        expResult2.add(item4);
        expResult2.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult2.toArray(), result.toArray());
        
        //search by description sortby name 
        ArrayList<Item> expResult3 = new ArrayList<>();
        search="sam";
        sortitemby="Name";
        toggle=false;
        expResult3.add(item3);
        expResult3.add(item4);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult3.toArray(), result.toArray());
        
         ArrayList<Item> expResult4 = new ArrayList<>();
        search="sam";
        sortitemby="Name";
        toggle=true;
        expResult4.add(item4);
        expResult4.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        assertArrayEquals(expResult4.toArray(), result.toArray());
        
        //search by catgory sortby name 
        ArrayList<Item> expResult5 = new ArrayList<>();
        search="dev";
        sortitemby="Name";
        toggle=false;
        expResult5.add(item3);
        expResult5.add(item1);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult5.toArray(), result.toArray());
        
        ArrayList<Item> expResult6 = new ArrayList<>();
        search="dev";
        sortitemby="Name";
        toggle=true;
        expResult6.add(item1);
        expResult6.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult6.toArray(), result.toArray());
        
        //search and sortby date
        ArrayList<Item> expResult7 = new ArrayList<>();
        search="dev";
        sortitemby="Date";
        toggle=false;
        expResult7.add(item1);
        expResult7.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult7.toArray(), result.toArray());
        
        ArrayList<Item> expResult8 = new ArrayList<>();
        search="dev";
        sortitemby="Date";
        toggle=true;
        expResult8.add(item3);
        expResult8.add(item1);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult8.toArray(), result.toArray());
        
        //search and sortby catgory
         ArrayList<Item> expResult9 = new ArrayList<>();
        search="dev";
        sortitemby="Category";
        toggle=false;
        expResult9.add(item1);
        expResult9.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult9.toArray(), result.toArray());
        
        ArrayList<Item> expResult10 = new ArrayList<>();
        search="dev";
        sortitemby="Category";
        toggle=true;
        expResult10.add(item3);
        expResult10.add(item1);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult10.toArray(), result.toArray());
        
       //search and sortby Price
       
         ArrayList<Item> expResult11 = new ArrayList<>();
        search="dev";
        sortitemby="Price";
        toggle=false;
        expResult11.add(item1);
        expResult11.add(item3);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult11.toArray(), result.toArray());
        
        ArrayList<Item> expResult12 = new ArrayList<>();
        search="dev";
        sortitemby="Price";
        toggle=true;
        expResult12.add(item3);
        expResult12.add(item1);
        result = instance.filter(items, search, sortitemby, toggle);
        System.out.println(result);
        assertArrayEquals(expResult12.toArray(), result.toArray());
        
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

    /**
     * Test of Sortby method, of class filterItems.
     */
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
        System.out.println(result);
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
        System.out.println(result);
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
        System.out.println(result);
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
        System.out.println(result);
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
        System.out.println(result);
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
    
}
