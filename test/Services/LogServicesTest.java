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
        logServices.deleteAll();
    }
    
    @After
    public void tearDown() {
        logServices.deleteAll();
    }

    @Test
    public void testDeleteLog() {
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
        boolean result = logServices.deleteLog(id);
        assertTrue(result);
        
        result = logServices.deleteLog(UUID.randomUUID());
        assertFalse(result);
    }

    @Test
    public void testGetById() {
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
        
        
        // Test Case 1
        Log result = logServices.getById(id);
        assertEquals(result.toString(), bean.toString());
        
        // Test Case 2
        result = logServices.getById(UUID.randomUUID());
        assertEquals(null, result);        
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
        
        Log bean2 = new Log();
        UUID id2 = UUID.randomUUID();
        bean2.id = id2;
        bean2.actedOn = "Item";
        bean2.action = "Created";
        bean2.userName = "anazz";
        bean2.actedOnName = "anas";
        bean2.userRole = "admin";
        bean2.date = Date.from(Instant.EPOCH);
        logServices.create(bean2);
        
        ArrayList<Log> logs = logServices.getAll();
        ArrayList<Log> exp = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        ArrayList<String> expected = new ArrayList<>();
        
        exp.add(bean);
        exp.add(bean2);
        for(Log log : exp) {
            expected.add(log.toString());
        }
        for(Log log : logs) {
            actual.add(log.toString());
        }
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testDeleteAll() {
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
        
        Log bean2 = new Log();
        UUID id2 = UUID.randomUUID();
        bean2.id = id2;
        bean2.actedOn = "Item";
        bean2.action = "Created";
        bean2.userName = "anazz";
        bean2.actedOnName = "anas";
        bean2.userRole = "admin";
        bean2.date = Date.from(Instant.EPOCH);
        logServices.create(bean2);
        
        logServices.deleteAll();
        ArrayList<Log> logs = logServices.getAll();
        assertEquals(0, logs.size());
    }
    
}
