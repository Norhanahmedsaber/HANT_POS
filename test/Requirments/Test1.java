/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requirments;

import Entities.Role;
import Gui.Users.*;
import Gui.jHomePage;
import Gui.jMainPage;
import Services.AccountServices;
import Services.CustomerServices;
import Services.ItemServices;
import Services.LogServices;
import Services.RoleServices;
import Services.UserServices;
import java.awt.Color;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test1 {
    AccountServices accountServices;
    UserServices userServices;
    RoleServices roleServices;
    ItemServices itemServices;
    CustomerServices customerServices;
    LogServices logServices;
    public Test1() {
        accountServices = new AccountServices();
    }
    private void setUpRoles() {
        Role admin = new Role();
        admin.id = UUID.randomUUID();
        admin.name = "admin";
        admin.canCreateCustomer = true;
        admin.canCreateItem = true;
        admin.canViewLogs = true;
        roleServices.create(admin);
        
        Role role1 = new Role();
        role1.id = UUID.randomUUID();
        role1.name = "employee1";
        role1.canCreateCustomer = false;
        role1.canCreateItem = true;
        role1.canViewLogs = false;
        roleServices.create(role1);
        
        Role role2 = new Role();
        role2.id = UUID.randomUUID();
        role2.name = "employee2";
        role2.canCreateCustomer = true;
        role2.canCreateItem = true;
        role2.canViewLogs = false;
        roleServices.create(role2);
        
        Role role3 = new Role();
        role3.id = UUID.randomUUID();
        role3.name = "employee3";
        role3.canCreateCustomer = false;
        role3.canCreateItem = false;
        role3.canViewLogs = false;
        roleServices.create(role3);
    }
    @Before
    public void setUp() {
        userServices.deleteAll();
        roleServices.deleteAll();
        setUpRoles();
    }
    @Test
    public static void testCase1() {
        //Login
    }
  

}
