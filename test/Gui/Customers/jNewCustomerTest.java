/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Customers;

import Entities.Item;
import Gui.jHomePage;
import com.mysql.cj.protocol.x.XProtocolDecoder;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
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
public class jNewCustomerTest {
    
    public jNewCustomerTest() {
    }


    
    public jNewCustomer getInstance()
    {
        return new jNewCustomer(new jHomePage(), new JPanel());
    }
    
    
   
    @Test
    public void testIsValidName() {
        jNewCustomer instance = getInstance();
        
        //testcase 1 :
        instance.jNameField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidName();
        assertEquals(expResult, result);
        
        
       //testcase 2:
       instance.jNameField.setText("2324tt");
       expResult=false;
       result = instance.isValidName();
       assertEquals(expResult, result);
        
        //testcase 3 :
        instance.jNameField.setText("toka");
        expResult=true;
        result=instance.isValidName();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of isValidEmail method, of class jNewCustomer.
     */
    @Test
    public void testIsValidEmail() {
        jNewCustomer instance = getInstance();
        //testcase 1 :
        instance.jEmailField.setText("example@gmail.com");
        boolean expresult=true;
        boolean result = instance.isValidEmail();
        assertEquals(expresult, result);
        
        //testcase 2 :
        instance.jEmailField.setText("");
        expresult=false;
        result=instance.isValidEmail();
        assertEquals(expresult, result);
        
    }

    /**
     * Test of isValidNationalId method, of class jNewCustomer.
     */
    @Test
    public void testIsValidNationalId() {
        jNewCustomer instance = getInstance();
        
        //testcase 1
        instance.jNationalIdField.setText(" ");
        boolean expResult = false;
        boolean result = instance.isValidNationalId();
        assertEquals(expResult, result);
        
        //testcase 2 :
        instance.jNationalIdField.setText("3010hh12100865");
        expResult=false;
        result = instance.isValidNationalId();
        assertEquals(expResult, result);
        
        //testcase 3:
        instance.jNationalIdField.setText("30105212100685");
        expResult=true;
        result=instance.isValidNationalId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isValidPhoneNo method, of class jNewCustomer.
     */
    @Test
    public void testIsValidPhoneNo() {
        jNewCustomer instance = getInstance();
        //testcase 1 :
        instance.jPhoneNoField.setText("");
        boolean expResult = false ;
        boolean result = instance.isValidPhoneNo();
        assertEquals(expResult, result);
        
        //testcase 2 
        instance.jPhoneNoField.setText("011fdsf");
        expResult = false;
        result = instance.isValidPhoneNo();
        assertEquals(expResult, result);
        
        //testcase 3 
        instance.jPhoneNoField.setText("011402198");
        expResult=false;
        result=instance.isValidPhoneNo();
        assertEquals(expResult, result);
        
        //testcase 4 
        instance.jPhoneNoField.setText("01140216810");
        expResult=true;
        result = instance.isValidPhoneNo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isValidAge method, of class jNewCustomer.
     */
    @Test
    public void testIsValidAge() {
        jNewCustomer instance = getInstance();
        
        //testcase 1 :
        instance.jAgeField.setText(" ");
        boolean expResult=false;
        boolean result=instance.isValidAge();
        
        //testcase 2 :
        instance.jAgeField.setText(" ");
        expResult=false;
        result = instance.isValidAge();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkAllValidations method, of class jNewCustomer.
     */
    @Test
    public void testCheckAllValidations() {
       jNewCustomer instance = getInstance();
        //testecase 1 
        instance.jNameField.setText("toka");
        instance.jAgeField.setText("");
        instance.jEmailField.setText("example");
        instance.jPhoneNoField.setText("01140219810");
        instance.jNationalIdField.setText("12825286152545");
        Item item = new Item();
        item.name="oven";
        instance._chosenitems.add(item);
        boolean expResult = false;
        boolean result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //testcase 2 :
        instance.jNameField.setText("toka");
        instance.jAgeField.setText("21");
        instance.jEmailField.setText("example");
        instance.jPhoneNoField.setText("01140219810");
        instance.jNationalIdField.setText("12825286152545");
        expResult = false;
         result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //testcase 3 :
        instance.jNameField.setText("toka");
        instance.jAgeField.setText("21");
        instance.jEmailField.setText("example@gmail.com");
        instance.jPhoneNoField.setText("0114");
        instance.jNationalIdField.setText("12825286152545");
        expResult = false;
         result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //testcase 4 :
         instance.jNameField.setText("toka");
        instance.jAgeField.setText("21");
        instance.jEmailField.setText("example@gmail.com");
        instance.jPhoneNoField.setText("01140219810");
        instance.jNationalIdField.setText("128hhhh");
        expResult = false;
         result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        //testcase 5 :
         instance.jNameField.setText("toka");
        instance.jAgeField.setText("21");
        instance.jEmailField.setText("tokaabdelgawad60@gmail.com");
        instance.jPhoneNoField.setText("01140219810");
        instance.jNationalIdField.setText("30105212100685");
        expResult = true;
        result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        
        
    }


    
    
}
