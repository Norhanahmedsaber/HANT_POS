/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Role;
import java.util.ArrayList;
import java.util.UUID;
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
public class RoleServicesTest {
        private RoleServices roleServices;

    public RoleServicesTest() {
         roleServices = new RoleServices();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         roleServices.deleteAll();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
      Role bean = new Role();
        bean.name = "admin";
        UUID id = UUID.randomUUID();
        bean.id = id;
        bean.canCreateCustomer =true;
                    bean.canCreateItem =true ;
                    bean.canCreateLog =true ;
                    bean.canCreateRole =true ;
                    bean.canCreateUser =true ;
                    bean.canDeleteCustomer = true;
                    bean.canDeleteItem = true;
                    bean.canDeleteLog = true;
                    bean.canDeleteUser = true;
                    bean.canUpdateCustomer = true;
                    bean.canUpdateItem = true;
                    bean.canUpdateRole = true;
                    bean.canViewCustomers =true;
        bean.canViewItems = true;
        bean.canViewLogs = true;
        bean.canViewRoles = true;
         bean.canViewUsers = true;
        roleServices.create(bean);
        
        //test case1
        Role result = roleServices.getByName("admin");
         System.out.println("beancreattestresult"+bean);
        System.out.println("creattestresult"+result);

        assertEquals(result.toString(), bean.toString());

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Role role = new Role();
        role.name = "admin";
        UUID id = UUID.randomUUID();
        role.id = id;
        RoleServices instance = new RoleServices();
        roleServices.create(role);
        
        // Test Case1
        role.name="admin";
       // role.id=id;
        boolean result = instance.update(role.id,role);
        System.out.println("the result id"+id);
        System.out.println("the role id"+role.id);
        
        System.out.println("the result name"+role.name);
        System.out.println("the role name"+role.name);
        assertFalse(result);
        
        // Test Case2
        role.name = "analyst";
        result = instance.update(id,role);
        assertFalse(result);
        
        // Test Case3
        role.name = "analyst";
         result = instance.update(UUID.randomUUID(),role);
        assertFalse(result);

    }

    @Test
    public void testGetById() {
        System.out.println("getById");
         Role role1 = new Role();
        role1.name = "admin";
        UUID id= UUID.randomUUID();  
        role1.id=id;
        roleServices.create(role1);  
        String Role1=role1.toString();
        RoleServices instance = new RoleServices();
        
          //test case1
        Role expResult = role1;
        Role result = instance.getById(UUID.randomUUID()); 
        System.out.println("testgetbyid result1="+result);
        assertEquals(expResult.toString(), result.toString());
        
        //test case2
        result = instance.getById(UUID.randomUUID()); 
        System.out.println("testgetbyid result2="+result);
        assertEquals(null, result);
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        Role role1 = new Role();
        Role role2 = new Role();
        Role role3 = new Role();
        Role role4 = new Role();
        Role role5 = new Role();    
        
        role1.name = "admin";        
        role2.name = "Technical Support";
        role3.name = "ceo";
        role4.name = "Analyst";        
        role5.name = "Saler";
        
        roleServices.create(role1);
        roleServices.create(role2);
        roleServices.create(role3);
        roleServices.create(role4);
        roleServices.create(role5);  
        
        String Role1=role1.toString();
        String Role2=role2.toString();
        String Role3=role3.toString();
        String Role4=role4.toString();
        String Role5=role5.toString();

        RoleServices instance = new RoleServices();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add(Role1);
        expResult.add(Role2);
        expResult.add(Role3);
        expResult.add(Role4);
        expResult.add(Role5);
        ArrayList<String> result = instance.getAll();
        
        int expSize=expResult.size();
        int resSize=result.size();
        assertEquals(expSize, resSize);
    }

    @Test
    public void testGetByName() {
        System.out.println("getByName");
        String name = "";
        RoleServices instance = new RoleServices();
        Role expResult = null;
        Role result = instance.getByName(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
        @Test
    public void testDeleteAll() {
         System.out.println("deleteAll");
        
        UserServices instance = new UserServices();
        Role role1 = new Role();
        role1.name = "admin";
        
        Role role2 = new Role();
        role2.name = "analyst";

        //test case1
        roleServices.create(role1);
        roleServices.create(role2);
        boolean result = roleServices.deleteAll();
        assertTrue(result);
        
        //test case2
        result = roleServices.deleteAll();
        assertFalse(result);
    }
}
