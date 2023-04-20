
package utils;

import Entities.Log;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;




public class FilterLogsTest {
    
    public FilterLogsTest() {
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


    }
    
}
