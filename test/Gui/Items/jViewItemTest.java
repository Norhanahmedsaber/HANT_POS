/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui.Items;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
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
public class jViewItemTest {
    
    public jViewItemTest() {
    }
    private jViewItem getInstance() {
        return new jViewItem(null, null, null);
    }
    @Test
    public void testCheckAllValidations() {
        jViewItem instance = getInstance();
        
        // Test Case 1
        instance.jDescriptionField.setText("aaa");
        instance.jCatgoryField.setText("aaa");
        instance.jNameField.setText("aaa");
        instance.jPriceField.setText("123");
        boolean expResult = true;
        boolean result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jDescriptionField.setText("");
        instance.jCatgoryField.setText("aaa");
        instance.jNameField.setText("aaa");
        instance.jPriceField.setText("123");
        expResult = false;
        result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        // Test Case 3
        instance.jDescriptionField.setText("aaa");
        instance.jCatgoryField.setText("");
        instance.jNameField.setText("aaa");
        instance.jPriceField.setText("123");
        expResult = false;
        result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        // Test Case 4
        instance.jDescriptionField.setText("aaa");
        instance.jCatgoryField.setText("aaa");
        instance.jNameField.setText("");
        instance.jPriceField.setText("123");
        expResult = false;
        result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        // Test Case 5
        instance.jDescriptionField.setText("aaa");
        instance.jCatgoryField.setText("aaa");
        instance.jNameField.setText("aaa");
        instance.jPriceField.setText("");
        expResult = false;
        result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        // Test Case 6
        instance.jDescriptionField.setText("aaa");
        instance.jCatgoryField.setText("aaa");
        instance.jNameField.setText("aaa");
        instance.jPriceField.setText("");
        expResult = false;
        result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
        
        // Test Case 7
        instance.jDescriptionField.setText("aaa");
        instance.jCatgoryField.setText("aaa");
        instance.jNameField.setText("aaa");
        instance.jPriceField.setText("aaa");
        expResult = false;
        result = instance.checkAllValidations();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testIsValidName() {
        jViewItem instance = getInstance();
        
        // Test Case 1
        instance.jNameField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidName();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jNameField.setText("Text");
        expResult = true;
        result = instance.isValidName();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidDescription() {
        jViewItem instance = getInstance();
        
        // Test Case 1
        instance.jDescriptionField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidDescription();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jDescriptionField.setText("Text");
        expResult = true;
        result = instance.isValidDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidPrice() {
        jViewItem instance = getInstance();
        
        // Test Case 1
        instance.jPriceField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidPrice();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jPriceField.setText("Text");
        expResult = false;
        result = instance.isValidPrice();
        assertEquals(expResult, result);
        
        // Test Case 3
        instance.jPriceField.setText("234");
        expResult = true;
        result = instance.isValidPrice();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidCatgory() {
        jViewItem instance = getInstance();
        
        // Test Case 1
        instance.jCatgoryField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidCatgory();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jCatgoryField.setText("Text");
        expResult = true;
        result = instance.isValidCatgory();
        assertEquals(expResult, result);
    }

    
}
