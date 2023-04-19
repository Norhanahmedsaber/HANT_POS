/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entities.Role;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class filterRolesTest {
    
    public filterRolesTest() {
    }
    private ArrayList getTestData()
    {
        ArrayList<String> roles = new ArrayList<>();
        String role1="Analyst";
        String role2="Threat hunter";
        String role3="Technical Support";
        String role4="software engineer";
        String role5="Accountant";
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);
        roles.add(role4);
        roles.add(role5);
        
        return roles;
        
    }
    
    

    
    @Test
    public void testFilter() {
        ArrayList<String> roleNames = getTestData();
        String searchName = "";
        filterRoles instance = new filterRoles();
        String role1=roleNames.get(0);
        String role2=roleNames.get(1);
        String role3=roleNames.get(2);
        String role4=roleNames.get(3);
        String role5=roleNames.get(4);
       
        //testcase :
        searchName="hun";
        ArrayList<String> expRoles = new ArrayList<>();
        expRoles.add(role2);
        ArrayList<String> result = instance.filter(roleNames, searchName);
        assertEquals(expRoles, result);
        
        
    }

    /**
     * Test of search method, of class filterRoles.
     */
    @Test
    public void testSearch() {
         ArrayList<String> roleNames = getTestData();
        String searchName = "";
        filterRoles instance = new filterRoles();
        String role1=roleNames.get(0);
        String role2=roleNames.get(1);
        String role3=roleNames.get(2);
        String role4=roleNames.get(3);
        String role5=roleNames.get(4);
       
        //testcase :
        searchName="e";
        ArrayList<String> expRoles = new ArrayList<>();
        expRoles.add(role2);
        expRoles.add(role3);
        expRoles.add(role4);
        ArrayList<String> result = instance.filter(roleNames, searchName);
        assertEquals(expRoles, result);
    }
    
}
