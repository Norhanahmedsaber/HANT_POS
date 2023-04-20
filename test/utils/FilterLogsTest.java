/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utils;

import Entities.Log;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class FilterLogsTest {
    
    public FilterLogsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFilter() {
        System.out.println("filter");
        ArrayList<Log> logs = null;
        String searchName = "";
        String sortBy = "";
        boolean toggle = false;
        FilterLogs instance = new FilterLogs();
        ArrayList<Log> expResult = null;
        ArrayList<Log> result = instance.filter(logs, searchName, sortBy, toggle);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearch() {
        System.out.println("search");
        ArrayList<Log> logs = null;
        String search = "";
        FilterLogs instance = new FilterLogs();
        ArrayList<Log> expResult = null;
        ArrayList<Log> result = instance.search(logs, search);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSortBy() {
        System.out.println("SortBy");
        ArrayList<Log> logs = null;
        String sortedBy = "";
        boolean toggle = false;
        FilterLogs instance = new FilterLogs();
        ArrayList<Log> expResult = null;
        ArrayList<Log> result = instance.SortBy(logs, sortedBy, toggle);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
