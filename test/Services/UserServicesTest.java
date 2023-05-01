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
        userServices.deleteAll();
        roleServices.deleteAll();
    }

   @Test
    public void testCreate() {
        Role role = new Role();
        role.name = "admin";
        UUID roleId = UUID.randomUUID();
        role.id = roleId;
        roleServices.create(role);
        User bean = new User();
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.name = "Anas Hesham";
        bean.userName = "Anazz";
        bean.password = "123";
        bean.role = roleServices.getById(roleId);
        userServices.create(bean);

        User user = userServices.getById(id);
        User result = user;
        assertEquals(result.toString(), bean.toString());
    }

    @Test
    public void testDelete() {
        Role role = new Role();
        role.name = "admin";
        role.id = UUID.randomUUID();
        roleServices.create(role);
        User bean = new User();
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.name = "Anas Hesham";
        bean.userName = "Anazz";
        bean.password = "123";
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
        Role role = new Role();
        role.name = "admin";
        role.id = UUID.randomUUID();
        roleServices.create(role);
        User bean = new User();
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.name = "Anas Hesham";
        bean.userName = "Anazz";
        bean.password = "123";
        bean.role = role;
        UserServices instance = new UserServices();
        userServices.create(bean);
        
        //test case1
        User expResult = bean;
        User result = instance.getById(id);
        System.out.println("result="+result);
        assertEquals(expResult.toString(), result.toString());
        
        //testcase2
        expResult = bean;
        result = instance.getById(UUID.randomUUID());
        System.out.println("result="+result);
        assertEquals(null, result);
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Role role = new Role();
        role.name = "admin";
        role.id = UUID.randomUUID();
        roleServices.create(role);
        User bean = new User();
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.name = "Anas Hesham";
        bean.userName = "Anazz";
        bean.password = "123";
        bean.role = role;
        userServices.create(bean);
        
        // Test Case 1
        bean.name="nora";
        bean.userName = "Anazz";
        bean.password = "123";
        userServices.update(id, bean);
        boolean result = userServices.update(id, bean);
           System.out.println("the result id"+id);
        System.out.println("the role id"+bean.id);
        
        System.out.println("the result name"+bean.name);
        System.out.println("the role name"+bean.name);
        assertTrue(result);
        
        // Test Case2
        bean.name="nora";
        bean.userName = "noraa";
        bean.password = "123";
        result = userServices.update(id,bean);
        assertTrue(result);
        
        // Test Case3
        bean.name = "Anas";
        bean.userName = "Anazz";
        bean.password = "123";
        result = userServices.update(UUID.randomUUID(),bean);
     
        assertFalse(result);
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        UserServices instance = new UserServices();
        
        Role role1 = new Role();
        Role role2 = new Role();
        Role role3 = new Role();
        Role role4 = new Role();
        Role role5 = new Role();     
        role1.name = "admin";
        role1.id = UUID.randomUUID();
        role2.name = "Technical Support";
        role2.id = UUID.randomUUID();
        role3.name = "ceo";
        role3.id = UUID.randomUUID();
        role4.name = "Analyst";
        role4.id = UUID.randomUUID();
        role5.name = "Saler";
        role5.id = UUID.randomUUID();
        roleServices.create(role1);
        roleServices.create(role2);
        roleServices.create(role3);
        roleServices.create(role4);
        roleServices.create(role5);  
        User user1 = new User();
        User user2 = new User(); 
        User user3 = new User(); 
        User user4 = new User(); 
        User user5 = new User(); 

        user1.id=UUID.randomUUID();
        user1.name = "Anas Hesham";
        user1.userName = "anazz";
        user1.password = "00000000";
        user1.role = role1;
        userServices.create(user1);
      
        user2.id=UUID.randomUUID();
        user2.name = "Hussien Mostafa";
        user2.userName = "s7s";
        user2.password = "00000000";
        user2.role = role2;
        userServices.create(user2);
       
        user3.id=UUID.randomUUID();
        user3.name = "Norhan Ahmed";
        user3.userName = "noor";
        user3.password = "00000000";
        user3.role = role3;
        userServices.create(user3);  
       
        user4.id=UUID.randomUUID();
        user4.name = "Toka Abd El Gawad";
        user4.userName = "toka";
        user4.password = "00000000";
        user4.role = role4;
        userServices.create(user4);

        user5.id=UUID.randomUUID();
        user5.name = "Habiba Emad";
        user5.userName = "habiba";
        user5.password = "00000000";
        user5.role = role5;
        userServices.create(user5);  
          
        //test case1
        ArrayList<User> expResult = new ArrayList<>();
        expResult.add(user1);
        expResult.add(user2);
        expResult.add(user3);
        expResult.add(user4);
        expResult.add(user5);
        
        ArrayList<User> result = userServices.getAll();
        
        int expSize=expResult.size();
        int resSize=result.size();
        assertEquals(expSize, resSize);
    }

        @Test
    public void testDeleteAll() {
        Role role1 = new Role();
        role1.name = "admin";
        role1.id = UUID.randomUUID();
        roleServices.create(role1);
        User bean1 = new User();
        UUID id1 = UUID.randomUUID();
        bean1.id = id1;
        bean1.name = "norhan";
        bean1.userName = "nora";
        bean1.password = "888";
        bean1.role = role1;
        
        Role role2 = new Role();
        role2.name = "analyst";
        role2.id = UUID.randomUUID();
        roleServices.create(role2);
        User bean2 = new User();
        UUID id2 = UUID.randomUUID();
        bean2.id = id2;
        bean2.name = "norhan";
        bean2.userName = "nora";
        bean2.password = "888";
        bean2.role = role2;
       
        //test case1
        userServices.create(bean1);
        userServices.create(bean2);
        boolean result = userServices.deleteAll();
        assertTrue(result);
        
        //test case2
        result = userServices.deleteAll();
        assertFalse(result);
    }
    
}
