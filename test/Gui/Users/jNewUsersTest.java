/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Users;

import Gui.jHomePage;
import Gui.jMainPage;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author norha
 */
public class jNewUsersTest {
    
    public jNewUsersTest() {
    }
    
  public jNewUsers getinstance()
  {
     return new  jNewUsers(null, null);
  }

//    @Test
//    public void testChangecolor() {
//        System.out.println("changecolor");
//        Color c1 = null;
//        Color c2 = null;
//        Color c3 = null;
//        Color c4 = null;
//        Color c5 = null;
//        jNewUsers instance = null;
//        instance.changecolor(c1, c2, c3, c4, c5);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        jNewUsers instance = getinstance();
        
        //test case1
        instance.jNameField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidName();
        assertEquals(expResult, result);
        
        //test case2
        instance.jNameField.setText("nora");
         expResult = true;
         result = instance.isValidName();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidUserName method, of class jNewUsers.
     */
    @Test
    public void testIsValidUserName() {
        System.out.println("isValidUserName");
        jNewUsers instance = getinstance();
        
        //test casse1
        instance.jUsernameField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidUserName();
        assertEquals(expResult, result);
       
        //test casse2
        instance.jUsernameField.setText("nora");
        expResult = true;
        result = instance.isValidUserName();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        jNewUsers instance = getinstance();
        
        //test case1
        instance.jPasswordField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidPassword();
        assertEquals(expResult, result);
        
        //test case2
        instance.jPasswordField.setText("8");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
         //test case3
        instance.jPasswordField.setText("88");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
         //test case4
        instance.jPasswordField.setText("888");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
         //test case5
        instance.jPasswordField.setText("8888");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
         //test case6
        instance.jPasswordField.setText("88888");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
        //test case7
        instance.jPasswordField.setText("888888");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
        //test case8
        instance.jPasswordField.setText("8888888");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
        //test case9
        instance.jPasswordField.setText("88888888");
        expResult = true;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
        //testcase10
        instance.jPasswordField.setText("n");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
         //testcase11
        instance.jPasswordField.setText("");
        expResult = false;
        result = instance.isValidPassword();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testCheckAllValidations() {
        System.out.println("checkAllValidations");
        jNewUsers instance = getinstance();
        
        //test case1
        boolean expResult = false;
        boolean result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //test case2
        instance.jNameField.setText("nora");
        instance.jUsernameField.setText("nora");
        instance.jPasswordField.setText("88888888");
        expResult = true;
         result= instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //test case3
        instance.jNameField.setText("");
        instance.jUsernameField.setText("nora");
        instance.jPasswordField.setText("88888888");
        expResult = false;
         result= instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //test case4
        instance.jNameField.setText("nora");
        instance.jUsernameField.setText("");
        instance.jPasswordField.setText("88888888");
        expResult = false;
         result= instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //test case5
        instance.jNameField.setText("nora");
        instance.jUsernameField.setText("nora");
        instance.jPasswordField.setText("");
        expResult = false;
        result= instance.checkAllValidations();
        assertEquals(expResult, result);
        
          //test case6
        instance.jNameField.setText("nora");
        instance.jUsernameField.setText("nora");
        instance.jPasswordField.setText("n");
        expResult = false;
        result= instance.checkAllValidations();
        assertEquals(expResult, result);
        
          //test case7
        instance.jNameField.setText("nora");
        instance.jUsernameField.setText("nora");
        instance.jPasswordField.setText("1");
        expResult = false;
        result= instance.checkAllValidations();
        assertEquals(expResult, result);
       
    }
//    @Test
//    public void testSaveUserData() {
//        System.out.println("saveUserData");
//        jNewUsers instance = null;
//        instance.saveUserData();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
