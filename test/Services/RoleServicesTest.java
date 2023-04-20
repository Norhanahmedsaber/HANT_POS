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
    
    public RoleServicesTest() {
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
        Role role = null;
        RoleServices instance = new RoleServices();
        instance.create(role);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        UUID roleId = null;
        Role role = null;
        RoleServices instance = new RoleServices();
        instance.update(roleId, role);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        UUID id = null;
        RoleServices instance = new RoleServices();
        instance.getById(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        RoleServices instance = new RoleServices();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
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
    
}
