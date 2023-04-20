/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author norha
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

    /**
     * Test of filter method, of class FilterLogs.
     */
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class FilterLogs.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        ArrayList<Log> logs = null;
        String search = "";
        FilterLogs instance = new FilterLogs();
        ArrayList<Log> expResult = null;
        ArrayList<Log> result = instance.search(logs, search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SortBy method, of class FilterLogs.
     */
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
