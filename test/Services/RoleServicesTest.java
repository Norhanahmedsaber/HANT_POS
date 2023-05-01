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
        roleServices.deleteAll();
    }

    @Test
    public void testCreate() {
        Role bean = new Role();
        bean.name = "admin";
        UUID id = UUID.randomUUID();
        bean.id = id;
        roleServices.create(bean);
        //test case1
        Role result = roleServices.getById(id);

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
        boolean result = instance.update(id,role);
        assertTrue(result);
        
        // Test Case2
        role.name = "analyst";
        result = instance.update(id,role);
        assertTrue(result);
        
        // Test Case3
        role.name = "analyst";
        result = instance.update(UUID.randomUUID(),role);
        assertFalse(result);

    }

    @Test
    public void testGetById() {
        Role role1 = new Role();
        role1.name = "admin";
        UUID id= UUID.randomUUID();  
        role1.id=id;
        roleServices.create(role1);
        
        //test case1
        Role expResult = role1;
        Role result = roleServices.getById(id);
        assertEquals(expResult.toString(), result.toString());
        
        //test case2
        result = roleServices.getById(UUID.randomUUID()); 
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
        
        int expSize = expResult.size();
        int resSize = result.size();
        assertEquals(expSize, resSize);
    }

    
    @Test
    public void testDeleteAll() {
        
        UserServices instance = new UserServices();
        Role role1 = new Role();
        role1.id = UUID.randomUUID();
        role1.name = "admin";
        
        Role role2 = new Role();
        role2.id = UUID.randomUUID();
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
