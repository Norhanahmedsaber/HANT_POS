/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Customers;

import Entities.Customer;
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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
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

    /**
     * Test of changecolor method, of class jNewCustomer.
     */
    @Test
    public void testChangecolor() {
        System.out.println("changecolor");
        Color c1 = null;
        Color c2 = null;
        Color c3 = null;
        Color c4 = null;
        Color c5 = null;
        jNewCustomer instance = null;
        instance.changecolor(c1, c2, c3, c4, c5);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getselecteditems method, of class jNewCustomer.
     */
    @Test
    public void testGetselecteditems() {
        System.out.println("getselecteditems");
        jNewCustomer instance = null;
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.getselecteditems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setselecteditems method, of class jNewCustomer.
     */
    @Test
    public void testSetselecteditems() {
        System.out.println("setselecteditems");
        ArrayList<Item> selecteditems = null;
        jNewCustomer instance = null;
        instance.setselecteditems(selecteditems);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateCustomer method, of class jNewCustomer.
     */
    @Test
    public void testValidateCustomer() {
        
    }

    /**
     * Test of validateNationalId method, of class jNewCustomer.
     */
    @Test
    public void testValidateNationalId() {
        jNewCustomer Instance = new jNewCustomer(null, null);
        String nationalId;
        boolean expected;
        // Branch Coverage
        // Test Case 1
        nationalId = "";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 2
        nationalId = "123abc45678910";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 3
        nationalId = "123456";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 4
        nationalId = "12345678912345";
        expected = true;
        boolean actual = Instance.validateNationalId(nationalId);
        assertEquals(expected, actual);
        
        // Condition Coverage
        // Test Case 1
        nationalId = "";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 2
        nationalId = "//1021654 6216";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 3
        nationalId = "kk123123212";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 4
        nationalId = "123456789123451231";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 5
        nationalId = "12345678912345";
        expected = true;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        //Multiple Condition Coverage
        // Test Case 1
        nationalId = "";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 2
        nationalId = "//023156kk 6546"; // T T T
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 3
        nationalId = "//654621kkk32"; // T T F
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 4
        nationalId = "//234234 23423"; // T F T
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 5
        nationalId = "//54651231512"; // T F F
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 6
        nationalId = "asd5465123 1512"; // F T T
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 7
        nationalId = "asd54651231512"; // F T F
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 8
        nationalId = "5465123 1512"; // F F T
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 9
        nationalId = "546512312"; // F F F
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 10
        nationalId = "32132132132112";
        expected = true;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Path Coverage
        // Test Case 1 (1 - 2 - 10)
        nationalId = "";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 2 (1 - 3 - 7 - 9 - 10)
        nationalId = "";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 3 (1 - 3 - 4 - 5 - 10)
        nationalId = "123asda12312";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 4 (1 - 3 - 4 - 6 - 3 - 7 - 9 - 10)
        nationalId = "123456";
        expected = false;
        assertEquals(expected, Instance.validateNationalId(nationalId));
        
        // Test Case 5 (1 - 3 - 4 - 6 - 3 - 7 - 8 - 10)
        nationalId = "12345678912312";
        expected = true;
        assertEquals(expected, Instance.validateNationalId(nationalId));
    }


    @Test
    public void testValidatePhoneNo() {
        jNewCustomer Instance = new jNewCustomer(null, null);
        String phone;
        boolean expected;
        // Branch Coverage
        // Test Case 1
        phone = "";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 2
        phone = "asdasd234";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 3
        phone = "5501021324";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 4
        phone = "011401";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 5
        phone = "01140112345";
        expected = true;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Condition Coverage
        // Test Case 1
        phone = "";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 2
        phone = "asdasd234";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 3 (F T)
        phone = "01546526";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 4 (T F) (T T)
        phone = "0123456";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 5 (F T)
        phone = "01234567891";
        expected = true;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 6 (T F)
        phone = "012345675";
        expected = true;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        //Multiple Condition Coverage
        // Test Case 1
        phone = "";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 2
        phone = "asdfargasd";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 3
        phone = "322342342"; // T T
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 4
        phone = "0223145688"; // T F
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 5
        phone = "0123145688234234"; // F T
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 6
        phone = "012345"; // T T
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 7
        phone = "01010101011";
        expected = true;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Path Coverage
        // Test Case 1 (1 - 2 - 10)
        phone = "";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 2 (1 - 3 - 4 - 10)
        phone = "asd";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 3 (1 - 3 - 5 - 6 - 10)
        phone = "22456456";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 4 (1 - 3 - 5 - 7 - 8 - 10)
        phone = "01112354567";
        expected = true;
        assertEquals(expected, Instance.validatePhoneNo(phone));
        
        // Test Case 5 (1 - 3 - 5 - 7 - 9 - 10)
        phone = "01555";
        expected = false;
        assertEquals(expected, Instance.validatePhoneNo(phone));
    }

    /**
     * Test of isValidChooseItem method, of class jNewCustomer.
     */
    @Test
    public void testIsValidChooseItem() {
        Customer customer = new Customer();
        boolean expected;
        jNewCustomer Instance = new jNewCustomer(null, null);
        
        //Branch Coverage
        //Test Case 1
        customer.name = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));

        //Test Case 2
        customer.name = "sayed3//";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 3
        customer.name = "sayed";
        customer.email = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 4
        customer.name = "sayed";
        customer.email = "sayed.com";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 5
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "123sdfsdf34";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 6
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "1235678912345";
        customer.phoneNumber = "sdfsdf";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 7
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12356789123454";
        customer.phoneNumber = "01236547890";
        expected = true;
        boolean actual = Instance.validateCustomer(customer);
        assertEquals(expected, actual);
        
        //Condition Coverage
        //Test Case 1
        customer.name = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));

        //Test Case 2
        customer.name = "a";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12356789123454";
        customer.phoneNumber = "01236547890";
        expected = true;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 3
        customer.name = "sayed3//";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 4
        customer.name = "sayed";
        customer.email = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 5
        customer.name = "sayed";
        customer.email = "sayed.com";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 6
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "123sdfsdf34";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 7
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "1235678912345";
        customer.phoneNumber = "sdfsdf";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 8
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12356789123454";
        customer.phoneNumber = "01236547890";
        expected = true;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Multiple Condition
        //Test Case 1
        customer.name = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));

        //Test Case 2
        customer.name = "a";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12356789123454";
        customer.phoneNumber = "01236547890";
        expected = true;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 3
        customer.name = "sayed3//";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 4
        customer.name = "sayed";
        customer.email = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 5
        customer.name = "sayed";
        customer.email = "sayed.com";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 6
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "123sdfsdf34";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 7
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "1235678912345";
        customer.phoneNumber = "sdfsdf";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 8
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12356789123454";
        customer.phoneNumber = "01236547890";
        expected = true;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Path Coverage
        //Test Case 1 (1 - 2 - 15)
        customer.name = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));

        //Test Case 2 (1 - 3 - 4 - 5 - 15)
        customer.name = "a234";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12356789123454";
        customer.phoneNumber = "01236547890";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 3 (1 - 3 - 7 - 8 - 15)
        customer.name = "1";
        customer.email = "";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 4 (1 - 3 - 4 - 6 - 3 - 7 - 9 - 10 - 15)
        customer.name = "sayed";
        customer.email = "sayed.com";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 5 (1 - 3 - 4 - 6 - 3 - 7 - 9 - 11 - 12 - 15)
        customer.name = "sayed";
        customer.email = "sayed.com";
        customer.nationalId = "123";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 6 (1 - 3 - 4 - 6 - 3 - 7 - 9 - 11 - 13 - 14 - 15)
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12334123123123";
        customer.phoneNumber = "asd";
        expected = false;
        assertEquals(expected, Instance.validateCustomer(customer));
        
        //Test Case 7 (1 - 3 - 4 - 6 - 3 - 7 - 9 - 11 - 13 - 15)
        customer.name = "sayed";
        customer.email = "sayed@mail.com";
        customer.nationalId = "12356789123454";
        customer.phoneNumber = "01236547890";
        expected = true;
        assertEquals(expected, Instance.validateCustomer(customer));
    }

    /**
     * Test of emailAdressen method, of class jNewCustomer.
     */
    @Test
    public void testEmailAdressen() {
        System.out.println("emailAdressen");
        String emailAdressen = "";
        boolean expResult = false;
        boolean result = jNewCustomer.emailAdressen(emailAdressen);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCustomerData method, of class jNewCustomer.
     */
    @Test
    public void testSaveCustomerData() {
        System.out.println("saveCustomerData");
        jNewCustomer instance = null;
        instance.saveCustomerData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearNewCustomerPage method, of class jNewCustomer.
     */
    @Test
    public void testClearNewCustomerPage() {
        System.out.println("clearNewCustomerPage");
        jNewCustomer instance = null;
        instance.clearNewCustomerPage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomerButton method, of class jNewCustomer.
     */
    @Test
    public void testAddCustomerButton() {
        System.out.println("addCustomerButton");
        jNewCustomer instance = null;
        instance.addCustomerButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BackButton method, of class jNewCustomer.
     */
    @Test
    public void testBackButton() {
        System.out.println("BackButton");
        jNewCustomer instance = null;
        instance.BackButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
    
}
