package Services;

import Entities.User;
import Entities.UserInfo;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserServicesTest {
    
    public UserServicesTest() {
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
    public void testCreate() {
        System.out.println("create");
        User user = null;
        UserServices instance = new UserServices();
        instance.create(user);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        UUID userId = null;
        UserServices instance = new UserServices();
        boolean expResult = false;
        boolean result = instance.delete(userId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        UUID userId = null;
        UserServices instance = new UserServices();
        User expResult = null;
        User result = instance.getById(userId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        UUID userId = null;
        User user = null;
        UserServices instance = new UserServices();
        boolean expResult = false;
        boolean result = instance.update(userId, user);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        UserServices instance = new UserServices();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsersInfo() {
        System.out.println("getUsersInfo");
        UserServices instance = new UserServices();
        ArrayList<UserInfo> expResult = null;
        ArrayList<UserInfo> result = instance.getUsersInfo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
