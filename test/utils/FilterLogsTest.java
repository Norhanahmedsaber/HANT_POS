package utils;


import Entities.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FilterLogsTest {

   
    
private ArrayList<Log> getTestData(){
        ArrayList<Log> logs = new ArrayList<>();
        Calendar cl = Calendar. getInstance();
        
        
        
        Log log1 = new Log();
        log1.userName = "hussien";
        log1.action= "Created";
        log1.actedOn= "item";
        cl.setTime(new Date());
        cl. add(Calendar.MONTH, 1);
        log1.date = cl.getTime();
        logs.add(log1);
        
        
        Log log2 = new Log();
        log2.userName = "anas";
        log2.action= "Created";
        log2.actedOn= "Customer";
        cl.setTime(new Date());
        cl. add(Calendar.HOUR, 7);
        log2.date = cl.getTime();
        logs.add(log2);
        
        
        Log log3 = new Log();
        log3.userName = "toka";
        log3.action= "Updated";
        log3.actedOn= "User";
        cl.setTime(new Date());
        cl. add(Calendar.YEAR, 1);
        log3.date = cl.getTime();
        logs.add(log3);
        
        
        Log log4 = new Log();
        log4.userName = "nora";
        log4.action= "Deleted";
        log4.actedOn= "User";
        cl.setTime(new Date());
        cl. add(Calendar.DAY_OF_MONTH, 8);
        log4.date = cl.getTime();
        logs.add(log4);
        
        return logs;
}

    @Test
    public void testFilter() {
        System.out.println("filter");
        FilterLogs instance = new FilterLogs();
        ArrayList<Log> logs = getTestData();
        ArrayList<Log> expResult =null;
        ArrayList<Log> result =null;
        String searchName = "";
        String sortBy = "";
        boolean toggle = true;
        
        Log log1=logs.get(0);
        Log log2=logs.get(1);
        Log log3=logs.get(2);
        Log log4=logs.get(3);
        
        

        //test case 1 
        expResult = new ArrayList<>();
        expResult.add(log3);
        expResult.add(log4);
        searchName = "User";
        sortBy = "Action";
        toggle = false;
        result = instance.filter(logs, searchName, sortBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 2
        expResult = new ArrayList<>();
        expResult.add(log4);
        expResult.add(log3);
        searchName = "User";
        sortBy = "Action";
        toggle = true;
        result = instance.filter(logs, searchName, sortBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 3
        expResult = new ArrayList<>();
        expResult.add(log1);
        expResult.add(log2);
        searchName = "Created";
        sortBy = "Acted on";
        toggle = false;
        result = instance.filter(logs, searchName, sortBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 4
        expResult = new ArrayList<>();
        expResult.add(log2);
        expResult.add(log1);
        searchName = "Created";
        sortBy = "Acted on";
        toggle = true;
        result = instance.filter(logs, searchName, sortBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    @Test
    public void testSearch() {
        System.out.println("search");
        
        
        FilterLogs instance = new FilterLogs();
        ArrayList<Log> logs = getTestData();
        ArrayList<Log> expResult =null;
        ArrayList<Log> result =null;
        String search = "";
        
        Log log1=logs.get(0);
        Log log2=logs.get(1);
        Log log3=logs.get(2);
        Log log4=logs.get(3);
        
        

        //test case 1 
        expResult = new ArrayList<>();
        expResult.add(log2);
        search = "anas";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 2
        expResult = new ArrayList<>();
        expResult.add(log1);
        search = "hussien";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 3
        expResult = new ArrayList<>();
        expResult.add(log3);
        search = "toka";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 4
        expResult = new ArrayList<>();
        expResult.add(log4);
        search = "nora";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 5
        expResult = new ArrayList<>();
        expResult.add(log2);
        expResult.add(log3);
        expResult.add(log4);
        search = "o";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 6
        expResult = new ArrayList<>();
        expResult.add(log1);
        search = "uss";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 7
        expResult = new ArrayList<>();
        expResult.add(log1);
        expResult.add(log2);
        search = "Created";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 8
        expResult = new ArrayList<>();
        expResult.add(log3);
        search = "Updated";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 9
        expResult = new ArrayList<>();
        expResult.add(log4);
        search = "Deleted";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 10
        expResult = new ArrayList<>();
        expResult.add(log2);
        search = "Customer";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 11
        expResult = new ArrayList<>();
        expResult.add(log1);
        search = "Item";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 12
        expResult = new ArrayList<>();
        expResult.add(log3);
        expResult.add(log4);
        search = "User";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 13
        expResult = new ArrayList<>();
        expResult.add(log1);
        expResult.add(log2);
        expResult.add(log3);
        expResult.add(log4);
        search = "";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 14
        expResult = new ArrayList<>();
        search = "habiba";
        result = instance.search(logs, search);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        
        


    }

    @Test
    public void testSortBy() {
        System.out.println("SortBy");
        
        FilterLogs instance = new FilterLogs();
        ArrayList<Log> logs = getTestData();
        ArrayList<Log> expResult =null;
        ArrayList<Log> result =null;
        boolean toggle = false;
        String sortedBy = "";
        
        Log log1=logs.get(0);
        Log log2=logs.get(1);
        Log log3=logs.get(2);
        Log log4=logs.get(3);

        
        //test case 1
        expResult = new ArrayList<>();
        expResult.add(log2);
        expResult.add(log4);
        expResult.add(log1);
        expResult.add(log3);
        sortedBy = "Date";
        toggle = false;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 2
        expResult = new ArrayList<>();
        expResult.add(log3);
        expResult.add(log1);
        expResult.add(log4);
        expResult.add(log2);
        sortedBy = "Date";
        toggle = true;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 3
        expResult = new ArrayList<>();
        expResult.add(log2);
        expResult.add(log1);
        expResult.add(log4);
        expResult.add(log3);
        sortedBy = "User Name";
        toggle = true;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 4
        expResult = new ArrayList<>();
        expResult.add(log3);
        expResult.add(log4);
        expResult.add(log1);
        expResult.add(log2);
        sortedBy = "User Name";
        toggle = false;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 5
        expResult = new ArrayList<>();
        expResult.add(log4);
        expResult.add(log3);
        expResult.add(log1);
        expResult.add(log2);
        sortedBy = "Acted on";
        toggle = false;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 6
        expResult = new ArrayList<>();
        expResult.add(log2);
        expResult.add(log1);
        expResult.add(log4);
        expResult.add(log3);
        sortedBy = "Acted on";
        toggle = true;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 7
        expResult = new ArrayList<>();
        expResult.add(log2);
        expResult.add(log1);
        expResult.add(log4);
        expResult.add(log3);
        sortedBy = "Action";
        toggle = true;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());
        
        //test case 8
        expResult = new ArrayList<>();
        expResult.add(log3);
        expResult.add(log4);
        expResult.add(log1);
        expResult.add(log2);
        sortedBy = "Action";
        toggle = false;
        result = instance.SortBy(logs, sortedBy, toggle);
        assertArrayEquals(expResult.toArray(), result.toArray());


    }
    
}
