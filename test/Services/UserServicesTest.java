package Services;

import Entities.Role;
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
    private UserServices userServices;
    private RoleServices roleServices;
    
    public UserServicesTest() {
        userServices = new UserServices();
        roleServices = new RoleServices();
        
    }
    
    
    @Before
    public void setUp() {
        userServices.deleteAll();
        roleServices.deleteAll();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
        Role role = new Role();
        role.name = "admin";
        roleServices.create(role);
        User bean = new User();
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.name = "Anas Hesham";
        bean.userName = "Anazz";
        bean.password = "123";
        Role r = new Role();
        r.name = "admin";
        bean.role = r;
        userServices.create(bean);
        
        User user = userServices.getById(id);
        User result = user;
        assertEquals(result.toString(), bean.toString());
    }

    @Test
    public void testDelete() {
        Role role = new Role();
        role.name = "admin";
        UUID idr = UUID.randomUUID();
        role.id=idr;
        roleServices.create(role);
        User bean = new User();
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.name = "Anas Hesham";
        bean.userName = "Anazz";
        bean.password = "123";
        Role r = new Role();
        r.name = "admin";
        bean.role = role;
        userServices.create(bean);
        
        // Test Case 1
        boolean result = userServices.delete(id);
        assertTrue(result);
        
        result = userServices.delete(UUID.randomUUID());
        assertFalse(result);
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
