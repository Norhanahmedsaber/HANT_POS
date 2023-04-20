/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entities.*;
import java.time.LocalDateTime;
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
public class filterCustomersTest {
   
    
    private ArrayList getTestData() {
         ArrayList <Customer> customers=new ArrayList<> ();
          Customer Customer1= new Customer();
          Customer Customer2= new Customer();
          Customer Customer3= new Customer();
          Customer Customer4= new Customer();
          Customer Customer5= new Customer();
          Calendar D=Calendar.getInstance();
          
          Customer1.name="norhan ahmed";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
          Customer1.purchaseDate = D.getTime();
          Customer1.email="norhan3182001@gmail.com";
          customers.add(Customer1);
          
           Customer2.name="toka";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
          Customer2.purchaseDate = D.getTime();
          Customer2.email="toka2252001@gmail.com";
          customers.add(Customer2);
          
           Customer3.name="Anas hesham";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
          Customer3.purchaseDate = D.getTime();
          Customer3.email="Anas1112001@gmail.com";
          customers.add(Customer3);
          
           Customer4.name="hussien mostafa";
           D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
          Customer4.purchaseDate = D.getTime();
          Customer4.email="s7s1122001@gmail.com";
          customers.add(Customer4);
          
           Customer5.name="z";
            D.setTime(new Date());
           D.add(Calendar.MONTH, 1);
          Customer5.purchaseDate = D.getTime();
          Customer5.email="habiba2542001@gmail.com";
          customers.add(Customer5);
          
          return customers;
    
    }
        
  
    
    @Test
    public void testFilter() {
        System.out.println("filter");
        ArrayList<Customer> customers = getTestData();
        ArrayList<Customer> expCustomers=new ArrayList<>();
        String searchName = "";
        String sortBy = "";
        boolean toggle = false;
        filterCustomers instance = new filterCustomers();
        ArrayList<Customer> result = null;
       Customer cu0= customers.get(0);
       Customer cu1= customers.get(1);
       Customer cu2= customers.get(2);
       Customer cu3= customers.get(3);
       Customer cu4= customers.get(4);

       
       //test cases1
        searchName = "an";
        sortBy = "Name";
        toggle = true;
       expCustomers=new ArrayList<>();
        expCustomers.add(cu2);
        expCustomers.add(cu0);
        result = instance.filter(customers, searchName, sortBy, toggle);
        assertArrayEquals(expCustomers.toArray(), result.toArray());
        
          //test case2
        searchName = "an";
        sortBy = "Name";
        toggle = false;
        expCustomers=new ArrayList<>();
        expCustomers.add(cu0);
        expCustomers.add(cu2);
        result = instance.filter(customers, searchName, sortBy, toggle);
        assertArrayEquals(expCustomers.toArray(), result.toArray());
        
        //test case3
        searchName = "an";
        sortBy = "Date";
        toggle = true;
        expCustomers=new ArrayList<>();
        expCustomers.add(cu2);
        expCustomers.add(cu0);
        result = instance.filter(customers, searchName, sortBy, toggle);
        assertArrayEquals(expCustomers.toArray(), result.toArray());
        
        //test case4
        searchName = "an";
        sortBy = "Date";
        toggle = false;
        expCustomers=new ArrayList<>();
        expCustomers.add(cu0);
        expCustomers.add(cu2);
        result = instance.filter(customers, searchName, sortBy, toggle);

        assertArrayEquals(expCustomers.toArray(), result.toArray());
         
    }
    

    /**
     * Test of Search method, of class filterCustomers.
     */
    @Test
    public void testSearch() {
        System.out.println("Search");
        ArrayList<Customer> customers = getTestData();
        ArrayList<Customer> expCustomers=new ArrayList<>();
        String searchName = "";
        filterCustomers instance = new filterCustomers();
        ArrayList<Customer> result =null;
       Customer cu0= customers.get(0);
       Customer cu1= customers.get(1);
       Customer cu2= customers.get(2);
       Customer cu3= customers.get(3);
       Customer cu4= customers.get(4);  
       
         //test case1
        searchName = "a";
        expCustomers=new ArrayList<>();
        expCustomers.add(cu0);
        expCustomers.add(cu1);
        expCustomers.add(cu2);
        expCustomers.add(cu3);
        result = instance.Search(customers, searchName);
        assertArrayEquals(expCustomers.toArray(), result.toArray());
    }

  
    @Test
    public void testSortby() {
        System.out.println("Sortby");
        ArrayList<Customer> customers = getTestData();
        ArrayList<Customer> expCustomers=new ArrayList<>();
        String sortedby = "";
        boolean toggle = false;
        filterCustomers instance = new filterCustomers();
        ArrayList<Customer> result =null;        
        
       Customer cu0= customers.get(0);
       Customer cu1= customers.get(1);
       Customer cu2= customers.get(2);
       Customer cu3= customers.get(3);
       Customer cu4= customers.get(4);  
        
         //test case1
        sortedby = "Name";
        toggle = false;
        expCustomers=new ArrayList<>();
        expCustomers.add(cu4);
        expCustomers.add(cu1);
        expCustomers.add(cu0);
        expCustomers.add(cu3);
        expCustomers.add(cu2);
        result = instance.Sortby(customers, sortedby, toggle);
        assertArrayEquals(expCustomers.toArray(), result.toArray());
        
//         //test case2
        sortedby = "Name";
        toggle = true;
        expCustomers=new ArrayList<>();
        expCustomers.add(cu2);
        expCustomers.add(cu3);
        expCustomers.add(cu0);
        expCustomers.add(cu1);
        expCustomers.add(cu4);
        result = instance.Sortby(customers, sortedby, toggle);
        assertArrayEquals(expCustomers.toArray(), result.toArray());
        
        // test case3
        sortedby = "Date";
        toggle = false;
        expCustomers=new ArrayList<>();
        expCustomers.add(cu2);
        expCustomers.add(cu3);
        expCustomers.add(cu0);
        expCustomers.add(cu1);
        expCustomers.add(cu4);
        result = instance.Sortby(customers, sortedby, toggle);
        assertArrayEquals(expCustomers.toArray(), result.toArray());
        
        //test case4
        sortedby = "Date";
        toggle = true;
        expCustomers=new ArrayList<>();
        expCustomers.add(cu4);
        expCustomers.add(cu1);
        expCustomers.add(cu0);
        expCustomers.add(cu3);
        expCustomers.add(cu2);
        result = instance.Sortby(customers, sortedby, toggle);
        System.out.println(result);
        assertArrayEquals(expCustomers.toArray(), result.toArray());


    }
    
}
