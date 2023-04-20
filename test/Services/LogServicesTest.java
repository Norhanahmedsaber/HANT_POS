package Services;

import Entities.Log;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogServicesTest {
    private LogServices logServices;
    public LogServicesTest() {
        logServices = new LogServices();
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
    public void testDeleteLog() {
        System.out.println("deleteLog");
        UUID logId = null;
        LogServices instance = new LogServices();
        boolean expResult = false;
        boolean result = instance.deleteLog(logId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        UUID logId = null;
        LogServices instance = new LogServices();
        Log expResult = null;
        Log result = instance.getById(logId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreate() {
        Log bean = new Log();
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.actedOn = "Item";
        bean.action = "Created";
        bean.userName = "anazz";
        bean.actedOnName = "anas";
        bean.userRole = "admin";
        bean.date = Date.from(Instant.EPOCH);
        logServices.create(bean);
        
        Log result = logServices.getById(id);
        assertEquals(result.toString(), bean.toString());
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        LogServices instance = new LogServices();
        ArrayList<Log> expResult = null;
        ArrayList<Log> result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        LogServices instance = new LogServices();
        boolean expResult = false;
        boolean result = instance.deleteAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
